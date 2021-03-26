/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.buss;

import casaortiz.dao.SuscripcionDAO;
import casaortiz.model.Suscripcion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorge
 */
public class SuscripcionBuss {
    
    private SuscripcionDAO susDAO;

    public SuscripcionBuss(){
        susDAO = new SuscripcionDAO();
    }
    
    public boolean guardar(Suscripcion item){
        try {
            susDAO.guardar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Suscripcion item){
        try {
            susDAO.actualizar(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id){
        try {
            susDAO.eliminar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Suscripcion getSuscripcion(int id){
        Suscripcion item = null;
        try {
            item = susDAO.getSuscripcion(id);
            return item;
        } catch (Exception e) {
            return item;
        }
    }

    public List<Suscripcion> getSuscripciones(){
        List<Suscripcion> items = null;
        try {
            items = susDAO.getSuscripciones();
            return items;
        } catch (Exception e) {
            return items;
        }
    }

    public List<Suscripcion> getHistorialSuscripcionesPersona(int idPersona){
        List<Suscripcion> items = null;
        try {
            items = susDAO.getHistorialSuscripcionesPersona(idPersona);
            return items;
        } catch (Exception e) {
            return items;
        }
    }

    public Date getFechaMaximaPorPersona(int idPersona){
        Date fechaMaxima = null;
        try {
            fechaMaxima = susDAO.getFechaMaximaPorPersona(idPersona);
            return fechaMaxima;
        } catch (Exception e) {
            return fechaMaxima;
        }
    }
}
