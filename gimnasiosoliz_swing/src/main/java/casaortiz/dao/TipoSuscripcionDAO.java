/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.TipoSuscripcion;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class TipoSuscripcionDAO {
    
    private Conector conector = new Conector();
    
    public boolean guardar(TipoSuscripcion item){
        Connection connect = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("insert into tipo_suscripcion (nombre, numero_dias, precio, descripcion) values (?,?,?,?)");
            st.setString(1, item.getNombre());
            st.setInt(2, item.getNumeroDias());
            st.setDouble(3, item.getPrecio());
            st.setString(4, item.getDescripcion());
            st.execute();
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public TipoSuscripcion getTipoSuscripcion(int id){
        Connection connect = null;
        ResultSet result = null;
        TipoSuscripcion item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from tipo_suscripcion ts where ts.id ="+id);
            result = st.executeQuery();
            if(result.next()){
                item = new TipoSuscripcion();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
                item.setNumeroDias(result.getInt("numero_dias"));
                item.setPrecio(result.getDouble("precio"));
                item.setDescripcion(result.getString("descripcion"));
            }
            conector.close(connect);
            return item;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return item;
        }
    }
    
    public boolean actualizar(TipoSuscripcion item){
        Connection connect = null;
        ResultSet result = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("update tipo_suscripcion set nombre = ?, numero_dias = ?, precio = ?, descripcion = ? where id = ?");
            st.setString(1, item.getNombre());
            st.setInt(2, item.getNumeroDias());
            st.setDouble(3, item.getPrecio());
            st.setString(4, item.getDescripcion());
            st.setInt(5, item.getId());
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
            PreparedStatement st = connect.prepareStatement("delete from tipo_suscripcion where id = "+id);
            st.executeUpdate();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public List<TipoSuscripcion> geTipoSuscripciones(){
        Connection connect = null;
        ResultSet result = null;
        List<TipoSuscripcion> items = null;
        try{
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from tipo_suscripcion");
            result = st.executeQuery();
            items = new ArrayList<TipoSuscripcion>();
            while(result.next()){
                TipoSuscripcion item = new TipoSuscripcion();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
                item.setNumeroDias(result.getInt("numero_dias"));
                item.setPrecio(result.getDouble("precio"));
                item.setDescripcion(result.getString("descripcion"));
                items.add(item);
            }
            connect.close();
            return items;
        }catch(SQLException ex){
            conector.close(connect);
            return items;
        }
    }
    
}
