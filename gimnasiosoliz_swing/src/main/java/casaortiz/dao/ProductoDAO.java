/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.Producto;
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
public class ProductoDAO {
    
    private Conector conector = new Conector();
    
    public boolean guardar(Producto producto){
        Connection connect = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("insert into producto (nombre, descripcion, precio, codigo_barra, foto) values (?,?,?,?,?)");
            st.setString(1, producto.getNombre());
            st.setString(2, producto.getDescripcion());
            st.setDouble(3, producto.getPrecio());
            st.setString(4, producto.getCodigoBarra());
            st.setString(5, producto.getFoto());
            st.execute();
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public Producto getProducto(int id){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        Producto item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from producto p where p.id = ?");
            st.setInt(0, id);
            result = st.executeQuery();
            item = new Producto();
            item.setId(result.getInt("id"));
            item.setNombre(result.getString("nombre"));
            item.setDescripcion(result.getString("descripcion"));
            item.setPrecio(result.getDouble("precio"));
            item.setCodigoBarra(result.getString("codigo_barra"));
            conector.close(connect);
            return item;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return null;
        }
    }
    
    public boolean actualizar(Producto item){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("update producto set nombre = ?, descripcion = ?, precio = ?, codigo_barra = ?, foto = ? where id = ?");
            st.setString(1, item.getNombre());
            st.setString(2, item.getDescripcion());
            st.setDouble(3, item.getPrecio());
            st.setString(4, item.getCodigoBarra());
            st.setString(5, item.getFoto());
            st.setInt(6, item.getId());
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
            PreparedStatement st = connect.prepareStatement("delete from producto where id = "+id);
            st.executeUpdate();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public List<Producto> getProductos(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try{
            PreparedStatement st = connect.prepareStatement("select * from producto");
            result = st.executeQuery();
            List<Producto> items = new ArrayList<Producto>();
            while(result.next()){
                Producto producto = new Producto();
                producto.setId(result.getInt("id"));
                producto.setNombre(result.getString("nombre"));
                producto.setDescripcion(result.getString("descripcion"));
                producto.setPrecio(result.getDouble("precio"));
                producto.setCodigoBarra(result.getString("codigo_barra"));
                producto.setFoto(result.getString("foto"));
                items.add(producto);
            }
            connect.close();
            return items;
        }catch(SQLException ex){
            try {
                System.err.println(ex.getMessage());
                connect.close();
                return null;
            } catch (SQLException ex1) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
        
    }
    
    public List<Producto> buscarProductosPorNombre(String nombre){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try{
            PreparedStatement st = connect.prepareStatement("select * from producto p where p.nombre like '%"+nombre+"%'");
            result = st.executeQuery();
            List<Producto> items = new ArrayList<Producto>();
            while(result.next()){
                Producto producto = new Producto();
                producto.setId(result.getInt("id"));
                producto.setNombre(result.getString("nombre"));
                producto.setDescripcion(result.getString("descripcion"));
                producto.setPrecio(result.getDouble("precio"));
                producto.setCodigoBarra(result.getString("codigo_barra"));
                producto.setFoto(result.getString("foto"));
                items.add(producto);
            }
            connect.close();
            return items;
        }catch(SQLException ex){
            try {
                System.err.println(ex.getMessage());
                connect.close();
                return null;
            } catch (SQLException ex1) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
        
    }
    
    public List<Producto> buscarProductosPorCodigoBarra(String codigoBarra){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try{
            PreparedStatement st = connect.prepareStatement("select * from producto p where p.codigo_barra like '%"+codigoBarra+"%'");
            result = st.executeQuery();
            List<Producto> items = new ArrayList<Producto>();
            while(result.next()){
                Producto producto = new Producto();
                producto.setId(result.getInt("id"));
                producto.setNombre(result.getString("nombre"));
                producto.setDescripcion(result.getString("descripcion"));
                producto.setPrecio(result.getDouble("precio"));
                producto.setCodigoBarra(result.getString("codigo_barra"));
                producto.setFoto(result.getString("foto"));
                items.add(producto);
            }
            connect.close();
            return items;
        }catch(SQLException ex){
            try {
                System.err.println(ex.getMessage());
                connect.close();
                return null;
            } catch (SQLException ex1) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
        
    }
    
}