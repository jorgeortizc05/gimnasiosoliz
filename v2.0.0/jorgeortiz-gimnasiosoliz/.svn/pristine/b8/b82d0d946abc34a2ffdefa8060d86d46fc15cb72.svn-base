package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.ControlAccesoBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.PersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.TipoPersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;
import fusionsystem.jorgeortiz.gimnasiosoliz.reporte.TarjetaGimnasio;
import fusionsystem.jorgeortiz.gimnasiosoliz.util.UbicacionArchivo;
import net.sf.jasperreports.engine.JRException;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Complexion;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;

@ManagedBean
@ViewScoped
public class PersonaController {

	@Inject
	private PersonaBussiness perBuss;
	
	@Inject 
	private TipoPersonaBussiness tpBuss;
	
	@Inject
	private ControlAccesoBussiness caBuss;
	
	@Inject
	private FacesContext facesContext;
	
	private Persona newPersona;
	private List<Persona> personas;
	private List<Persona> filterPersonas;
	private List<TipoPersona> tipoPersonas;
	private Complexion newComplexion;
	//Variable para verificar si estas editando
	private boolean vEditing;
	private int vIdPersona;
	private String vTitulo;
	private TarjetaGimnasio tarjetaGimnasio;
	//Recupera idTipoPersona del combo
	private int vIdTipoPersona;
	
	//Ver el estado de la suscripcion
	private String vEstadoSuscripcion;
	
	@PostConstruct
	public void init() {
		newPersona = new Persona();
		newComplexion = new Complexion();
		tipoPersonas = tpBuss.getTipoPersonas();
		tarjetaGimnasio = new TarjetaGimnasio();
		vEditing = false;
		vTitulo = "NUEVO";
		vEstadoSuscripcion = "";
		loadPersonaSuscripciones();
	}
	
	//Guarda y actualiza Persona con control de exceptions
	public String guardarPersona() {
		TipoPersona tpersona = new TipoPersona();
		tpersona.setIdTipoPersona(vIdTipoPersona);
		newPersona.setTipoPersona(tpersona);
		//Hago todo a mayusculas
		newPersona.setNombres(newPersona.getNombres().toUpperCase());
		try {
			if(vEditing)
				perBuss.doActualizar(newPersona);
			else
				
				perBuss.doGuardar(newPersona);
			return "list-personas?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		return null;
	}
	
	public void cargarPersona() {
		System.out.println("load data " + vIdPersona);
		if(vIdPersona==0)
			return;
		try {
			newPersona = perBuss.getPersona(vIdPersona);
			System.out.println(newPersona);
			vEditing = true;
			vTitulo = "EDITAR";
			enviarFotosServidor(newPersona.getCedula());
			foto = newPersona.getCedula();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}

	}
	
	public void generarTarjetaPorPersona(String cedula) throws JRException, IOException {
		tarjetaGimnasio.generarTarjetaPorPersona(cedula);
	}
	
	//Carga un objeto Persona en el formulario y se activa la edicion
	public String editarPersona(Persona p) {
		//newPersona = ts;
		vEditing = true;
		vTitulo = "EDITAR";
		return "nueva-persona?faces-redirect=true&id="+p.getIdPersona();
	}
	
	//Elimina Persona con base id
	public String eliminarPersona(int id) {
		try {
			perBuss.doEliminar(id);
			loadPersonas();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "No existe la persona");
            facesContext.addMessage(null, m);

		}
		
		return null;
	}
	
	public String addComplexion() {
		newPersona.addComplexion(newComplexion);
		newComplexion = new Complexion();
		return null;
	}
	
	public String removeComplexion(Complexion complexion) {
		newPersona.removeComplexion(complexion);
		
		return null;
	}

	
	//Carga todos los Persona en el formulario
	public void loadPersonas() {
		
		personas = perBuss.getPersonas();
	}	
	
	//Se creo para obtener una etiqueta de ACTIVO para personas con suscripcion de inactividad
	//menor a 2 meses e INACTIVO para aquellas personas con inactividad mayor a 6 meses.
	public void loadPersonaSuscripciones() {
		personas = perBuss.getPersonaSuscripciones();
		int dia = 0;
			for(Persona per: personas) {
				try {
				//Calculo el dia segun la ultima suscripcion registrada
				if(per.getSuscripciones() != null) {
					dia = caBuss.calcularDiasRestantes(per.getSuscripciones().get(per.getSuscripciones().size()-1));//ultima suscripcion
					if(dia > -60) {
						per.setActivo("activo");
						//vEstadoSuscripcion = "activo";
					}else if(dia < -60) {
						per.setActivo("inactivo");
					}else {
						per.setActivo("Sin suscripcion");
					}
					dia = 0;
				}else {
					dia = 0;
					per.setActivo("Desconocido");
				}
				}catch (Exception e) {
					System.out.println(e.getMessage());;
					System.out.println("Problemas al calcular los dias y la suscripciones");
				}
				
			}
		
		
	}
	
