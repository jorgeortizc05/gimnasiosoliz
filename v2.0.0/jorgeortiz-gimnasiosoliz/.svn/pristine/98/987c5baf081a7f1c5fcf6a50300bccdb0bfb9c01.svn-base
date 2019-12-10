package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Suscripcion;

@Stateless
public class SuscripcionDAO {

	@Inject
	private EntityManager em;
	
	//Inserta en DB
	public void insert(Suscripcion suscripcion) {
		em.persist(suscripcion);
	}
	
	//Select en DB recuperando la informacion con base del id
	public Suscripcion read(int id) {
		Suscripcion suscripcion = em.find(Suscripcion.class, id);
		//Suscripcion.getDetalleIngresos().size();
		return suscripcion;
	}
	
	//Update en DB
	public void update(Suscripcion suscripcion) {
		em.merge(suscripcion);
	}
	
	//Delete en DB
	public void delete(int id) {
		em.remove(read(id));
	}
	
	//Select en DB
	public List<Suscripcion> getSuscripcions() {
		String jpql = "SELECT a FROM Suscripcion a";
		Query query = em.createQuery(jpql, Suscripcion.class);
		//query.setMaxResults(100);
		List<Suscripcion> listado = query.getResultList();
		for(Suscripcion sus: listado) {
			sus.getPersona().getIdPersona();
		}
		return listado;
	}
	
	//Consulta, la persona tiene muchas suscripciones
	public List<Suscripcion> getSuscripcionsPersona(int idPersona){
		String jpql = "SELECT a FROM Suscripcion a WHERE a.persona.idPersona = :vIdPersona ORDER BY a.idSuscripcion DESC";
		Query query = em.createQuery(jpql, Suscripcion.class);
		query.setParameter("vIdPersona", idPersona);
		//query.setMaxResults(100);
		List<Suscripcion> listado = query.getResultList();
		for(Suscripcion sus: listado) {
			sus.getPersona().getIdPersona();
		}
		return listado;
	}
}
