/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import java.sql.Connection;
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
    
    public boolean crearCategoria(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS categoria (\n" +
            "    id          INTEGER       CONSTRAINT pk_id_categoria PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT\n" +
            "                              CONSTRAINT id_unique UNIQUE ON CONFLICT ROLLBACK,\n" +
            "    nombre      VARCHAR (100),\n" +
            "    descripcion VARCHAR (300) \n" +
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
            stmt.execute("CREATE TABLE IF NOT EXISTS empresa (\n" +
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
            "    foto             STRING (300),\n" +
            "    id_tipo_persona  INTEGER (1000000) REFERENCES tipo_persona (id) ON DELETE CASCADE\n" +
            "                                                                    ON UPDATE CASCADE\n" +
            "                                       CONSTRAINT id_tipo_persona_not_null NOT NULL ON CONFLICT ROLLBACK\n" +
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
            "    foto         VARCHAR (300),\n" +
            "    id_categoria INTEGER          CONSTRAINT fk_id_categoria REFERENCES categoria (id) ON DELETE CASCADE\n" +
            "                                                                                       ON UPDATE CASCADE\n" +
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
    
    public boolean crearTablaTipoSuscripción(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS tipo_suscripcion (\n" +
                "    id          INTEGER          CONSTRAINT id_pk PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT\n" +
                "                                 CONSTRAINT id_not_null NOT NULL ON CONFLICT ROLLBACK,\n" +
                "    nombre      VARCHAR (50)     CONSTRAINT nombre_not_null NOT NULL ON CONFLICT ROLLBACK\n" +
                "                                 CONSTRAINT nombre_unique UNIQUE ON CONFLICT ROLLBACK,\n" +
                "    numero_dias INTEGER (4)      CONSTRAINT numero_dias_not_null NOT NULL ON CONFLICT ROLLBACK,\n" +
                "    precio      DOUBLE (1000, 2),\n" +
                "    descripcion VARCHAR (300) \n" +
                ");");
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public boolean crearTablaSuscripcion(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS suscripcion (\n" +
            "    id              INTEGER           CONSTRAINT id_pk PRIMARY KEY AUTOINCREMENT\n" +
            "                                      CONSTRAINT id_not_null NOT NULL ON CONFLICT ROLLBACK\n" +
            "                                      CONSTRAINT id_unique UNIQUE ON CONFLICT ROLLBACK,\n" +
            "    numero_recibo   VARCHAR (70)      CONSTRAINT numero_recibo_unique UNIQUE ON CONFLICT ROLLBACK\n" +
            "                                      CONSTRAINT numero_recibo_not_null NOT NULL ON CONFLICT ROLLBACK,\n" +
            "    fecha_desde     DATE,\n" +
            "    fecha_hasta     DATE,\n" +
            "    precio          DOUBLE (1000, 2),\n" +
            "    descuento       DOUBLE (100, 2),\n" +
            "    importe_total   DOUBLE (1000, 2),\n" +
            "    observaciones   VARCHAR (300),\n" +
            "    id_persona      INTEGER (1000000) CONSTRAINT id_persona_fk REFERENCES persona (id) ON DELETE CASCADE\n" +
            "                                                                                       ON UPDATE CASCADE\n" +
            "                                      CONSTRAINT id_persona_not_null NOT NULL ON CONFLICT ROLLBACK,\n" +
            "    id_tipo_suscripcion INTEGER (1000000) CONSTRAINT id_tipo_suscripcion_fk REFERENCES tipo_suscripcion (id) ON DELETE CASCADE\n" +
            "                                                                                                         ON UPDATE CASCADE\n" +
            "                                      CONSTRAINT id_tipo_suscripcion_not_null NOT NULL ON CONFLICT ROLLBACK\n" +
            ");");
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public boolean crearTablaParámetros(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            Statement stmt = connect.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS parametro (\n" +
                "    id                 INTEGER CONSTRAINT id_pk PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT,\n" +
                "    numero_comprobante\n" +
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
