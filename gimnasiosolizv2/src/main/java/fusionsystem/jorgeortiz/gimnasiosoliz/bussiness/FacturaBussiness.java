package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.FacturaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Factura;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.ReporteVentasView;

@Stateless
public class FacturaBussiness {
	
	@Inject
	private FacturaDAO factDAO;
	
	public void guardarFactura(Factura item) throws Exception {
		Factura aux = factDAO.readFactId(item.getFactId());
		
		if(aux == null)
			factDAO.insert(item);
		else
			throw new Exception("Guardar [Factura: existe]");
	}
	
	public Factura buscarFactId(int id) throws Exception {
		Factura aux = factDAO.readFactId(id);
		
		if(aux != null) {
			return aux;
		}else
			throw new Exception("Buscar [Factura: null]");
	}
	
	public void updateFactura(Factura item) throws Exception {
		Factura aux = factDAO.readFactId(item.getFactId());
		if(aux != null) {
			factDAO.update(item);
		}else
			throw new Exception("Update [Factura: null]");
		
		
	}
	
	public void deleteFactura(int id) throws Exception {
		Factura aux = factDAO.readFactId(id);
		if(aux != null) {
			factDAO.delete(id);
		}
		else {
			throw new Exception("Delete[Factura: null]");
		}
	}
	
	public List<Factura> getListFact() throws Exception{
		
		List<Factura> auxs = factDAO.getListFact();
		
		if(auxs != null) {
			return auxs;
		}else
			throw new Exception("List [Facturas: null]");
	}
	
	public List<ReporteVentasView> getListFact1() throws Exception{
		
		List<ReporteVentasView> auxs = factDAO.getListFact1();
		
		if(auxs != null) {
			return auxs;
		}else
			throw new Exception("List [Facturas: null]");
	}

}
