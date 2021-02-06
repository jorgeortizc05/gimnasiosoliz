/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.Empresa;
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
public class EmpresaDAO {
    
    private Conector conector = new Conector();
    
    public boolean guardar(Empresa item){
        Connection connect = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("insert into empresa (nombre, descripcion, RUC, direccion_matriz, direccion_sucursal, id_canton) values (?,?,?,?,?,?)");
            st.setString(1, item.getNombre());
            st.setString(2, item.getDescripcion());
            st.setString(3, item.getRUC());
            st.setString(4, item.getDireccionMatriz());
            st.setString(5, item.getDireccionSucursal());
            st.setInt(6, item.getIdCanton());
            st.execute();
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public Empresa getEmpresa(int id){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        Empresa item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from empresa e where e.id = "+id);
            result = st.executeQuery();
            item = new Empresa();
            item.setId(result.getInt("id"));
            item.setNombre(result.getString("nombre"));
            item.setDescripcion(result.getString("descripcion"));
            item.setRUC(result.getString("RUC"));
            item.setDireccionMatriz(result.getString("direccion_matriz"));
            item.setDireccionSucursal(result.getString("direccion_sucursal"));
            item.setIdCanton(result.getInt("id_canton"));
            conector.close(connect);
            return item;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return null;
        }
    }
    
    public boolean actualizar(Empresa item){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("update empresa set nombre = ?, descripcion = ?, RUC = ?, direccion_matriz = ?, direccion_sucursal = ?, id_canton = ? where id = ?");
            st.setString(1, item.getNombre());
            st.setString(2, item.getDescripcion());
            st.setString(3, item.getRUC());
            st.setString(4, item.getDireccionMatriz());
            st.setString(5, item.getDireccionSucursal());
            st.setInt(6, item.getIdCanton());
            st.setInt(7, item.getId());
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
            PreparedStatement st = connect.prepareStatement("delete from empresa where id = "+id);
            st.executeUpdate();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public List<Empresa> getEmpresas(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try{
            PreparedStatement st = connect.prepareStatement("select * from empresa");
            result = st.executeQuery();
            List<Empresa> items = new ArrayList<Empresa>();
            while(result.next()){
                Empresa item = new Empresa();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
                item.setDescripcion(result.getString("descripcion"));
                item.setRUC(result.getString("RUC"));
                item.setDireccionMatriz(result.getString("direccion_matriz"));
                item.setDireccionSucursal(result.getString("direccion_sucursal"));
                item.setIdCanton(result.getInt("id_canton"));
                items.add(item);
            }
            connect.close();
            return items;
        }catch(SQLException ex){
            try {
                System.err.println(ex.getMessage());
                connect.close();
                return null;
            } catch (SQLException ex1) {
                Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
        
    }
    
}