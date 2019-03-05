package fusionsystem.jorgeortiz.gimnasiosoliz.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.TipoPersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@Path("/tipo-persona")
public class TipoPersonaRestService {

	@Inject
	private TipoPersonaLocal tpBuss;
	
	@GET
	@Produces("application/json")
	@Path("/lista")
	public List<TipoPersona> getTipoPersonas(){
		
		return tpBuss.getTipoPersonas();
	}
	
}
