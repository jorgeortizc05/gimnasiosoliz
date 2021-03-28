/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class CategoriaDAO {
    private Conector conector = new Conector();
    
    public boolean guardar(Categoria item){
        Connection connect = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("insert into categoria (nombre, descripcion) values (?,?)");
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
    
    public Categoria getCategoria(int id){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        Categoria item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from categoria c where c.id ="+id);
            result = st.executeQuery();
            if(result.next()){
                item = new Categoria();
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
    
    public boolean actualizar(Categoria item){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("update categoria set nombre = ?, descripcion = ? where id = ?");
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
            PreparedStatement st = connect.prepareStatement("delete from categoria where id = "+id);
            st.executeUpdate();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public List<Categoria> getCategorias(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        List<Categoria> items = null;
        try{
            PreparedStatement st = connect.prepareStatement("select * from categoria");
            result = st.executeQuery();
            items = new ArrayList<Categoria>();
            while(result.next()){
                Categoria item = new Categoria();
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
