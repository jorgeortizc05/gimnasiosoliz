/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.ProductoDAO;
import casaortiz.model.Producto;
import java.util.List;

/**
 *
 * @author jorge
 */
public class ProductoBuss {
    
    private ProductoDAO prodDAO = new ProductoDAO();
    
    public boolean guardar(Producto item){
        
        try {
            prodDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(Producto item){
        try {
            prodDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        try {
            prodDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Producto> getProductos(){
        List<Producto> items = null;
        try {
            items = prodDAO.getProductos();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
    public List<Producto> buscarProductosPorNombre(String nombre){
        List<Producto> items = null;
        try {
            items = prodDAO.buscarProductosPorNombre(nombre);
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
    public List<Producto> buscarProductosPorCodigoBarras(String codigoBarra){
        List<Producto> items = null;
        try {
            items = prodDAO.buscarProductosPorCodigoBarra(codigoBarra);
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
