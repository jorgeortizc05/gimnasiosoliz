package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.ProductoDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Producto;

@Stateless
public class ProductoBussiness {

	@Inject
	private ProductoDAO prodDAO;
	
	public void guardarProducto(Producto item) throws Exception {
		Producto aux = prodDAO.readProdId(item.getProdId());
		
		if(aux == null)
			prodDAO.insert(item);
		else
			throw new Exception("Guardar [Producto: existe]");
	}
	
	public Producto buscarProductoId(int id) throws Exception {
		Producto aux = prodDAO.readProdId(id);
		
		if(aux != null) {
			return aux;
		}else
			throw new Exception("Buscar [Producto: null]");
	}
	
	public void updateProducto(Producto item) throws Exception {
		Producto aux = prodDAO.readProdId(item.getProdId());
		if(aux != null) {
			prodDAO.update(item);
		}else
			throw new Exception("Update [Producto: null]");
		
		
	}
	
	public void deleteProducto(int id) throws Exception {
		Producto aux = prodDAO.readProdId(id);
		if(aux != null) {
			prodDAO.delete(id);
		}
		else {
			throw new Exception("Delete[Producto: null]");
		}
	}
	
	public List<Producto> getListProd() throws Exception{
		
		List<Producto> auxs = prodDAO.getListProd();
		
		if(auxs != null) {
			return auxs;
		}else
			throw new Exception("List [Productos: null]");
	}
}
