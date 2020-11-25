using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace gimnasiosoliz.DAL
{
    class ConexionDAL
    {
        private string CadenaConexion = "Data Source=JORGE-PC\\SQLEXPRESS;Initial Catalog=gimnasiosoliz;Integrated Security=True";
        SqlConnection Conexion;
        
        public SqlConnection EstablecerConexion()
        {
            this.Conexion = new SqlConnection(this.CadenaConexion);

            return this.Conexion;
        }
        public bool sentencia(string comando)
        {
            try
            {
                
                SqlCommand Comando = new SqlCommand();

                Comando.CommandText = comando;
                Comando.Connection = this.EstablecerConexion();
                Conexion.Open();
                Comando.ExecuteNonQuery();
                Conexion.Close();

                return true;

            }
            catch
            {
                return false;
            }
        }

        public DataSet Select(SqlCommand sqlComando)
        {
            DataSet DS = new DataSet();
            SqlDataAdapter Adaptador = new SqlDataAdapter();

            try
            {
                SqlCommand Comando = new SqlCommand();
                Comando = sqlComando;
                Comando.Connection = EstablecerConexion();
                Adaptador.SelectCommand = Comando;
                Conexion.Open();
                Adaptador.Fill(DS);
                Conexion.Close();
                return DS;
            }
            catch
            {
                return DS;
            }
        }
    }
}
