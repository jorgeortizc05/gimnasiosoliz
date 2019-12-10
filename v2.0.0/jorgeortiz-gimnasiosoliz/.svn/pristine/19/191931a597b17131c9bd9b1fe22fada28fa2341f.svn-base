package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.FormaPagoDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.FormaPago;

@Stateless
public class FormaPagoBussiness {
	
	@Inject
	private FormaPagoDAO fpDAO;
	
	//Guarda FormaPago verificando si existe o no
	public void doGuardar(FormaPago formaPago) throws Exception {
		FormaPago auxp = fpDAO.read(formaPago.getIdFormaPago());
		if(auxp != null) 
			throw new Exception("FormaPago ya existe");
		else 
			fpDAO.insert(formaPago);	
	}
	
	//Actualiza FormaPago verificando si existe o no
	public void doActualizar(FormaPago formaPago) throws Exception {
		
		FormaPago auxp = fpDAO.read(formaPago.getIdFormaPago());
		if(auxp == null) 
			throw new Exception("FormaPago no existe");
		else 
			fpDAO.update(formaPago);
		
	}
	
	//Elimina FormaPago verificando si existe o no
	public void doEliminar(int id) throws Exception {
		FormaPago auxp = fpDAO.read(id);
		if(auxp != null) 
			fpDAO.delete(id);
		else 
			throw new Exception("FormaPago no existe");	
	}
	
	//Carga un objeto FormaPago
	public FormaPago getFormaPago(int id) {
		
		return fpDAO.read(id);
	}
	
	//Recupera una lista de FormaPago
	public List<FormaPago> getFormaPagos(){
		
		return fpDAO.getFormaPagos();
	}

	
}
