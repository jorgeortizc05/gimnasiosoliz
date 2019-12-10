package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.RutinaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Rutina;

@Stateless
public class RutinaBussiness {

	@Inject
	private RutinaDAO rutDAO;
	
	//Guarda Rutina verificando si existe o no
	public void doGuardar(Rutina rutina) throws Exception {
		Rutina auxp = rutDAO.read(rutina.getIdRutina());
		if(auxp != null) 
			throw new Exception("Rutina ya existe");
		else 
			rutDAO.insert(rutina);	
	}
	
	//Actualiza Rutina verificando si existe o no
	public void doActualizar(Rutina rutina) throws Exception {
		
		Rutina auxp = rutDAO.read(rutina.getIdRutina());
		if(auxp == null) 
			throw new Exception("Rutina no existe");
		else 
			rutDAO.update(rutina);
		
	}
	
	//Elimina Rutina verificando si existe o no
	public void doEliminar(int id) throws Exception {
		Rutina auxp = rutDAO.read(id);
		if(auxp != null) 
			rutDAO.delete(id);
		else 
			throw new Exception("Rutina no existe");	
	}
	
	//Carga un objeto Rutina
	public Rutina getRutina(int id) {
		
		return rutDAO.read(id);
	}
	
	//Recupera una lista de Rutina
	public List<Rutina> getRutinas(){
		
		return rutDAO.getRutinas();
	}
}
