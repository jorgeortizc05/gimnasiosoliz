package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Producto;

@Stateless
public class ProductoDAO {
	
	@Inject
	private EntityManager em;
	
	//Inserta en DB
	public void insert(Producto producto) {
		em.persist(producto);
	}
	
	//Select en DB recuperando la informacion con base del id
	public Producto read(int id) {
		Producto producto = em.find(Producto.class, id);
		//Producto.getDetalleIngresos().size();
		return producto;
	}
	
	//Update en DB
	public void update(Producto producto) {
		em.merge(producto);
	}
	
	//Delete en DB
	public void delete(int id) {
		em.remove(read(id));
	}
	
	//Select en DB
	public List<Producto> getProductos() {
		String jpql = "SELECT a FROM Producto a";
		Query query = em.createQuery(jpql, Producto.class);
		//query.setMaxResults(100);
		List<Producto> listado = query.getResultList();
		return listado;
	}

}
