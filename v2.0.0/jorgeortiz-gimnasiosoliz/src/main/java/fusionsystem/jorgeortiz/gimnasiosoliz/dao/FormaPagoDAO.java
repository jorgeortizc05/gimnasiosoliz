package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.FormaPago;

@Stateless
public class FormaPagoDAO {

	@Inject
	private EntityManager emG;
	
	//Guardar
	public void insert(FormaPago item) {
		
		item.setFpId(nextValFP());
		emG.persist(item);
		
		
	}
	
	//Buscar
	public FormaPago readForPagId(int id) {
		FormaPago  item = emG.find(FormaPago.class, id);
		return item;
	}
	
	//Actualizar
	public void update(FormaPago item) {
		emG.merge(item);
	}
	
	
	//Eliminar
	public void delete(int id) {
		
		emG.remove(readForPagId(id));
		
	}
	
	
	//Listar
	public List<FormaPago> getListFormPag(){
		Query query = emG.createNamedQuery("FormaPago.findAll");
		List<FormaPago> items = query.getResultList();
		
		return items;
		
	}
	
	//Sequencias
	public int nextValFP() {
		Query query = emG.createNativeQuery("select nextVal('fp_id_seq')");
		int nextVal = ((BigInteger) query.getSingleResult()).intValue();
		
		return nextVal;
	}
}
