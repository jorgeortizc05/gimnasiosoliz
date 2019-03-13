package fusionsystem.jorgeortiz.gimnasiosoliz.util;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbConexion
{
  public static Connection getConexion()
    
  {
    Connection con = null;
    try
    {
      Context ctx = new InitialContext();
      DataSource ds = (DataSource)ctx.lookup("jboss/datasources/gimnasiosolizDS");
      con = ds.getConnection();
    }
    catch (Exception e)
    {
      System.err.println("Exsql DbCon.getCon:" + e.getMessage());
      
    }
    return con;
  }
  
  public static void liberaConexion(Connection conn)
  {
    try
    {
      conn.close();
    }
    catch (SQLException esql)
    {
      System.err.println("DbCon.lib.close:" + esql.getMessage());
    }
  }
}
