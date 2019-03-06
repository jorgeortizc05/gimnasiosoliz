package fusionsystem.jorgeortiz.gimnasiosoliz.service;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.TipoPersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@Path("/tipo-persona")
public class TipoPersonaRestService {

	@Inject
	private TipoPersonaLocal tpBuss;
	
	@Path("/guardar")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public void guardar(TipoPersona tipoPersona) {
		Respuesta respuesta = new Respuesta();
		try {
			tpBuss.doGuardar(tipoPersona);
			respuesta.setCodigo(1);
			respuesta.setMensaje("Guardado Exitoso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			respuesta.setCodigo(-1);
			respuesta.setMensaje("Error al guardar "+e.getMessage());
		}
	}
	
	@Path("/actualizar")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public void actualizar(TipoPersona tipoPersona) {
		Respuesta respuesta = new Respuesta();
		try {
			tpBuss.doActualizar(tipoPersona);
			respuesta.setCodigo(1);
			respuesta.setMensaje("Actualizacion Exitoso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			respuesta.setCodigo(-1);
			respuesta.setMensaje("Error en la actualizacion "+e.getMessage());
		}
	}
	
	@Path("/eliminarid")
	@POST
	@Produces("application/json")
	public void eliminar(@QueryParam("id")int id) {
		Respuesta respuesta = new Respuesta();
		try {
			tpBuss.doEliminar(id);
			respuesta.setCodigo(1);
			respuesta.setMensaje("Eliminacion Exitoso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			respuesta.setCodigo(-1);
			respuesta.setMensaje("Error en la actualizacion "+e.getMessage());
		}
	}
	
	@Path("/tipopersona")
	@GET
	@Produces("application/json")
	public TipoPersona getTipoPersona(int id) {
		return tpBuss.getTipoPersona(id);
	}
	
	@GET
	@Produces("application/json")
	@Path("/lista")
	public List<TipoPersona> getTipoPersonas(){
		
		return tpBuss.getTipoPersonas();
	}
	
}
