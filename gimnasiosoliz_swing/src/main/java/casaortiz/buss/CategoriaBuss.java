/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.CategoriaDAO;
import casaortiz.model.Categoria;
import java.util.List;

/**
 *
 * @author jorge
 */
public class CategoriaBuss {
    
    private CategoriaDAO catDAO = new CategoriaDAO();
    
    public boolean guardar(Categoria item){
        
        try {
            catDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(Categoria item){
        try {
            catDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        try {
            catDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Categoria getCategoria(int id){
        Categoria item = null;
        try {
            item = catDAO.getCategoria(id);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public List<Categoria> getCategorias(){
        List<Categoria> items = null;
        try {
            items = catDAO.getCategorias();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
