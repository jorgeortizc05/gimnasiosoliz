package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.FormaPagoBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Ejercicio;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.FormaPago;

@ManagedBean
public class FormaPagoController {
	
	@Inject
	private FormaPagoBussiness fpBuss;
	
	@Inject
	private FacesContext facesContext;
	
	private FormaPago newFormaPago;
	private List<FormaPago> formaPagos;
	private List<FormaPago> filterFormaPagos;
	//Variable para verificar si estas editando
	private boolean vEditing;
	private int vIdFormaPago;
	private String vTitulo;
	
	@PostConstruct
	public void init() {
		newFormaPago = new FormaPago();
		vEditing = false;
		vTitulo = "NUEVO";
		loadFormaPagos();
	}
	
	//Guarda y actualiza FormaPago con control de exceptions
	public String guardarFormaPago() {
		try {
			if(vEditing)
				fpBuss.doActualizar(newFormaPago);
			else
				
				fpBuss.doGuardar(newFormaPago);
			return "list-forma-pagos?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		return null;
	}
	
	public void cargarFormaPago() {
		System.out.println("load data " + vIdFormaPago);
		if(vIdFormaPago==0)
			return;
		try {
			newFormaPago = fpBuss.getFormaPago(vIdFormaPago);
			System.out.println(newFormaPago);
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
	
	//Carga un objeto FormaPago en el formulario y se activa la edicion
	public String editarFormaPago(FormaPago tp) {
		//newFormaPago = ts;
		vEditing = true;
		vTitulo = "EDITAR";
		return "nueva-forma-pago?faces-redirect=true&id="+tp.getIdFormaPago();
	}
	
	//Elimina FormaPago con base id
	public String eliminarFormaPago(int id) {
		try {
			fpBuss.doEliminar(id);
			loadFormaPagos();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		
		return null;
	}
	
	//Carga todos los FormaPago en el formulario
	public void loadFormaPagos() {
		formaPagos = fpBuss.getFormaPagos();
	}

	public FormaPago getNewFormaPago() {
		return newFormaPago;
	}

	public void setNewFormaPago(FormaPago newFormaPago) {
		this.newFormaPago = newFormaPago;
	}

	public List<FormaPago> getFormaPagos() {
		return formaPagos;
	}

	public void setFormaPagos(List<FormaPago> formaPagos) {
		this.formaPagos = formaPagos;
	}

	public List<FormaPago> getFilterFormaPagos() {
		return filterFormaPagos;
	}

	public void setFilterFormaPagos(List<FormaPago> filterFormaPagos) {
		this.filterFormaPagos = filterFormaPagos;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public int getvIdFormaPago() {
		return vIdFormaPago;
	}

	public void setvIdFormaPago(int vIdFormaPago) {
		this.vIdFormaPago = vIdFormaPago;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

	
}
