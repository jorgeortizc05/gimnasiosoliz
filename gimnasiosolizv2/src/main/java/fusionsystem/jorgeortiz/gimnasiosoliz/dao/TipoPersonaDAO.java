package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@Stateless
public class TipoPersonaDAO {
	
	@Inject
	private EntityManager emG;
	
	//Guardar
	public void insert(TipoPersona item) {
		
		item.setTperId(nextValTipPers());
		emG.persist(item);
		
		
	}
	
	//Buscar
	public TipoPersona readTipPersId(int id) {
		TipoPersona  item = emG.find(TipoPersona.class, id);
		return item;
	}
	
	//Actualizar
	public void update(TipoPersona item) {
		emG.merge(item);
	}
	
	
	//Eliminar
	public void delete(int id) {
		
		emG.remove(readTipPersId(id));
		
	}
	
	
	//Listar
	public List<TipoPersona> getListTipPers(){
		Query query = emG.createNamedQuery("Tipopersona.findAll");
		List<TipoPersona> items = query.getResultList();
		
		return items;
		
	}
	
	//Sequencias
	public int nextValTipPers() {
		Query query = emG.createNativeQuery("select nextVal('tper_id_seq')");
		int nextVal = ((BigInteger) query.getSingleResult()).intValue();
		
		return nextVal;
	}
}
