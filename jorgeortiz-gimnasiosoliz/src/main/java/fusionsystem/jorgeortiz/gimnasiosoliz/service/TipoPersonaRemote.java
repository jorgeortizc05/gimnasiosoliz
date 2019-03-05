package fusionsystem.jorgeortiz.gimnasiosoliz.service;

import java.util.List;

import javax.ejb.Remote;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@Remote
public interface TipoPersonaRemote {
	//Todos los metodos de mi TipoPersonaBussiness
	public void doGuardar(TipoPersona tipoPersona) throws Exception;
	public void doActualizar(TipoPersona tipoPersona) throws Exception;
	public void doEliminar(int id) throws Exception;
	public TipoPersona getTipoPersona(int id);
	public List<TipoPersona> getTipoPersonas();

}
