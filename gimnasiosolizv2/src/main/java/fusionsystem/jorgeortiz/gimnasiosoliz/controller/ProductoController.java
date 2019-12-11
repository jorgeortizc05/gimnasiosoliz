package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.ProductoBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Producto;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;
import fusionsystem.jorgeortiz.gimnasiosoliz.util.Mensajes;

@ManagedBean
@ViewScoped
public class ProductoController {
	
	//Tipo Persona
	@Inject
	private ProductoBussiness prodBuss;
	
	
	private Producto newProducto;
	private List<Producto> listProd;
	
	private TipoPersona newTipoPersona;
	
	//Variables
	private int vProdId;
	private boolean vEditing;
	
	@PostConstruct
	public void init() {
		vEditing = false;
		newProducto = new Producto();
		newTipoPersona = new TipoPersona();
		loadListProd();
	}
	
	public String guardarProducto() {
		
		try {
			
			if(vEditing) {
				prodBuss.updateProducto(newProducto);
			}else {
				prodBuss.guardarProducto(newProducto);
				vEditing = false;
			}
			
			return "list-productos?faces-redirect=true";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
		return null;
	}
	
	public String buscarProdID()  {
		try {
			newProducto = prodBuss.buscarProductoId(vProdId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
		return null;
		
	}
	
	////////////////////////////START UPDATE//////////////////////////////////////////////
	public String irUpdProducto(Producto Producto) {
		return "nuevo-producto?faces-redirect=true&id="+Producto.getProdId();
	}
	public void cargarProducto() {
		if(vProdId == 0 )
			return;
		
		try {
			newProducto = prodBuss.buscarProductoId(vProdId);
			vEditing = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
	}
	
	///////////////////////////END UPDATE///////////////////////////////////////////////
	
	public String deleteProducto(Producto prod)  {
		try {
			prodBuss.deleteProducto(prod.getProdId());
			loadListProd();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
			Mensajes.addMessageInfo(prod.getProdNombre() + " ya tiene registros");
		}
		
		return null;
	}
	
	public void loadListProd() {
		try {
			listProd = prodBuss.getListProd();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
	}

	public Producto getNewProducto() {
		return newProducto;
	}

	public void setNewProducto(Producto newProducto) {
		this.newProducto = newProducto;
	}

	public int getvProdId() {
		return vProdId;
	}

	public void setvProdId(int vProdId) {
		this.vProdId = vProdId;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public List<Producto> getListProd() {
		return listProd;
	}

	public TipoPersona getNewTipoPersona() {
		return newTipoPersona;
	}

	public void setNewTipoPersona(TipoPersona newTipoPersona) {
		this.newTipoPersona = newTipoPersona;
	}
	
}
