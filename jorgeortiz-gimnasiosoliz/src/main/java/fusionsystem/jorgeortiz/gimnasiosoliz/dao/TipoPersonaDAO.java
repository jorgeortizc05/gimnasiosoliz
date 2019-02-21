package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;

@Stateless
public class TipoPersonaDAO {
	
	@Inject
	private EntityManager em;
	
	//Inserta en DB
	public void insert(TipoPersona tipoPersona) {
		em.persist(tipoPersona);
	}
	
	//Select en DB recuperando la informacion con base del id
	public TipoPersona read(int id) {
		TipoPersona tipoPersona = em.find(TipoPersona.class, id);
		//TipoPersona.getDetalleIngresos().size();
		return tipoPersona;
	}
	
	//Update en DB
	public void update(TipoPersona tipoPersona) {
		em.merge(tipoPersona);
	}
	
	//Delete en DB
	public void delete(int id) {
		em.remove(read(id));
	}
	
	//Select en DB
	public List<TipoPersona> getTipoPersonas() {
		String jpql = "SELECT a FROM TipoPersona a";
		Query query = em.createQuery(jpql, TipoPersona.class);
		//query.setMaxResults(100);
		List<TipoPersona> listado = query.getResultList();
		return listado;
	}

}
