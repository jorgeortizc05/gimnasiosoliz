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
	private TipoPersonaLocal tpBuss;
	
	@WebMethod
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
	
	public void eliminar(int id) {
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
	
	@WebMethod
	public TipoPersona getTipoPersona(int id) {
		return tpBuss.getTipoPersona(id);
	}
	
	@WebMethod
	public List<TipoPersona> getTipoPersonas(){
		return tpBuss.getTipoPersonas();
	}

}
