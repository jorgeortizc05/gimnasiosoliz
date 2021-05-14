/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.SubCategoriaDAO;
import casaortiz.model.SubCategoria;
import java.util.List;

/**
 *
 * @author jorge
 */
public class SubCategoriaBuss {
    
    private SubCategoriaDAO subCatDao = new SubCategoriaDAO();
    
    public boolean guardar(SubCategoria item){
        
        try {
            subCatDao.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(SubCategoria item){
        try {
            subCatDao.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        try {
            subCatDao.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public SubCategoria getSubCategoria(int id){
        SubCategoria item = null;
        try {
            item = subCatDao.getSubCategoria(id);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public List<SubCategoria> getSubCategorias(){
        List<SubCategoria> items = null;
        try {
            items = subCatDao.getSubCategorias();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
