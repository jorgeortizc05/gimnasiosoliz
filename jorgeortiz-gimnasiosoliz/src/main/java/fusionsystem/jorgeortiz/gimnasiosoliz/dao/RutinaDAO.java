package fusionsystem.jorgeortiz.gimnasiosoliz.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Rutina;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 20/02/2019
 * Nota: CRUD para Rutina
 * 
 * MODIFICACIONES
 * Fecha Modificacion: 
 * 
 */

@Stateless
public class RutinaDAO {
	
	@Inject
	private EntityManager em;
	
	//Inserta en DB
	public void insert(Rutina rutina) {
		em.persist(rutina);
	}
	
	//Select en DB recuperando la informacion con base del id
	public Rutina read(int id) {
		Rutina rutina = em.find(Rutina.class, id);
		//Rutina.getDetalleIngresos().size();
		return rutina;
	}
	
	//Update en DB
	public void update(Rutina rutina) {
		em.merge(rutina);
	}
	
	//Delete en DB
	public void delete(int id) {
		em.remove(read(id));
	}
	
	//Select en DB
	public List<Rutina> getRutinas() {
		String jpql = "SELECT a FROM Rutina a";
		Query query = em.createQuery(jpql, Rutina.class);
		//query.setMaxResults(100);
		List<Rutina> listado = query.getResultList();
		return listado;
	}

}
