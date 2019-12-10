package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.TipoPersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@Stateless
public class TipoPersonaBussiness {
	
	
	//Tipo de Persona
	@Inject
	private TipoPersonaDAO tpDAO;
	
	public void guardarTipPers(TipoPersona item) throws Exception {
		TipoPersona aux = tpDAO.readTipPersId(item.getTperId());
		
		if(aux == null)
			tpDAO.insert(item);
		else
			throw new Exception("Guardar [Tipo Persona: existe]");
	}
	
	public TipoPersona buscarTipPersID(int id) throws Exception {
		TipoPersona aux = tpDAO.readTipPersId(id);
		
		if(aux != null) {
			return aux;
		}else
			throw new Exception("Buscar [Tipo Persona: null]");
	}
	
	public void updateTipPers(TipoPersona item) throws Exception {
		TipoPersona aux = tpDAO.readTipPersId(item.getTperId());
		if(aux != null) {
			tpDAO.update(item);
		}else
			throw new Exception("Update [Tipo Persona: null]");
		
		
	}
	
	public void deleteTipPers(int id) throws Exception {
		TipoPersona aux = tpDAO.readTipPersId(id);
		if(aux != null) {
			tpDAO.delete(id);
		}
		else {
			throw new Exception("Delete[Tipo Persona: null]");
		}
	}
	
	public List<TipoPersona> getListTipPers() throws Exception{
		
		List<TipoPersona> auxs = tpDAO.getListTipPers();
		
		if(auxs != null) {
			return auxs;
		}else
			throw new Exception("List [Tipo Personas: null]");
	}
}
