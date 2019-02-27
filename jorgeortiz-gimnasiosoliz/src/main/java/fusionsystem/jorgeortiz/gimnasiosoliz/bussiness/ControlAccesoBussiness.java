package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.PersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;

public class ControlAccesoBussiness {
	
	@Inject
	private PersonaDAO perDAO;
	
	//Carga un objeto Persona
	public Persona getPersona(String cedula) {
		
		return perDAO.getPersonaCedula(cedula);
	}

}
