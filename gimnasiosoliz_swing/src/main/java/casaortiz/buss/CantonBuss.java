/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.CantonDAO;
import casaortiz.model.Canton;
import casaortiz.model.Producto;
import java.util.List;

/**
 *
 * @author jorge
 */
public class CantonBuss {
    
    private CantonDAO canDAO = new CantonDAO();
    
    public boolean guardar(Canton item){
        
        try {
            canDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(Canton item){
        try {
            canDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        try {
            canDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Canton getCanton(int id){
        Canton item = null;
        try {
            item = canDAO.getCanton(id);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public List<Canton> getCantones(){
        List<Canton> items = null;
        try {
            items = canDAO.getCantones();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
