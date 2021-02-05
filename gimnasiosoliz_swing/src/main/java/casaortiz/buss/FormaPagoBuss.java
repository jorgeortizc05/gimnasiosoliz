/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.CantonDAO;
import casaortiz.dao.FormaPagoDAO;
import casaortiz.model.Canton;
import casaortiz.model.FormaPago;
import casaortiz.model.Producto;
import java.util.List;

/**
 *
 * @author jorge
 */
public class FormaPagoBuss {
    
    private FormaPagoDAO fpDAO = new FormaPagoDAO();
    
    public boolean guardar(FormaPago item){
        
        try {
            fpDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(FormaPago item){
        try {
            fpDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        try {
            fpDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<FormaPago> getFormaPagos(){
        List<FormaPago> items = null;
        try {
            items = fpDAO.getFormaPagos();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
