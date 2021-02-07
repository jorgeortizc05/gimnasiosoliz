/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.org.gimnasiosoliz;

import casaortiz.dao.NuevaBaseDatos;
import casaortiz.dao.ProductoDAO;
import casaortiz.db.Conector;
import casaortiz.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author jorge
 */
public class main {
    
    public static void main(String args[]){
        NuevaBaseDatos ndb = new NuevaBaseDatos();
        ndb.crearTablaProducto();
        ndb.crearTablaFormaPago();
        ndb.crearTablaCanton();
        ndb.crearTablaEmpresa();
        ndb.crearTablaTipoComprobante();
        ndb.crearTablaTipoPersona();
        ndb.crearTablaPersona();
        ndb.crearTablaTipoSuscripción();
    }
}
