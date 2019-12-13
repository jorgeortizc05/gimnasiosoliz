package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.ComplexionDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Complexion;

@Stateless
public class ComplexionBussiness {
	
	@Inject
	private ComplexionDAO compDAO;

	public void guardarComplexion(Complexion item) throws Exception {
		Complexion aux = compDAO.readComplexId(item.getTelId());
		System.out.println(aux);
		if(aux == null) {
			compDAO.insert(item);
		}else
			throw new Exception("Guardar [Complexion: existe]");
	}
	
	public Complexion buscarComplexionId(int id) throws Exception {
		Complexion aux = compDAO.readComplexId(id);
		
		if(aux != null) {
			return aux;
		}else
			throw new Exception("Buscar [Complexion: null]");
	}
	
	public void updateComplexion(Complexion item) throws Exception {
		Complexion aux = compDAO.readComplexId(item.getTelId());
		if(aux != null) {
			compDAO.update(item);
		}else
			throw new Exception("Update [Complexion: null]");
		
		
	}
	
	public void deleteComplexion(int id) throws Exception {
		Complexion aux = compDAO.readComplexId(id);
		if(aux != null) {
			compDAO.delete(id);
		}
		else {
			throw new Exception("Delete[Complexion: null]");
		}
	}
	
	public List<Complexion> getListComplex() throws Exception{
		
		List<Complexion> auxs = compDAO.getListComplex();
		
		if(auxs != null) {
			return auxs;
		}else
			throw new Exception("List [Complexions: null]");
	}
	
	public List<Complexion> getListPerCompl(int perId) throws Exception{
		
		List<Complexion> auxs = compDAO.getListPerCompl(perId);
		
		if(auxs != null) {
			return auxs;
		}else
			throw new Exception("List [Complexions: null]");
	}

}
