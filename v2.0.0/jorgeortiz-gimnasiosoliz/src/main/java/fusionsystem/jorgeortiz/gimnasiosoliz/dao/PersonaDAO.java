package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;

@Stateless
public class PersonaDAO {
	
	@Inject
	private EntityManager emG;
	
	//Guardar
	public void insert(Persona item) {
		
		item.setPerId(nextValPer());
		emG.persist(item);
		
		
	}
	
	//Buscar
	public Persona readPerId(int id) {
		Persona  item = emG.find(Persona.class, id);
		return item;
	}
	
	//Actualizar
	public void update(Persona item) {
		emG.merge(item);
	}
	
	
	//Eliminar
	public void delete(int id) {
		
		emG.remove(readPerId(id));
		
	}
	
	
	//Listar
	public List<Persona> getListPer(){
		Query query = emG.createNamedQuery("Persona.findAll");
		List<Persona> items = query.getResultList();
		
		return items;
		
	}
	
	//Sequencias
	public int nextValPer() {
		Query query = emG.createNativeQuery("select nextVal('per_id_seq')");
		int nextVal = ((BigInteger) query.getSingleResult()).intValue();
		
		return nextVal;
	}

}
