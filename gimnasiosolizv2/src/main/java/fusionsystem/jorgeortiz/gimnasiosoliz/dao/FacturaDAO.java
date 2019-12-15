package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Factura;

@Stateless
public class FacturaDAO {

	@Inject
	private EntityManager emG;
	
	//Guardar
	public void insert(Factura item) {
		
		item.setFactId(nextValFact());
		emG.persist(item);
		
		
	}
	
	//Buscar
	public Factura readFactId(int id) {
		Factura  item = emG.find(Factura.class, id);
		return item;
	}
	
	//Actualizar
	public void update(Factura item) {
		emG.merge(item);
	}
	
	
	//Eliminar
	public void delete(int id) {
		
		emG.remove(readFactId(id));
		
	}
	
	
	//Listar
	public List<Factura> getListFact(){
		
		try {
			Query query = emG.createNamedQuery("Factura.findAll");
			List<Factura> items = query.getResultList();
			
			return items;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
		
	}
	
	//Sequencias
	public int nextValFact() {
		Query query = emG.createNativeQuery("select nextVal('fact_id_seq')");
		int nextVal = ((BigInteger) query.getSingleResult()).intValue();
		
		return nextVal;
	}
}
