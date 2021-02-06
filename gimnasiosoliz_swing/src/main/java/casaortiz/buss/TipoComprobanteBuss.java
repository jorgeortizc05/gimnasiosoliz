/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.TipoComprobanteDAO;
import casaortiz.model.TipoComprobante;
import java.util.List;

/**
 *
 * @author jorge
 */
public class TipoComprobanteBuss {
    
    private TipoComprobanteDAO tcDAO = new TipoComprobanteDAO();
    
    public boolean guardar(TipoComprobante item){
        
        try {
            tcDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(TipoComprobante item){
        try {
            tcDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public TipoComprobante getTipoComprobante(int id){
        TipoComprobante item = null;
        try {
            item = tcDAO.getTipoComprobante(id);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public boolean eliminar(int id){
        try {
            tcDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<TipoComprobante> getTipoComprobantes(){
        List<TipoComprobante> items = null;
        try {
            items = tcDAO.getTipoComprobantes();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
