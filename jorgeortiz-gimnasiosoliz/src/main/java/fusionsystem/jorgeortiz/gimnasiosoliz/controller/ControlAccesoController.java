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
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.ControlAccesoBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Suscripcion;

@ManagedBean
public class ControlAccesoController {

	@Inject
	private ControlAccesoBussiness caBuss;
	
	private Persona newPersona;
	private Suscripcion newSuscripcion;
	//Variables
	private String vCedula;
	private int vDias;
	private String vColorAdvertencia = "#070719";
	
	private String vMensajeAdvertencia = "Ya vencio";
	
	@PostConstruct
	public void init() {
		newPersona = new Persona();
		newSuscripcion = new Suscripcion();
	}
	
	
	public String leerCodigo() {
		System.out.println(vCedula);
		enviarFotosServidor(vCedula);
		newPersona = caBuss.getPersona(vCedula);
		
		newSuscripcion = caBuss.getSuscripcione(newPersona.getIdPersona());
		System.out.println(newSuscripcion);
		vDias = caBuss.calcularDiasRestantes(newSuscripcion);
		
		if(vDias <= 0) {
			vMensajeAdvertencia = "PAGAR POR VENTANILLA";
			vColorAdvertencia = "#FF0040";
			vDias = 0;
		}else
		{
			vMensajeAdvertencia = "CORRECTO";
			vColorAdvertencia = "#070719";
		}
		
		vCedula = "";
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
	
	
	
}
