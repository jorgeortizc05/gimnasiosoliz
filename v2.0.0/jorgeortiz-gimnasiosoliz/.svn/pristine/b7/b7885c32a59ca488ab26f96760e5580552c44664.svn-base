package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.ProductoBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Ejercicio;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Producto;

@ManagedBean
public class ProductoController {
	
	@Inject
	private ProductoBussiness proBuss;
	
	@Inject
	private FacesContext facesContext;
	
	private Producto newProducto;
	private List<Producto> productos;
	private List<Producto> filterProductos;
	//Variable para verificar si estas editando
	private boolean vEditing;
	private int vIdProducto;
	private String vTitulo;
	
	@PostConstruct
	public void init() {
		newProducto = new Producto();
		vEditing = false;
		vTitulo = "NUEVO";
		loadProductos();
	}
	
	//Guarda y actualiza Producto con control de exceptions
	public String guardarProducto() {
		try {
			if(vEditing)
				proBuss.doActualizar(newProducto);
			else
				
				proBuss.doGuardar(newProducto);
			return "list-productos?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		return null;
	}
	
	public void cargarProducto() {
		System.out.println("load data " + vIdProducto);
		if(vIdProducto==0)
			return;
		try {
			newProducto = proBuss.getProducto(vIdProducto);
			System.out.println(newProducto);
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
	
	//Carga un objeto Producto en el formulario y se activa la edicion
	public String editarProducto(Producto tp) {
		//newProducto = ts;
		vEditing = true;
		vTitulo = "EDITAR";
		return "nuevo-producto?faces-redirect=true&id="+tp.getIdProducto();
	}
	
	//Elimina Producto con base id
	public String eliminarProducto(int id) {
		try {
			proBuss.doEliminar(id);
			loadProductos();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}
		
		return null;
	}
	
	//Carga todos los Producto en el formulario
	public void loadProductos() {
		productos = proBuss.getProductos();
	}

	public Producto getNewProducto() {
		return newProducto;
	}

	public void setNewProducto(Producto newProducto) {
		this.newProducto = newProducto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Producto> getFilterProductos() {
		return filterProductos;
	}

	public void setFilterProductos(List<Producto> filterProductos) {
		this.filterProductos = filterProductos;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public int getvIdProducto() {
		return vIdProducto;
	}

	public void setvIdProducto(int vIdProducto) {
		this.vIdProducto = vIdProducto;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}
	
	

}
