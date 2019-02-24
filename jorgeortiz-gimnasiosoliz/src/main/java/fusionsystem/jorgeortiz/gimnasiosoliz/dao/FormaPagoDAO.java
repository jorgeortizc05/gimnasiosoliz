package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.FormaPago;

@Stateless
public class FormaPagoDAO {

	@Inject
	private EntityManager em;
	
	//Inserta en DB
	public void insert(FormaPago formaPago) {
		em.persist(formaPago);
	}
	
	//Select en DB recuperando la informacion con base del id
	public FormaPago read(int id) {
		FormaPago formaPago = em.find(FormaPago.class, id);
		//FormaPago.getDetalleIngresos().size();
		return formaPago;
	}
	
	//Update en DB
	public void update(FormaPago formaPago) {
		em.merge(formaPago);
	}
	
	//Delete en DB
	public void delete(int id) {
		em.remove(read(id));
	}
	
	//Select en DB
	public List<FormaPago> getFormaPagos() {
		String jpql = "SELECT a FROM FormaPago a";
		Query query = em.createQuery(jpql, FormaPago.class);
		//query.setMaxResults(100);
		List<FormaPago> listado = query.getResultList();
		return listado;
	}
}
