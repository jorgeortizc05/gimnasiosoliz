package fusionsystem.jorgeortiz.gimnasiosoliz.service;

import java.util.List;

import javax.ejb.Local;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@Local
public interface TipoPersonaLocal {
	
	//Todos los metodos de mi TipoPersonaBussiness
		public void doGuardar(TipoPersona tipoPersona) throws Exception;
		public void doActualizar(TipoPersona tipoPersona) throws Exception;
		public void doEliminar(int id) throws Exception;
		public TipoPersona getTipoPersona(int id);
		public List<TipoPersona> getTipoPersonas();

}
