package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.RutinaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Ejercicio;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Rutina;

@ManagedBean
@ViewScoped
public class RutinaController {
	
	@Inject
	private RutinaBussiness rutBuss;
	
	@Inject
	private FacesContext facesContext;
	
	private Rutina newRutina;
	private List<Rutina> rutinas;
	private List<Rutina> filterCars;
	private Ejercicio newEjercicio;
	//Variable para verificar si estas editando
	private boolean vEditing;
	private int vIdRutina;
	private String vTitulo;
	
	@PostConstruct
	public void init() {
		newRutina = new Rutina();
		newEjercicio = new Ejercicio();
		vEditing = false;
		vTitulo = "NUEVO";
		loadRutinas();
	}
	
	//Guarda y actualiza Rutina con control de exceptions
	public String guardarRutina() {
		try {
			if(vEditing)
				rutBuss.doActualizar(newRutina);
			else
				
				rutBuss.doGuardar(newRutina);
			return "list-rutinas?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		return null;
	}
	
	public void cargarRutina() {
		System.out.println("load data " + vIdRutina);
		if(vIdRutina==0)
			return;
		try {
			newRutina = rutBuss.getRutina(vIdRutina);
			System.out.println(newRutina);
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
	
	//Carga un objeto Rutina en el formulario y se activa la edicion
	public String editarRutina(Rutina tp) {
		//newRutina = ts;
		vEditing = true;
		vTitulo = "EDITAR";
		return "nueva-rutina?faces-redirect=true&id="+tp.getIdRutina();
	}
	
	//Elimina Rutina con base id
	public String eliminarRutina(int id) {
		try {
			rutBuss.doEliminar(id);
			loadRutinas();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		
		return null;
	}
	
	public String addEjercicio() {
		newRutina.addEjercicio(newEjercicio);
		newEjercicio = new Ejercicio();
		return null;
	}
	
	public String removeEjercicio(Ejercicio ejercicio) {
		newRutina.removeEjercicio(ejercicio);
		
		return null;
	}
	
	//Carga todos los Rutina en el formulario
	public void loadRutinas() {
		rutinas = rutBuss.getRutinas();
	}

	//Setter and Getters
	public Rutina getNewRutina() {
		return newRutina;
	}

	public void setNewRutina(Rutina newRutina) {
		this.newRutina = newRutina;
	}

	public List<Rutina> getRutinas() {
		return rutinas;
	}

	public void setRutinas(List<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public List<Rutina> getFilterCars() {
		return filterCars;
	}

	public void setFilterCars(List<Rutina> filterCars) {
		this.filterCars = filterCars;
	}

	public Ejercicio getNewEjercicio() {
		return newEjercicio;
	}

	public void setNewEjercicio(Ejercicio newEjercicio) {
		this.newEjercicio = newEjercicio;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public int getvIdRutina() {
		return vIdRutina;
	}

	public void setvIdRutina(int vIdRutina) {
		this.vIdRutina = vIdRutina;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}
	
}
