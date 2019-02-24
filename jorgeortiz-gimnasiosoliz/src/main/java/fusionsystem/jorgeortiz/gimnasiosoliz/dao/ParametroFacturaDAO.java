package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.ParametroFactura;

@Stateless
public class ParametroFacturaDAO {
	
	@Inject
	private EntityManager em;
	
	//Inserta en DB
	public void insert(ParametroFactura parametroFactura) {
		em.persist(parametroFactura);
	}
	
	//Select en DB recuperando la informacion con base del id
	public ParametroFactura read(int id) {
		ParametroFactura parametroFactura = em.find(ParametroFactura.class, id);
		//ParametroFactura.getDetalleIngresos().size();
		return parametroFactura;
	}
	
	//Update en DB
	public void update(ParametroFactura parametroFactura) {
		em.merge(parametroFactura);
	}
	
	//Delete en DB
	public void delete(int id) {
		em.remove(read(id));
	}
	
	//Select en DB
	public List<ParametroFactura> getParametroFacturas() {
		String jpql = "SELECT a FROM ParametroFactura a";
		Query query = em.createQuery(jpql, ParametroFactura.class);
		//query.setMaxResults(100);
		List<ParametroFactura> listado = query.getResultList();
		return listado;
	}

}
