package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.FacturaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.FormaPagoDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.PersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.ProductoDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Factura;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.FormaPago;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Producto;

public class VentaBussiness {
	
	@Inject
	private FacturaDAO factDAO;
	
	@Inject
	private ProductoDAO prodDAO;
	
	@Inject
	private PersonaDAO perDAO;
	
	@Inject
	private FormaPagoDAO fpDAO;
	
	//Guarda Factura verificando si existe o no
	public void doGuardar(Factura factura) throws Exception {
		Factura auxp = factDAO.read(factura.getIdFactura());
		if(auxp != null) 
			throw new Exception("Factura ya existe");
		else 
			//El valor a calcular
			factura.setIva(this.tipoFactura(factura.getTipoComprobante()));
			factDAO.insert(factura);	
	}
	
	//Verifica si es de tipo factura calcula el 12%, caso contrario no impone iva
	public Double tipoFactura(String tipoComprobante) {
		if (tipoComprobante.equals("FACTURA")) {
			return 12.0;
		} else {
			return 0.0;
		}
	}
	
	//Actualiza Factura verificando si existe o no
	public void doActualizar(Factura factura) throws Exception {
		
		Factura auxp = factDAO.read(factura.getIdFactura());
		if(auxp == null) 
			throw new Exception("Factura no existe");
		else 
			factDAO.update(factura);
		
	}
	
	//Elimina Factura verificando si existe o no
	public void doEliminar(int id) throws Exception {
		Factura auxp = factDAO.read(id);
		if(auxp != null) 
			factDAO.delete(id);
		else 
			throw new Exception("Factura no existe");	
	}
	
	//Carga un objeto Factura
	public Factura getFactura(int id) {
		
		return factDAO.read(id);
	}
	
	//Recupera una lista de Factura
	public List<Factura> getFacturas(){
		
		return factDAO.getFacturas();
	}
	
	//Recupera una lista de personas
	public List<Persona> getPersonas(){
		return perDAO.getPersonas();
	}
	
	//Recupera una lista de productos
	public List<Producto> getProductos(){
		return prodDAO.getProductos();
	}
	
	//Recupera una lista de formas de pagos
	public List<FormaPago> getFormaPagos(){
		return fpDAO.getFormaPagos();
	}

}
