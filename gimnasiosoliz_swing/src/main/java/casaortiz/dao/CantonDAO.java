/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.Canton;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 * Mantenimiento de la tabla canton
 */
public class CantonDAO {
    
    private Conector conector = new Conector();
    
    public boolean guardar(Canton item){
        Connection connect = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("insert into canton (nombre, descripcion) values (?,?)");
            st.setString(1, item.getNombre());
            st.setString(2, item.getDescripcion());
            st.execute();
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public Canton getCanton(int id){
        Connection connect = null;
        ResultSet result = null;
        Canton item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from canton c where c.id ="+id);
            result = st.executeQuery();
            if(result.next()){
                item = new Canton();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
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
    
    public boolean actualizar(Canton item){
        Connection connect = null;
        ResultSet result = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("update canton set nombre = ?, descripcion = ? where id = ?");
            st.setString(1, item.getNombre());
            st.setString(2, item.getDescripcion());
            st.setInt(3, item.getId());
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
            PreparedStatement st = connect.prepareStatement("delete from canton where id = "+id);
            st.executeUpdate();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public List<Canton> getCantones(){
        Connection connect = null;
        ResultSet result = null;
        List<Canton> items = null;
        try{
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from canton");
            result = st.executeQuery();
            items = new ArrayList<Canton>();
            while(result.next()){
                Canton item = new Canton();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
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
