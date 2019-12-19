package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.fachada;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.FacturaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.FacturaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.ReporteVentasView;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Factura;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.ReporteVentasView;

@Stateless
public class FacturacionBussiness {
	
	@Inject
	private FacturaBussiness factBuss;
	
	public void guardarFactura(Factura item) throws Exception {	
		factBuss.guardarFactura(item);
		
	}
	
	public Factura buscarFactId(int id) throws Exception {
		Factura aux = factBuss.buscarFactId(id);
		return aux;
	}
	
	public void updateFactura(Factura item) throws Exception {
		factBuss.updateFactura(item);
	}
	
	public void deleteFactura(int id) throws Exception {

		factBuss.deleteFactura(id);

	}
	
	public List<Factura> getListFact() throws Exception{
		List<Factura> auxs = factBuss.getListFact();
		return auxs;
	}
	
	public List<ReporteVentasView> getReporteVentas() throws Exception{
		List<ReporteVentasView> auxs = factBuss.getReporteVentas();
		return auxs;
	}
	
}
