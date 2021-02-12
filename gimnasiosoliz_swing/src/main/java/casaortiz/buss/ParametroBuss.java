/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.ParametroDAO;
import casaortiz.model.Parametro;

/**
 *
 * @author jorge
 */
public class ParametroBuss {
    
    private ParametroDAO parDAO;
    
    public ParametroBuss(){
        parDAO = new ParametroDAO();
    }
    
    public Parametro getParametro(){
        Parametro item = null;
        try {
            item = parDAO.getParametro(1);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public void actualizar(){
        
        Parametro item = getParametro();
        item.setNumero_recibo(item.getNumero_recibo()+1);
        try {
            parDAO.actualizar(item);
           
        } catch (Exception e) {
        }
    }
}
