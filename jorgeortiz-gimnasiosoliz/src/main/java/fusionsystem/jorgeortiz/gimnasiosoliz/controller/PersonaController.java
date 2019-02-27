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

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.PersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.TipoPersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Telefono;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;
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
	private FacesContext facesContext;
	
	private Persona newPersona;
	private List<Persona> personas;
	private List<Persona> filterPersonas;
	private List<TipoPersona> tipoPersonas;
	private Telefono newTelefono;
	private Complexion newComplexion;
	//Variable para verificar si estas editando
	private boolean vEditing;
	private int vIdPersona;
	private String vTitulo;
	//Recupera idTipoPersona del combo
	private int vIdTipoPersona;
	
	@PostConstruct
	public void init() {
		newPersona = new Persona();
		newTelefono = new Telefono();
		newComplexion = new Complexion();
		tipoPersonas = tpBuss.getTipoPersonas();
		vEditing = false;
		vTitulo = "NUEVO";
		loadPersonas();
	}
	
	//Guarda y actualiza Persona con control de exceptions
	public String guardarPersona() {
		TipoPersona tpersona = new TipoPersona();
		tpersona.setIdTipoPersona(vIdTipoPersona);
		newPersona.setTipoPersona(tpersona);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}

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
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		
		return null;
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
	
	public String addTelefono() {
		newPersona.addTelefono(newTelefono);
		newTelefono = new Telefono();
		return null;
	}
	
	public String removeTelefono(Telefono ejercicio) {
		newPersona.removeTelefono(ejercicio);
		
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
			copiarArchivo(fileFoto, "/fusionsystem/jorgeortiz/fotos-socios/"+foto+".png");
		} catch (IOException e) {
			throw new FacesException("Error guardando la foto.", e);
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
			}
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

	public Telefono getNewTelefono() {
		return newTelefono;
	}

	public void setNewTelefono(Telefono newTelefono) {
		this.newTelefono = newTelefono;
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
