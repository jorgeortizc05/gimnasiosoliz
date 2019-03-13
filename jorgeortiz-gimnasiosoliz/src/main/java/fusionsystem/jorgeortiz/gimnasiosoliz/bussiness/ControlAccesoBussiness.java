package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.PersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.dao.SuscripcionDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Complexion;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.DetalleFactura;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Suscripcion;

public class ControlAccesoBussiness {
	
	@Inject
	private PersonaDAO perDAO;
	
	@Inject
	private SuscripcionDAO susDAO;
	
	//Carga un objeto Persona
	public Persona getPersona(String cedula) throws Exception {
		Persona persona = perDAO.getPersonaCedula(cedula);
		if(persona==null) {
			throw new Exception("No esta registrado en el sistema");
		}else {
			return persona;
			
		}
	}
	
	public List<Suscripcion> getSuscripcionesPersona(int idPersona){
		
		return susDAO.getSuscripcionsPersona(idPersona);
	}
	
	public Suscripcion getSuscripcione(int idPersona) throws Exception{
		List<Suscripcion> lista = susDAO.getSuscripcionsPersona(idPersona);
		//Tomo el ultimo dato de la lista
		if(lista == null) {
			throw new Exception("No tiene suscripción");
		}
		else {
			Suscripcion sus = lista.get(lista.size()-1);
			return sus;
		}
		
		
	
		
	}
	
	//Para obtener un calculo de los dias restantes que vence las suscripcion al gimnasio
	public int calcularDiasRestantes(Suscripcion df) {
		Date fechaActual = new Date();
		int dias = (int) ((df.getFechaHasta().getTime()-fechaActual.getTime())/86400000);
		return dias;
	}
	
	public String estadoCorporal(Complexion c) {
		try {
			if(c.getIndiceCorporal()<18.5) {
				return "PESO INSUFICIENTE";
			}
			if(c.getIndiceCorporal()>18.5) {
				return "PESO NORMAL";
			}
			if(c.getIndiceCorporal()>25.0) {
				return "PESO NORMAL GRADO I";
			}
			if(c.getIndiceCorporal()>30.0) {
				return "OBESIDAD TIPO 1 (LEVE)";
			}
			if(c.getIndiceCorporal()>35.0) {
				return "OBESIDAD TIPO 2 (MODERADA)";
			}
			if(c.getIndiceCorporal()>40.0) {
				return "OBESIDAD TIPO 3 (MORBIDA)";
			}
			if(c.getIndiceCorporal()>50.0) {
				return "PELIGRO OBESIDAD EXTREMA";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Sin estado";
	}

}
