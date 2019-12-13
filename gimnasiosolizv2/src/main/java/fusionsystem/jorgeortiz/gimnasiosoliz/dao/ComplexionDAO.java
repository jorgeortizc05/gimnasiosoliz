package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Complexion;

@Stateless
public class ComplexionDAO {
	
	@Inject
	private EntityManager emG;
	
	//Guardar
	public void insert(Complexion item) {
		
		item.setTelId(nextValComplex());
		emG.persist(item);
			
	}
	
	//Buscar
	public Complexion readComplexId(int id) {
		Complexion  item = emG.find(Complexion.class, id);
		return item;
	}
	
	//Actualizar
	public void update(Complexion item) {
		emG.merge(item);
	}
	
	
	//Eliminar
	public void delete(int id) {
		
		emG.remove(readComplexId(id));
		
	}
		
	//Listar
	public List<Complexion> getListComplex(){
		Query query = emG.createNamedQuery("Complexion.findAll");
		List<Complexion> items = query.getResultList();
		
		return items;
		
	}
	
	public List<Complexion> getListPerCompl(int perId){
		Query query = emG.createQuery("Select c FROM Complexion c where c.perId = :perId", Complexion.class);
		query.setParameter("perId", perId);
		List<Complexion> items = query.getResultList();
		
		return items;
	}
	
	//Sequencias
	public int nextValComplex() {
		Query query = emG.createNativeQuery("select nextVal('comp_id_seq')");
		int nextVal = ((BigInteger) query.getSingleResult()).intValue();
		
		return nextVal;
	}

}
