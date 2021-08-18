/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.Suscripcion;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorge
 */
public class SuscripcionDAO {
    
    private Conector conector = new Conector();
    
    public boolean guardar(Suscripcion item){
        Connection connect = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("INSERT INTO suscripcion "
                    + "(numero_recibo, fecha_suscripcion, fecha_desde,fecha_hasta,precio,descuento,"
                    + "importe_total,observaciones,persona_id,tipo_suscripcion_id)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?);");
            st.setString(1, item.getNumeroRecibo());
            st.setDate(2, new java.sql.Date(item.getFechaSuscripcion().getTime()));
            st.setDate(3, new java.sql.Date(item.getFechaDesde().getTime()));
            st.setDate(4, new java.sql.Date(item.getFechaHasta().getTime()));
            st.setDouble(5, item.getPrecio());
            st.setDouble(6, item.getDescuento());
            st.setDouble(7, item.getImporteTotal());
            st.setString(8, item.getObservaciones());
            st.setInt(9, item.getPersonaId());
            st.setInt(10, item.getTipoSuscripcionId());
            st.execute();
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public Suscripcion getSuscripcion(int id){
        Connection connect = null;
        ResultSet result = null;
        Suscripcion item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from suscripcion c where c.id ="+id);
            result = st.executeQuery();
            if(result.next()){
                item = new Suscripcion();
                item.setId(result.getInt("id"));
                item.setNumeroRecibo(result.getString("numero_recibo"));
                item.setFechaSuscripcion(result.getDate("fecha_suscripcion"));
                item.setFechaDesde(result.getDate("fecha_desde"));
                item.setFechaHasta(result.getDate("fecha_hasta"));
                item.setPrecio(result.getDouble("precio"));
                item.setDescuento(result.getDouble("descuento"));
                item.setImporteTotal(result.getDouble("importe_total"));
                item.setObservaciones(result.getString("observaciones"));
                item.setPersonaId(result.getInt("persona_id"));
                item.setTipoSuscripcionId(result.getInt("tipo_suscripcion_id"));
            }
            conector.close(connect);
            return item;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return item;
        }
    }
    
    public boolean actualizar(Suscripcion item){
        Connection connect = null;
        ResultSet result = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("UPDATE suscripcion\n" +
                    "   SET id = 'id',\n" +
                    "       numero_recibo = ?,\n" +
                    "       fecha_suscripcion = ?,\n" +
                    "       fecha_desde = ?,\n" +
                    "       fecha_hasta = ?,\n" +
                    "       precio = ?,\n" +
                    "       descuento = ?,\n" +
                    "       importe_total = ?,\n" +
                    "       observaciones = ?,\n" +
                    "       persona_id = ?,\n" +
                    "       tipo_suscripcion_id = ?\n" +
                    " WHERE id = 'id'");
            st.setString(1, item.getNumeroRecibo());
            st.setDate(2, new java.sql.Date(item.getFechaSuscripcion().getTime()));
            st.setDate(3, new java.sql.Date(item.getFechaDesde().getTime()));
            st.setDate(4, new java.sql.Date(item.getFechaHasta().getTime()));
            st.setDouble(5, item.getPrecio());
            st.setDouble(6, item.getDescuento());
            st.setDouble(7, item.getImporteTotal());
            st.setString(8, item.getObservaciones());
            st.setInt(9, item.getPersonaId());
            st.setInt(10, item.getTipoSuscripcionId());
            st.setInt(11, item.getId());
            st.execute();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public boolean eliminar(int id){
        Connection connect = null;
        ResultSet result = null;
        try {
            System.out.println(id);
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("delete from suscripcion where id = "+id);
            st.executeUpdate();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public List<Suscripcion> getSuscripciones(){
        Connection connect = null;
        ResultSet result = null;
        List<Suscripcion> items = null;
        try{
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from suscripcion");
            result = st.executeQuery();
            items = new ArrayList<Suscripcion>();
            while(result.next()){
                Suscripcion item = new Suscripcion();
                item.setId(result.getInt("id"));
                item.setNumeroRecibo(result.getString("numero_recibo"));
                item.setFechaSuscripcion(result.getDate("fecha_suscripcion"));
                item.setFechaDesde(result.getDate("fecha_desde"));
                item.setFechaHasta(result.getDate("fecha_hasta"));
                item.setPrecio(result.getDouble("precio"));
                item.setDescuento(result.getDouble("descuento"));
                item.setImporteTotal(result.getDouble("importe_total"));
                item.setObservaciones(result.getString("observaciones"));
                item.setPersonaId(result.getInt("persona_id"));
                item.setTipoSuscripcionId(result.getInt("tipo_suscripcion_id"));
                items.add(item);
            }
            connect.close();
            return items;
        }catch(SQLException ex){
            conector.close(connect);
            return items;
        }
    }
    
    public List<Suscripcion> getHistorialSuscripcionesPersona(int idPersona){
        Connection connect = null;
        ResultSet result = null;
        List<Suscripcion> items = null;
        try{
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from suscripcion s where s.persona_id = "+idPersona+" order by s.fecha_hasta desc");
            result = st.executeQuery();
            items = new ArrayList<Suscripcion>();
            while(result.next()){
                Suscripcion item = new Suscripcion();
                item.setId(result.getInt("id"));
                item.setNumeroRecibo(result.getString("numero_recibo"));
                item.setFechaSuscripcion(result.getDate("fecha_suscripcion"));
                item.setFechaDesde(result.getDate("fecha_desde"));
                item.setFechaHasta(result.getDate("fecha_hasta"));
                item.setPrecio(result.getDouble("precio"));
                item.setDescuento(result.getDouble("descuento"));
                item.setImporteTotal(result.getDouble("importe_total"));
                item.setObservaciones(result.getString("observaciones"));
                item.setPersonaId(result.getInt("persona_id"));
                item.setTipoSuscripcionId(result.getInt("tipo_suscripcion_id"));
                items.add(item);
            }
            connect.close();
            return items;
        }catch(SQLException ex){
            conector.close(connect);
            return items;
        }
    }
    
    public Date getFechaMaximaPorPersona(int idPersona){
        Connection connect = null;
        ResultSet result = null;
        Date fechaMaxima = null;
        try{
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select max(s.fecha_hasta) as fecha_maxima\n" +
                            "from suscripcion s\n" +
                            "where s.persona_id = "+idPersona);
            result = st.executeQuery();
            if(result.next()){
                fechaMaxima = result.getDate("fecha_maxima");
            }
            connect.close();
            return fechaMaxima;
        }catch(SQLException ex){
            conector.close(connect);
            return fechaMaxima;
        }
    }
}
