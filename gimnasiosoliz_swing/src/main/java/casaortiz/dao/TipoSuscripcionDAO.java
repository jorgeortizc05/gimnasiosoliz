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
            PreparedStatement st = connect.prepareStatement("insert into tipo_suscripcion (nombre, precio, descripcion) values (?,?,?)");
            st.setString(1, item.getNombre());
            st.setDouble(2, item.getPrecio());
            st.setString(3, item.getDescripcion());
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
        connect = conector.getConexion();
        TipoSuscripcion item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from tipo_suscripcion ts where ts.id ="+id);
            result = st.executeQuery();
            item = new TipoSuscripcion();
            item.setId(result.getInt("id"));
            item.setNombre(result.getString("nombre"));
            item.setPrecio(result.getDouble("precio"));
            item.setDescripcion(result.getString("descripcion"));
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
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("update tipo_suscripcion set nombre = ?, precio = ?, descripcion = ? where id = ?");
            st.setString(1, item.getNombre());
            st.setDouble(2, item.getPrecio());
            st.setString(3, item.getDescripcion());
            st.setInt(4, item.getId());
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
        connect = conector.getConexion();
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
    
    public List<TipoSuscripcion> getCantones(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        List<TipoSuscripcion> items = null;
        try{
            PreparedStatement st = connect.prepareStatement("select * from tipo_suscripcion");
            result = st.executeQuery();
            items = new ArrayList<TipoSuscripcion>();
            while(result.next()){
                TipoSuscripcion item = new TipoSuscripcion();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
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
