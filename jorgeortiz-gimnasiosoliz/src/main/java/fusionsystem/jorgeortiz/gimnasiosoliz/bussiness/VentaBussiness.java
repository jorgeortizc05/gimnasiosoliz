package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.FacturaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.FormaPagoDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.PersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.ProductoDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.SuscripcionDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.DetalleFactura;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Factura;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.FormaPago;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Producto;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Suscripcion;

public class VentaBussiness {
	
	@Inject
	private FacturaDAO factDAO;
	
	@Inject
	private ProductoDAO prodDAO;
	
	@Inject
	private PersonaDAO perDAO;
	
	@Inject
	private FormaPagoDAO fpDAO;
	
	@Inject
	private SuscripcionDAO susDAO;
	
	//Guarda Factura verificando si existe o no
	public void doGuardar(Factura factura) throws Exception {
		Factura auxp = factDAO.read(factura.getIdFactura());
		if(auxp != null) 
			throw new Exception("Factura ya existe");
		else 
			//El valor a calcular
			factura.setIva(this.tipoFactura(factura.getTipoComprobante()));
		    factura.setTotal(totalVenta(factura));
		    System.out.println("Calculo total junto con IVA "+totalVenta(factura));
		    
		    //Un for para ir a cada detalle que tiene la factura.
		    for (DetalleFactura dv: factura.getDetalleFacturas()) {
		    	//Del detalle de factura paso los datos a una tabla
		    	//llamada suscripcion para obtener la fechaDesde y fechaHasta
		    	//Persona para relacionar con persona
		    	Persona p = new Persona();
		    	p.setIdPersona(factura.getPersona().getIdPersona());
		    	//Suscripcion para agregar los datos
		    	Suscripcion s = new Suscripcion();
		    	s.setFechaDesde(dv.getFechaDesde());
		    	s.setFechaHasta(dv.getFechaHasta());
		    	s.setPersona(p);
		    	//Guardo en la entidad suscripciones
		    	susDAO.insert(s);
		    }
		    
			factDAO.insert(factura);	
	}
	
	/*Para obtener un calculo de los dias restantes que vence las suscripcion al gimnasio
	public int calcularDiasRestantes(DetalleFactura df) {
		int dias = (int) ((df.getFechaHasta().getTime()-df.getFechaDesde().getTime())/86400000);
		return dias;
	}*/
	
	//Verifica si es de tipo factura calcula el 12%, caso contrario no impone iva
	public Double tipoFactura(String tipoComprobante) {
		if (tipoComprobante.equals("FACTURA")) {
			return 12.0;
		} else {
			return 0.0;
		}
	}
	
	public Double totalVenta(Factura factura) {
		Double vTotal = 0.0;
		Double vTotalDetalle = 0.0;
		//Realiza una suma por cada detalle
		for(DetalleFactura df: factura.getDetalleFacturas()) {
			df.setValorTotal(df.getValorUnitario()*df.getCantidad());
			vTotal = vTotal + df.getValorTotal();
		}
		//Calcula el descuento
		vTotal = vTotal - factura.getDescuento();
		//Verifica si tiene iva o no
		if(factura.getIva() == 0) {
			return vTotal;
		}
		else {
			//Calcula el valor total con el iva
			return vTotal;
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
	
	//Carga un objeto Producto
	public Producto getProducto(int id) {
		return prodDAO.read(id);
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
