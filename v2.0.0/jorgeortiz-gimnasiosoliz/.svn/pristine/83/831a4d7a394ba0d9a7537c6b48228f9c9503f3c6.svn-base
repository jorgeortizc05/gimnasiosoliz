package fusionsystem.jorgeortiz.gimnasiosoliz.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.DetalleFactura;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Factura;

@Stateless
public class FacturaDAO {
	
	@Inject
	private EntityManager em;
	
	//Inserta en DB
	public void insert(Factura factura) {
		em.persist(factura);
	}
	
	//Select en DB recuperando la informacion con base del id
	public Factura read(int id) {
		Factura factura = em.find(Factura.class, id);
		if(factura!= null) {
			factura.getDetalleFacturas().size();
		}
		//Factura.getDetalleIngresos().size();
		return factura;
	}
	
	//Update en DB
	public void update(Factura factura) {
		em.merge(factura);
	}
	
	//Delete en DB
	public void delete(int id) {
		em.remove(read(id));
	}
	
	//Select en DB
	public List<Factura> getFacturas() {
		String jpql = "SELECT a FROM Factura a ORDER BY a.idFactura DESC";
		Query query = em.createQuery(jpql, Factura.class);
		//query.setMaxResults(100);
		List<Factura> listado = query.getResultList();
		return listado;
	}
	
	//Select en DetalleFactura solo activos
	public List<Factura> getDetalleFacturas() {
		String jpql = "SELECT a FROM Factura a where a.detallefactura.estado = 'A' order by a.idFactura DESC";
		Query query = em.createQuery(jpql, Factura.class);
		//query.setMaxResults(100);
		List<Factura> listado = query.getResultList();
		return listado;
	}

}
