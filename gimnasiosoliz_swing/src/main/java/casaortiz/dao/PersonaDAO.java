/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.Persona;
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
public class PersonaDAO {
    
    private Conector conector = new Conector();
    
    public boolean guardar(Persona item){
        Connection connect = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("insert into persona "
                    + "(nombre, apellido, cedula, direccion, email, "
                    + "fecha_nacimiento, telefono, activo, foto, tipo_persona_id) "
                    + "values (?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, item.getNombre());
            st.setString(2, item.getApellido());
            st.setString(3, item.getCedula());
            st.setString(4, item.getDireccion());
            st.setString(5, item.getEmail());
            st.setDate(6, new java.sql.Date(item.getFechaNacimiento().getTime()));
            st.setString(7, item.getTelefono());
            st.setString(8, item.getActivo());
            st.setString(9, item.getFoto());
            st.setInt(10, item.getTipoPersonaId());
            st.execute();
            conector.close(connect);
            return true;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public Persona getPersona(int id){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        Persona item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from persona p where p.id ="+id);
            result = st.executeQuery();
            if(result.next()){
                item = new Persona();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
                item.setApellido(result.getString("apellido"));
                item.setCedula(result.getString("cedula"));
                item.setDireccion(result.getString("direccion"));
                item.setEmail(result.getString("email"));
                item.setFechaNacimiento(result.getDate("fecha_nacimiento"));
                item.setTelefono(result.getString("telefono"));
                item.setActivo(result.getString("activo"));
                item.setFoto(result.getString("foto"));
                item.setTipoPersonaId(result.getInt("tipo_persona_id"));
            }
            conector.close(connect);
            return item;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return item;
        }
    }
    
    public boolean actualizar(Persona item){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("update persona set "
                    + "nombre = ?, apellido = ?, cedula = ?, direccion = ?, "
                    + "email = ?, fecha_nacimiento = ?, telefono = ?, activo = ?, foto = ?, "
                    + "tipo_persona_id = ? where id = ?");
            st.setString(1, item.getNombre());
            st.setString(2, item.getApellido());
            st.setString(3, item.getCedula());
            st.setString(4, item.getDireccion());
            st.setString(5, item.getEmail());
            st.setDate(6, new java.sql.Date(item.getFechaNacimiento().getTime()));
            st.setString(7, item.getTelefono());
            st.setString(8, item.getActivo());
            st.setString(9, item.getFoto());
            st.setInt(10, item.getTipoPersonaId());
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
        connect = conector.getConexion();
        try {
            System.out.println(id);
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("delete from persona where id = "+id);
            st.executeUpdate();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
    
    public List<Persona> getPersonas(){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        List<Persona> items = null;
        try{
            PreparedStatement st = connect.prepareStatement("select * from persona p order by p.id desc limit 300");
            result = st.executeQuery();
            items = new ArrayList<Persona>();
            while(result.next()){
                Persona item = new Persona();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
                item.setApellido(result.getString("apellido"));
                item.setCedula(result.getString("cedula"));
                item.setDireccion(result.getString("direccion"));
                item.setEmail(result.getString("email"));
                item.setFechaNacimiento(result.getDate("fecha_nacimiento"));
                item.setTelefono(result.getString("telefono"));
                item.setActivo(result.getString("activo"));
                item.setFoto(result.getString("foto"));
                item.setTipoPersonaId(result.getInt("tipo_persona_id"));
                items.add(item);
                
            }
            connect.close();
            return items;
        }catch(SQLException ex){
            conector.close(connect);
            return items;
        } 
    }
    
    public List<Persona> buscarPersonas(String nombre){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        List<Persona> items = null;
        try{
            PreparedStatement st = connect.prepareStatement("select * from persona p where p.nombre || ' '||p.apellido ||' '||p.cedula like '%"+nombre+"%' order by p.id desc");
            result = st.executeQuery();
            items = new ArrayList<Persona>();
            while(result.next()){
                Persona item = new Persona();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
                item.setApellido(result.getString("apellido"));
                item.setCedula(result.getString("cedula"));
                item.setDireccion(result.getString("direccion"));
                item.setEmail(result.getString("email"));
                item.setFechaNacimiento(result.getDate("fecha_nacimiento"));
                item.setTelefono(result.getString("telefono"));
                item.setActivo(result.getString("activo"));
                item.setFoto(result.getString("foto"));
                item.setTipoPersonaId(result.getInt("tipo_persona_id"));
                items.add(item);
                
            }
            connect.close();
            return items;
        }catch(SQLException ex){
            conector.close(connect);
            return items;
        } 
    }
    
    public Persona buscarPersonaPorCedula(String cedula){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        Persona item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from persona p where p.cedula like '"+cedula+"' order by p.id desc");
            result = st.executeQuery();
            if(result.next()){
                item = new Persona();
                item.setId(result.getInt("id"));
                item.setNombre(result.getString("nombre"));
                item.setApellido(result.getString("apellido"));
                item.setCedula(result.getString("cedula"));
                item.setDireccion(result.getString("direccion"));
                item.setEmail(result.getString("email"));
                item.setFechaNacimiento(result.getDate("fecha_nacimiento"));
                item.setTelefono(result.getString("telefono"));
                item.setActivo(result.getString("activo"));
                item.setFoto(result.getString("foto"));
                item.setTipoPersonaId(result.getInt("tipo_persona_id"));
            }
            conector.close(connect);
            return item;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return item;
        }
    }
    
}
