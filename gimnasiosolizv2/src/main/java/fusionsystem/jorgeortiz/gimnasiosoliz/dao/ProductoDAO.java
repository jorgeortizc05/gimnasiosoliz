package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Producto;

@Stateless
public class ProductoDAO {

	@Inject
	private EntityManager emG;
	
	//Guardar
	public void insert(Producto item) {
		
		item.setProdId(nextValProd());
		emG.persist(item);
			
	}
	
	//Buscar
	public Producto readProdId(int id) {
		Producto  item = emG.find(Producto.class, id);
		return item;
	}
	
	//Actualizar
	public void update(Producto item) {
		emG.merge(item);
	}
	
	
	//Eliminar
	public void delete(int id) {
		
		emG.remove(readProdId(id));
		
	}
		
	//Listar
	public List<Producto> getListProd(){
		Query query = emG.createNamedQuery("Producto.findAll");
		List<Producto> items = query.getResultList();
		
		return items;
		
	}
	
	//Sequencias
	public int nextValProd() {
		Query query = emG.createNativeQuery("select nextVal('prod_id_seq')");
		int nextVal = ((BigInteger) query.getSingleResult()).intValue();
		
		return nextVal;
	}
}
