package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.FormaPagoDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.FormaPago;

@Stateless
public class FormaPagoBussiness {

	@Inject
	private FormaPagoDAO prodDAO;
	
	public void guardarFormaPago(FormaPago item) throws Exception {
		FormaPago aux = prodDAO.readForPagId(item.getFpId());
		
		if(aux == null)
			prodDAO.insert(item);
		else
			throw new Exception("Guardar [FormaPago: existe]");
	}
	
	public FormaPago buscarFormaPagoId(int id) throws Exception {
		FormaPago aux = prodDAO.readForPagId(id);
		
		if(aux != null) {
			return aux;
		}else
			throw new Exception("Buscar [FormaPago: null]");
	}
	
	public void updateFormaPago(FormaPago item) throws Exception {
		FormaPago aux = prodDAO.readForPagId(item.getFpId());
		if(aux != null) {
			prodDAO.update(item);
		}else
			throw new Exception("Update [FormaPago: null]");
		
		
	}
	
	public void deleteFormaPago(int id) throws Exception {
		FormaPago aux = prodDAO.readForPagId(id);
		if(aux != null) {
			prodDAO.delete(id);
		}
		else {
			throw new Exception("Delete[FormaPago: null]");
		}
	}
	
	public List<FormaPago> getListFormPag() throws Exception{
		
		List<FormaPago> auxs = prodDAO.getListFormPag();
		
		if(auxs != null) {
			return auxs;
		}else
			throw new Exception("List [FormaPagos: null]");
	}
}
