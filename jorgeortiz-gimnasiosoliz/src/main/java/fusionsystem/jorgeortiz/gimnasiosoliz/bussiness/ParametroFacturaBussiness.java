package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.ParametroFacturaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.ParametroFactura;

@Stateless
public class ParametroFacturaBussiness {
	@Inject
	private ParametroFacturaDAO pfDAO;
	
	//Guarda ParametroFactura verificando si existe o no
	public void doGuardar(ParametroFactura parametroFactura) throws Exception {
		ParametroFactura auxp = pfDAO.read(parametroFactura.getIdParametroFactura());
		if(auxp != null) 
			throw new Exception("ParametroFactura ya existe");
		else 
			pfDAO.insert(parametroFactura);	
	}
	
	//Actualiza ParametroFactura verificando si existe o no
	public void doActualizar(ParametroFactura parametroFactura) throws Exception {
		
		ParametroFactura auxp = pfDAO.read(parametroFactura.getIdParametroFactura());
		if(auxp == null) 
			throw new Exception("ParametroFactura no existe");
		else 
			pfDAO.update(parametroFactura);
		
	}
	
	//Elimina ParametroFactura verificando si existe o no
	public void doEliminar(int id) throws Exception {
		ParametroFactura auxp = pfDAO.read(id);
		if(auxp != null) 
			pfDAO.delete(id);
		else 
			throw new Exception("ParametroFactura no existe");	
	}
	
	//Carga un objeto ParametroFactura
	public ParametroFactura getParametroFactura(int id) {
		
		return pfDAO.read(id);
	}
	
	//Recupera una lista de ParametroFactura
	public List<ParametroFactura> getParametroFacturas(){
		
		return pfDAO.getParametroFacturas();
	}

}
