package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.ProductoDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Producto;

@Stateless
public class ProductoBussiness {
	
	@Inject
	private ProductoDAO proDAO;
	
	//Guarda Producto verificando si existe o no
	public void doGuardar(Producto producto) throws Exception {
		Producto auxp = proDAO.read(producto.getIdProducto());
		if(auxp != null) 
			throw new Exception("Producto ya existe");
		else 
			proDAO.insert(producto);	
	}
	
	//Actualiza Producto verificando si existe o no
	public void doActualizar(Producto producto) throws Exception {
		
		Producto auxp = proDAO.read(producto.getIdProducto());
		if(auxp == null) 
			throw new Exception("Producto no existe");
		else 
			proDAO.update(producto);
		
	}
	
	//Elimina Producto verificando si existe o no
	public void doEliminar(int id) throws Exception {
		Producto auxp = proDAO.read(id);
		if(auxp != null) 
			proDAO.delete(id);
		else 
			throw new Exception("Producto no existe");	
	}
	
	//Carga un objeto Producto
	public Producto getProducto(int id) {
		
		return proDAO.read(id);
	}
	
	//Recupera una lista de Producto
	public List<Producto> getProductos(){
		
		return proDAO.getProductos();
	}

}
