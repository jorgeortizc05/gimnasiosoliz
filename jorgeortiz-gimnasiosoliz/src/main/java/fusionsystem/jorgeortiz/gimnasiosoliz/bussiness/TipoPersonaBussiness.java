package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.TipoPersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@Stateless
public class TipoPersonaBussiness {

	@Inject
	private TipoPersonaDAO rutDAO;
	
	//Guarda TipoPersona verificando si existe o no
	public void doGuardar(TipoPersona tipoPersona) throws Exception {
		TipoPersona auxp = rutDAO.read(tipoPersona.getIdTipoPersona());
		if(auxp != null) 
			throw new Exception("TipoPersona ya existe");
		else 
			rutDAO.insert(tipoPersona);	
	}
	
	//Actualiza TipoPersona verificando si existe o no
	public void doActualizar(TipoPersona tipoPersona) throws Exception {
		
		TipoPersona auxp = rutDAO.read(tipoPersona.getIdTipoPersona());
		if(auxp == null) 
			throw new Exception("TipoPersona no existe");
		else 
			rutDAO.update(tipoPersona);
		
	}
	
	//Elimina TipoPersona verificando si existe o no
	public void doEliminar(int id) throws Exception {
		TipoPersona auxp = rutDAO.read(id);
		if(auxp != null) 
			rutDAO.delete(id);
		else 
			throw new Exception("TipoPersona no existe");	
	}
	
	//Carga un objeto TipoPersona
	public TipoPersona getTipoPersona(int id) {
		
		return rutDAO.read(id);
	}
	
	//Recupera una lista de TipoPersona
	public List<TipoPersona> getTipoPersonas(){
		
		return rutDAO.getTipoPersonas();
	}	
}
