/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.TipoComprobante;
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
 */
public class TipoComprobanteDAO {
    
    private Conector conector = new Conector();
    
    public boolean guardar(TipoComprobante item){
        Connection connect = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("insert into tipo_comprobante (nombre, descripcion) values (?,?)");
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
    
    public TipoComprobante getTipoComprobante(int id){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        TipoComprobante item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from tipo_comprobante c where c.id = "+id);
            result = st.executeQuery();
            if(result.next()){
                item = new TipoComprobante();
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
    
    public boolean actualizar(TipoComprobante item){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("update tipo_comprobante set nombre = ?, descripcion = ? where id = ?");
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
        connect = conector.getConexion();
        try {
            System.out.println(id);
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("delete from tipo_comprobante where id = "+id);
            st.executeUpdate();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public List<TipoComprobante> getTipoComprobantes(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        List<TipoComprobante> items = null;
        try{
            PreparedStatement st = connect.prepareStatement("select * from tipo_comprobante");
            result = st.executeQuery();
            items = new ArrayList<TipoComprobante>();
            while(result.next()){
                TipoComprobante item = new TipoComprobante();
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
