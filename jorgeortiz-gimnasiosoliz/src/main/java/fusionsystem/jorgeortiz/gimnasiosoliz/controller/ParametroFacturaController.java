package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.ParametroFacturaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Ejercicio;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.ParametroFactura;

@ManagedBean
public class ParametroFacturaController {
	
	@Inject
	private ParametroFacturaBussiness pfBuss;
	
	@Inject
	private FacesContext facesContext;
	
	private ParametroFactura newParametroFactura;
	private List<ParametroFactura> parametroFacturas;
	private List<ParametroFactura> filterParametroFacturas;
	//Variable para verificar si estas editando
	private boolean vEditing;
	private int vIdParametroFactura;
	private String vTitulo;
	
	@PostConstruct
	public void init() {
		newParametroFactura = new ParametroFactura();
		vEditing = false;
		vTitulo = "NUEVO";
		loadParametroFacturas();
	}
	
	//Guarda y actualiza ParametroFactura con control de exceptions
	public String guardarParametroFactura() {
		try {
			if(vEditing)
				pfBuss.doActualizar(newParametroFactura);
			else
				
				pfBuss.doGuardar(newParametroFactura);
			return "list-parametro-factura?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		return null;
	}
	
	public void cargarParametroFactura() {
		System.out.println("load data " + vIdParametroFactura);
		if(vIdParametroFactura==0)
			return;
		try {
			newParametroFactura = pfBuss.getParametroFactura(vIdParametroFactura);
			System.out.println(newParametroFactura);
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
	
	//Carga un objeto ParametroFactura en el formulario y se activa la edicion
	public String editarParametroFactura(ParametroFactura tp) {
		//newParametroFactura = ts;
		vEditing = true;
		vTitulo = "EDITAR";
		return "nuevo-parametro-factura?faces-redirect=true&id="+tp.getIdParametroFactura();
	}
	
	//Elimina ParametroFactura con base id
	public String eliminarParametroFactura(int id) {
		try {
			pfBuss.doEliminar(id);
			loadParametroFacturas();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		
		return null;
	}
	
	//Carga todos los ParametroFactura en el formulario
	public void loadParametroFacturas() {
		parametroFacturas = pfBuss.getParametroFacturas();
	}

	public ParametroFactura getNewParametroFactura() {
		return newParametroFactura;
	}

	public void setNewParametroFactura(ParametroFactura newParametroFactura) {
		this.newParametroFactura = newParametroFactura;
	}

	public List<ParametroFactura> getParametroFacturas() {
		return parametroFacturas;
	}

	public void setParametroFacturas(List<ParametroFactura> parametroFacturas) {
		this.parametroFacturas = parametroFacturas;
	}

	public List<ParametroFactura> getFilterParametroFacturas() {
		return filterParametroFacturas;
	}

	public void setFilterParametroFacturas(List<ParametroFactura> filterParametroFacturas) {
		this.filterParametroFacturas = filterParametroFacturas;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public int getvIdParametroFactura() {
		return vIdParametroFactura;
	}

	public void setvIdParametroFactura(int vIdParametroFactura) {
		this.vIdParametroFactura = vIdParametroFactura;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}
	
	

}
