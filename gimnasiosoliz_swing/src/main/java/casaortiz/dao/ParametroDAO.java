/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.dao;

import casaortiz.db.Conector;
import casaortiz.model.Parametro;
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
//Controla el numero de recibo
public class ParametroDAO {
    
    private Conector conector = new Conector();
    
    public Parametro getParametro(int id){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        Parametro item = null;
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("select * from parametro c where c.id ="+id);
            result = st.executeQuery();
            item = new Parametro();
            item.setId(result.getInt("id"));
            item.setNumero_recibo(result.getInt("numero_recibo"));
            conector.close(connect);
            return item;
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return item;
        }
    }
    
    public boolean actualizar(Parametro item){
        Connection connect = null;
        ResultSet result = null;
        connect = conector.getConexion();
        try {
            connect = conector.getConexion();
            PreparedStatement st = connect.prepareStatement("update parametro set numero_recibo = ? where id = ?");
            st.setInt(1, item.getNumero_recibo());
            st.setInt(2, item.getId());
            st.execute();
            conector.close(connect);
            return true;            
        } catch (SQLException ex) { 
            System.err.println(ex.getMessage());
            conector.close(connect);
            return false;
        }
    }
}
