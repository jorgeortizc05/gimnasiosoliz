/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;


import casaortiz.dao.TipoPersonaDAO;
import casaortiz.model.TipoPersona;
import java.util.List;

/**
 *
 * @author jorge
 */
public class TipoPersonaBuss {
    
    private TipoPersonaDAO tpDAO = new TipoPersonaDAO();
    
    public boolean guardar(TipoPersona item){
        
        try {
            tpDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(TipoPersona item){
        try {
            tpDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public TipoPersona getTipoPersona(int id){
        TipoPersona item = null;
        try {
            item = tpDAO.getTipoPersona(id);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public boolean eliminar(int id){
        try {
            tpDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<TipoPersona> getTipoPersonas(){
        List<TipoPersona> items = null;
        try {
            items = tpDAO.getTipoPersonas();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