	//Validar cedula
	public void valida(String x){
	    int suma=0;
	    if(x.length()==9){
	      System.out.println("Ingrese su cedula de 10 digitos");
	      FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese su cedula de 10 digitos", "Error");
          facesContext.addMessage(null, m);
	    }else{
	      int a[]=new int [x.length()/2];
	      int b[]=new int [(x.length()/2)];
	      int c=0;
	      int d=1;
	      for (int i = 0; i < x.length()/2; i++) {
	        a[i]=Integer.parseInt(String.valueOf(x.charAt(c)));
	        c=c+2;
	        if (i < (x.length()/2)-1) {
	          b[i]=Integer.parseInt(String.valueOf(x.charAt(d)));
	          d=d+2;
	        }
	      }
	    
	      for (int i = 0; i < a.length; i++) {
	        a[i]=a[i]*2;
	        if (a[i] >9){
	          a[i]=a[i]-9;
	        }
	        suma=suma+a[i]+b[i];
	      } 
	      int aux=suma/10;
	      int dec=(aux+1)*10;
	      if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length()-1)))) {
	    	  FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Cedula Correcta");
          	  facesContext.addMessage(null, m);
	      }
	      else
	        if(suma%10==0 && x.charAt(x.length()-1)=='0'){
	        	FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Cedula Correcta");
	          	 facesContext.addMessage(null, m);
	        }else{
	        	FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cedula incorrecta");
	          	facesContext.addMessage(null, m);
	        }
	    }
	     
	  }
	
	///TODO CON LA FOTO
	private String foto;
	 
	public void oncapture(CaptureEvent captureEvent) {
 
		// obtenemos los datos de la foto como array de bytes
		final byte[] datos = captureEvent.getData();
 
		final ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext()
				.getContext();
		// le asignamos el nombre que sea a la imagen (en este caso siempre el mismo)
		this.foto = newPersona.getCedula();
		// ruta destino de la imagen /photocam/foto.png
		final String fileFoto = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "gimnasiosoliz"+ File.separator + "camera" + File.separator + foto+".png";
		System.out.println("//////////////////////////////////////////////");
		System.out.println(fileFoto);
		FileImageOutputStream outputStream = null;
		try {
			outputStream = new FileImageOutputStream(new File(fileFoto));
			// guardamos la imagen
			outputStream.write(datos, 0, datos.length);
			copiarArchivo(fileFoto, UbicacionArchivo.getPathOrigenFotos()+newPersona.getCedula()+".png");
		} catch (IOException e) {
			throw new FacesException("Error guardando la foto.", e);
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
			}
		}
	}
	
	public void copiarArchivo(String origen, String destino) throws IOException {
		Path ORIGEN = Paths.get(origen);
		Path DESTINO = Paths.get(destino);
		// sobreescribir el fichero de destino, si existe, y copiar
		// los atributos, incluyendo los permisos rwx
		CopyOption[] options = new CopyOption[] { StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.COPY_ATTRIBUTES };
		Files.copy(ORIGEN, DESTINO, options);
	}
	
	//Copia las fotos de una ruta hacia el servidor para poder ser leido.
	//Cada vez que el servidor se apaga,esta borra todos sus datos incluido las fotos.
	public void enviarFotosServidor(String cedula) {
		final ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
		try {
			String origen = UbicacionArchivo.getPathOrigenFotos()+cedula+".png";
			String destino = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "gimnasiosoliz"+ File.separator + "camera" + File.separator + cedula +".png";
			System.out.println("Ruta de mis fotos socios "+origen);
			System.out.println("Ruta del servidor "+destino);
			copiarArchivo(origen, destino);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	public String getFoto() {
		return foto;
	}
 
	public boolean isVerFoto() {
		return foto != null;
	}
	
	//Setter and Getters
	public Persona getNewPersona() {
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public List<Persona> getFilterPersonas() {
		return filterPersonas;
	}

	public void setFilterPersonas(List<Persona> filterPersonas) {
		this.filterPersonas = filterPersonas;
	}
	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public int getvIdPersona() {
		return vIdPersona;
	}

	public void setvIdPersona(int vIdPersona) {
		this.vIdPersona = vIdPersona;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

	public int getvIdTipoPersona() {
		return vIdTipoPersona;
	}

	public void setvIdTipoPersona(int vIdTipoPersona) {
		this.vIdTipoPersona = vIdTipoPersona;
	}

	public List<TipoPersona> getTipoPersonas() {
		return tipoPersonas;
	}

	public void setTipoPersonas(List<TipoPersona> tipoPersonas) {
		this.tipoPersonas = tipoPersonas;
	}

	
}
