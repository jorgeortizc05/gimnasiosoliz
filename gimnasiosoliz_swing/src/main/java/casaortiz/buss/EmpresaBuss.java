/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.EmpresaDAO;
import casaortiz.model.Canton;
import casaortiz.model.Empresa;
import casaortiz.model.Producto;
import java.util.List;

/**
 *
 * @author jorge
 */
public class EmpresaBuss {
    
    private EmpresaDAO empDAO = new EmpresaDAO();
    
    public boolean guardar(Empresa item){
        
        try {
            empDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(Empresa item){
        try {
            empDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        try {
            empDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Empresa getEmpresa(int id){
        Empresa item = null;
        try {
            item = empDAO.getEmpresa(id);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public List<Empresa> getEmpresas(){
        List<Empresa> items = null;
        try {
            items = empDAO.getEmpresas();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
