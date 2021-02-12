/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.PersonaDAO;
import casaortiz.model.Persona;
import java.util.List;

/**
 *
 * @author jorge
 */
public class PersonaBuss {
    
    private PersonaDAO perDAO = new PersonaDAO();
    
    public boolean guardar(Persona item){
        
        try {
            perDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
    
    public boolean actualizar(Persona item){
        try {
            perDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        try {
            perDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Persona getPersona(int id){
        Persona item = null;
        try {
            item = perDAO.getPersona(id);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public List<Persona> getPersonas(){
        List<Persona> items = null;
        try {
            items = perDAO.getPersonas();
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
    
    public List<Persona> buscarPersonasPorNombre(String nombre){
        List<Persona> items = null;
        try {
            items = perDAO.buscarPersonasPorNombre(nombre);
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
    public List<Persona> buscarPersonasPorApellido(String apellido){
        List<Persona> items = null;
        try {
            items = perDAO.buscarPersonasPorApellido(apellido);
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
    public Persona buscarPersonaPorCedula(String cedula){
        Persona item = null;
        try {
            item = perDAO.buscarPersonaPorCedula(cedula);
            return item;
        } catch (Exception e) {
            return item;
        }
    }
    
    public List<Persona> buscarPersonasPorCedula(String cedula){
        List<Persona> items = null;
        try {
            items = perDAO.buscarPersonasPorCedula(cedula);
            return items;
        } catch (Exception e) {
            return items;
        }
    }
    
}
