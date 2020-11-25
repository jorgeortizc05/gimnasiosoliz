using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using gimnasiosoliz.BLL;

namespace gimnasiosoliz.DAL
{
    class ProductoDAL
    {
        ConexionDAL conexion;

        public ProductoDAL()
        {
            conexion = new ConexionDAL();
        }

        public bool Create(ProductoBLL producto)
        {
            return conexion.sentencia("INSERT INTO producto(nombre,precio,descripcion,codigo_barra,imagen)VALUES('"+producto.Nombre+"', "+producto.Precio+", '"+producto.Descripcion+"',"+producto.CodigoBarras+", null)");
        }

        public int Delete(ProductoBLL producto)
        {
            conexion.sentencia("DELETE FROM Producto WHERE id="+producto.ID);
            return 1;
        }

        public DataSet ListarProductos()
        {
            SqlCommand sentencia = new SqlCommand("SELECT * FROM Producto");

            return conexion.Select(sentencia);
        }
    }
}
