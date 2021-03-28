/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.TipoSuscripcionDAO;
import casaortiz.model.TipoSuscripcion;
import java.util.List;

/**
 *
 * @author jorge
 */
public class TipoSuscripcionBuss {
    
    private TipoSuscripcionDAO tsDAO = new TipoSuscripcionDAO();
    
    public boolean guardar(TipoSuscripcion item){
        
        try {
            tsDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(TipoSuscripcion item){
        try {
            tsDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        try {
            tsDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public TipoSuscripcion getTipoSuscripcion(int id){
        TipoSuscripcion item = null;
        try {
            item = tsDAO.getTipoSuscripcion(id);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public List<TipoSuscripcion> getTipoSuscripciones(){
        List<TipoSuscripcion> items = null;
        try {
            items = tsDAO.geTipoSuscripciones();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
