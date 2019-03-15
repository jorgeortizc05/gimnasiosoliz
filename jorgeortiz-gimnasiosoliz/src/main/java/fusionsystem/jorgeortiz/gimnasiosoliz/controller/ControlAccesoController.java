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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.ControlAccesoBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Complexion;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Suscripcion;

@ManagedBean
@ViewScoped
public class ControlAccesoController {

	@Inject
	private ControlAccesoBussiness caBuss;
	
	@Inject
	private FacesContext facesContext;
	
	private Persona newPersona;
	private Suscripcion newSuscripcion;
	private List<Suscripcion> suscripciones;
	//Variables
	private String vCedula;
	private int vDias;
	private String vColorAdvertencia = "red";
	private String vEstadoCorporal = "";
	private int vIdPersona;
	
	private String vMensajeAdvertencia = "Ya vencio";
	
	@PostConstruct
	public void init() {
		newPersona = new Persona();
		newSuscripcion = new Suscripcion();
		
	}
	
	
	public String leerCodigo() {
		System.out.println(vCedula);
		enviarFotosServidor(vCedula);
		
		try {
			newPersona = caBuss.getPersona(vCedula);
			if(newPersona.getComplexiones().size()>0) {
				Complexion comple = newPersona.getComplexiones().get(0);
				System.out.println(comple);
				vEstadoCorporal = caBuss.estadoCorporal(comple);
			}
			
			suscripciones = caBuss.getSuscripcionesPersona(newPersona.getIdPersona());
			newSuscripcion = caBuss.getSuscripcione(newPersona.getIdPersona());
			System.out.println(newSuscripcion);
			vDias = caBuss.calcularDiasRestantes(newSuscripcion);
			
			if(vDias <= 0) {
				vMensajeAdvertencia = "PAGAR POR VENTANILLA";
				vColorAdvertencia = "red";
				vDias = 0;
			}else
			{
				vMensajeAdvertencia = "CORRECTO";
				vColorAdvertencia = "black";
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error, persona no existe");
            facesContext.addMessage(null, m);
		}
		vCedula = "";
		
		return null;
		
	}
	
	public void cargarPersona() {
		System.out.println("load data " + vIdPersona);
		if(vIdPersona==0)
			return;
		try {
			newPersona = caBuss.getPersona(vIdPersona);
			//Cargo las suscripciones que tiene la persona
			suscripciones = caBuss.getSuscripcionesPersona(newPersona.getIdPersona());
			System.out.println(newPersona);
			//vEditing = true;
			//vTitulo = "EDITAR";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(), "Error al cargar la persona");
            facesContext.addMessage(null, m);
		}

	}
	
	public String nuevaSuscripcion() {
		return "nueva-suscripcion?faces-redirect=true&id="+newPersona.getIdPersona();
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
	
	public void enviarFotosServidor(String cedula) {
		final ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
		try {
			String origen = "/fusionsystem/jorgeortiz/fotos-socios/"+cedula+".png";
			String destino = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "gimnasiosoliz"+ File.separator + "camera" + File.separator + cedula +".png";
			System.out.println("Ruta de mis fotos socios "+origen);
			System.out.println("Ruta del servidor "+destino);
			copiarArchivo(origen, destino);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getvCedula() {
		return vCedula;
	}

	public void setvCedula(String vCedula) {
		this.vCedula = vCedula;
	}


	public Persona getNewPersona() {
		return newPersona;
	}


	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
	}


	public String getvMensajeAdvertencia() {
		return vMensajeAdvertencia;
	}


	public void setvMensajeAdvertencia(String vMensajeAdvertencia) {
		this.vMensajeAdvertencia = vMensajeAdvertencia;
	}


	public Suscripcion getNewSuscripcion() {
		return newSuscripcion;
	}


	public void setNewSuscripcion(Suscripcion newSuscripcion) {
		this.newSuscripcion = newSuscripcion;
	}


	public int getvDias() {
		return vDias;
	}


	public void setvDias(int vDias) {
		this.vDias = vDias;
	}


	public String getvColorAdvertencia() {
		return vColorAdvertencia;
	}


	public void setvColorAdvertencia(String vColorAdvertencia) {
		this.vColorAdvertencia = vColorAdvertencia;
	}


	public String getvEstadoCorporal() {
		return vEstadoCorporal;
	}


	public void setvEstadoCorporal(String vEstadoCorporal) {
		this.vEstadoCorporal = vEstadoCorporal;
	}


	public List<Suscripcion> getSuscripciones() {
		return suscripciones;
	}


	public void setSuscripciones(List<Suscripcion> suscripciones) {
		this.suscripciones = suscripciones;
	}


	public int getvIdPersona() {
		return vIdPersona;
	}


	public void setvIdPersona(int vIdPersona) {
		this.vIdPersona = vIdPersona;
	}
	
}
