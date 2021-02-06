/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.Canton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jorge
 */
public class NuevaBaseDatos {
    
    private Conector conector = new Conector();
    
    public boolean crearTablaCanton(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS canton (\n" +
                "    id           INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    nombre       VARCHAR (50),\n" +
                "    descripcion  VARCHAR (300)\n" +
                ");");
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public boolean crearTablaEmpresa(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE empresa (\n" +
                "    id                 INTEGER           PRIMARY KEY AUTOINCREMENT,\n" +
                "    nombre             VARCHAR (70),\n" +
                "    descripcion        VARCHAR (300),\n" +
                "    RUC                VARCHAR (30)      CONSTRAINT RUC_unique UNIQUE ON CONFLICT ROLLBACK,\n" +
                "    direccion_matriz   VARCHAR (300),\n" +
                "    direccion_sucursal VARCHAR (300),\n" +
                "    id_canton          INTEGER (1000000) REFERENCES canton (id) ON DELETE CASCADE\n" +
                "                                                                ON UPDATE CASCADE\n" +
                "                                         CONSTRAINT id_canton_not_null NOT NULL ON CONFLICT ROLLBACK\n" +
                ");");
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public boolean crearTablaFormaPago(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS forma_pago (\n" +
                "    id           INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    nombre       VARCHAR (50),\n" +
                "    descripcion  VARCHAR (300)\n" +
                ");");
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public boolean crearTablaPersona(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS persona (\n" +
                "    id               INTEGER           PRIMARY KEY AUTOINCREMENT,\n" +
                "    nombre           VARCHAR (70)      CONSTRAINT nombre_not_null NOT NULL ON CONFLICT ROLLBACK,\n" +
                "    apellido         VARCHAR (70)      CONSTRAINT apellido_not_null NOT NULL ON CONFLICT ROLLBACK,\n" +
                "    cedula           VARCHAR (16)      CONSTRAINT cedula_unique UNIQUE ON CONFLICT ROLLBACK\n" +
                "                                       CONSTRAINT cedula_not_null NOT NULL ON CONFLICT ROLLBACK,\n" +
                "    direccion        VARCHAR (300),\n" +
                "    email            VARCHAR (150),\n" +
                "    fecha_nacimiento DATE,\n" +
                "    telefono         VARCHAR (40),\n" +
                "    activo           VARCHAR (1),\n" +
                "    id_tipo_persona  INTEGER (1000000) REFERENCES tipo_persona (id) ON DELETE CASCADE\n" +
                "                                                                    ON UPDATE CASCADE\n" +
                ");");
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public boolean crearTablaProducto(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS producto (\n" +
                "    id           INTEGER          PRIMARY KEY AUTOINCREMENT,\n" +
                "    nombre       VARCHAR (50),\n" +
                "    descripcion  VARCHAR (300),\n" +
                "    precio       DOUBLE (1000, 2),\n" +
                "    codigo_barra VARCHAR (30),\n" +
                "    foto         VARCHAR (300) \n" +
                ");");
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public boolean crearTablaTipoComprobante(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS tipo_comprobante (\n" +
                "    id           INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    nombre       VARCHAR (50),\n" +
                "    descripcion  VARCHAR (300)\n" +
                ");");
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public boolean crearTablaTipoPersona(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS tipo_persona (\n" +
                "    id           INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    nombre       VARCHAR (50),\n" +
                "    descripcion  VARCHAR (300)\n" +
                ");");
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    
}
