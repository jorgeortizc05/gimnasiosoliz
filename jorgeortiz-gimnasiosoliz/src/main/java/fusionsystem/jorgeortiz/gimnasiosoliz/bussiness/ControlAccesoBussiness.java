package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.PersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.SuscripcionDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.DetalleFactura;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Suscripcion;

public class ControlAccesoBussiness {
	
	@Inject
	private PersonaDAO perDAO;
	
	@Inject
	private SuscripcionDAO susDAO;
	
	//Carga un objeto Persona
	public Persona getPersona(String cedula) {
		
		return perDAO.getPersonaCedula(cedula);
	}
	
	public List<Suscripcion> getSuscripcionesPersona(int idPersona){
		
		return susDAO.getSuscripcionsPersona(idPersona);
	}
	
	public Suscripcion getSuscripcione(int idPersona){
		List<Suscripcion> lista = susDAO.getSuscripcionsPersona(idPersona);
		//Tomo el ultimo dato de la lista
		Suscripcion sus = lista.get(lista.size()-1);
	
		return sus;
	}
	
	//Para obtener un calculo de los dias restantes que vence las suscripcion al gimnasio
	public int calcularDiasRestantes(Suscripcion df) {
		Date fechaActual = new Date();
		int dias = (int) ((df.getFechaHasta().getTime()-fechaActual.getTime())/86400000);
		return dias;
	}

}
