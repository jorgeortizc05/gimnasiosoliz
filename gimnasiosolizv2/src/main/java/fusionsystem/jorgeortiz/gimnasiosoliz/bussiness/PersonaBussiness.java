package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.ComplexionDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.PersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.TipoPersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@Stateless
public class PersonaBussiness {
	@Inject
	private PersonaDAO prodDAO;

	public void guardarPersona(Persona item) throws Exception {
		Persona aux = prodDAO.readPerId(item.getPerId());
		
		if(aux == null) {
			item.setPerNombres(item.getPerNombres().toUpperCase());
			prodDAO.insert(item);
		}else
			throw new Exception("Guardar [Persona: existe]");
	}
	
	public Persona buscarPersonaId(int id) throws Exception {
		Persona aux = prodDAO.readPerId(id);
		
		if(aux != null) {
			return aux;
		}else
			throw new Exception("Buscar [Persona: null]");
	}
	
	public void updatePersona(Persona item) throws Exception {
		Persona aux = prodDAO.readPerId(item.getPerId());
		if(aux != null) {
			item.setPerNombres(item.getPerNombres().toUpperCase());
			prodDAO.update(item);
		}else
			throw new Exception("Update [Persona: null]");
		
		
	}
	
	public void deletePersona(int id) throws Exception {
		Persona aux = prodDAO.readPerId(id);
		if(aux != null) {
			prodDAO.delete(id);
		}
		else {
			throw new Exception("Delete[Persona: null]");
		}
	}
	
	public List<Persona> getListPer() throws Exception{
		
		List<Persona> auxs = prodDAO.getListPer();
		
		if(auxs != null) {
			return auxs;
		}else
			throw new Exception("List [Personas: null]");
	}
}
