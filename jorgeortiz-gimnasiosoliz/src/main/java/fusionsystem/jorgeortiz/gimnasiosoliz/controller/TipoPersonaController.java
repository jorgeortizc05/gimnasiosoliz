package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.TipoPersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Ejercicio;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@ManagedBean
public class TipoPersonaController {

	@Inject
	private TipoPersonaBussiness tperBuss;
	
	@Inject
	private FacesContext facesContext;
	
	private TipoPersona newTipoPersona;
	private List<TipoPersona> tipoPersonas;
	private boolean vEditing;
	private int vIdTipoPersona;
	private String vTitulo;
	
	@PostConstruct
	public void init() {
		newTipoPersona = new TipoPersona();
		vEditing = false;
		vTitulo = "NUEVO";
		loadTipoPersonas();
	}
	
	//Guarda y actualiza TipoPersona con control de exceptions
	public String guardarTipoPersona() {
		try {
			if(vEditing)
				tperBuss.doActualizar(newTipoPersona);
			else
				
				tperBuss.doGuardar(newTipoPersona);
			return "list-tipo-personas?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		return null;
	}
	
	public void cargarTipoPersona() {
		System.out.println("load data " + vIdTipoPersona);
		if(vIdTipoPersona==0)
			return;
		try {
			newTipoPersona = tperBuss.getTipoPersona(vIdTipoPersona);
			System.out.println(newTipoPersona);
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
	
	//Carga un objeto TipoPersona en el formulario y se activa la edicion
	public String editarTipoPersona(TipoPersona tp) {
		//newTipoPersona = ts;
		vEditing = true;
		vTitulo = "EDITAR";
		return "nuevo-tipo-persona?faces-redirect=true&id="+tp.getIdTipoPersona();
	}
	
	//Elimina TipoPersona con base id
	public String eliminarTipoPersona(int id) {
		try {
			tperBuss.doEliminar(id);
			loadTipoPersonas();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		
		return null;
	}
	
	//Carga todos los TipoPersona en el formulario
	public void loadTipoPersonas() {
		tipoPersonas = tperBuss.getTipoPersonas();
	}

	public TipoPersona getNewTipoPersona() {
		return newTipoPersona;
	}

	public void setNewTipoPersona(TipoPersona newTipoPersona) {
		this.newTipoPersona = newTipoPersona;
	}

	public List<TipoPersona> getTipoPersonas() {
		return tipoPersonas;
	}

	public void setTipoPersonas(List<TipoPersona> tipoPersonas) {
		this.tipoPersonas = tipoPersonas;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public int getvIdTipoPersona() {
		return vIdTipoPersona;
	}

	public void setvIdTipoPersona(int vIdTipoPersona) {
		this.vIdTipoPersona = vIdTipoPersona;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}
	
	
}
