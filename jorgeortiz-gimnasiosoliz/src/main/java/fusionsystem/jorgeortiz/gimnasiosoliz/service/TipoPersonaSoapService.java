package fusionsystem.jorgeortiz.gimnasiosoliz.service;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.TipoPersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@WebService
public class TipoPersonaSoapService {
	
	@Inject
	private TipoPersonaBussiness tpBuss;
	
	
	@WebMethod
	public List<TipoPersona> getPersonas(){
		return tpBuss.getTipoPersonas();
	}

}
