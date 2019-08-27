package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Suscripcion;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 20/02/2019
 * Nota: CRUD para Persona
 * 
 * MODIFICACIONES
 * Fecha Modificacion: 
 * 
 */
@Stateless
public class PersonaDAO {

	@Inject
	private EntityManager em;
	
	//Inserta en DB
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	//Obtengo persona junto con su complexion
	public Persona readPersonaComplexion(int id) {
		Persona persona = em.find(Persona.class, id);
		if(persona != null) {
		persona.getComplexiones().size();
		}
		//Persona.getDetalleIngresos().size();
		return persona;
	}
	
	//Obtengo solo persona
	public Persona readPersona(int id) {
		Persona persona = em.find(Persona.class, id);
		return persona;
	}
	
	//Update en DB
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	//Delete en DB
	public void delete(int id) {
		em.remove(readPersonaComplexion(id));
	}
	
	//Select en DB
	public List<Persona> getPersonas() {
		String jpql = "SELECT a FROM Persona a ORDER BY a.idPersona DESC";
		Query query = em.createQuery(jpql, Persona.class);
		//query.setMaxResults(100);
		List<Persona> listado = query.getResultList();
		return listado;
	}
	
	public Persona getPersonaCedula(String cedula) {
		String jpql = "SELECT a FROM Persona a WHERE a.cedula = :vCedula";
		Query query = em.createQuery(jpql, Persona.class);
		query.setParameter("vCedula", cedula);
		try {
			Persona persona = (Persona) query.getSingleResult();
			if(persona.getComplexiones()!=null) {
				persona.getComplexiones().size();
			}
			
			return persona;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public List<Persona> getPersonasSuscripciones() {
		String jpql = "SELECT a FROM Persona a ORDER BY a.idPersona DESC";
		Query query = em.createQuery(jpql, Persona.class);
		//query.setMaxResults(100);
		List<Persona> listado = query.getResultList();
		
		for(Persona per:listado) {
			per.getSuscripciones().size();
			
		}
		
		
		return listado;
			
		
	}
}
