using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using gimnasiosoliz.BLL;
using gimnasiosoliz.DAL;

namespace gimnasiosoliz.PL
{
    public partial class frmProductos : Form
    {
        ProductoDAL productoDAL;
        public frmProductos()
        {
            productoDAL = new ProductoDAL();
            InitializeComponent();
            loadProductos();
        }

        private void btnExaminar_Click(object sender, EventArgs e)
        {

        }

        private void btnModificar_Click(object sender, EventArgs e)
        {

        }

        private ProductoBLL RecuperarInformacion()
        {
            ProductoBLL newProducto = new ProductoBLL();

            newProducto.ID = int.Parse(labelID.Text);
            newProducto.Nombre = txtNombre.Text;
            newProducto.Precio = Double.Parse(numPrecio.Text);
            newProducto.Descripcion = txtDescripcion.Text;
            newProducto.CodigoBarras = int.Parse(numCodigoBarra.Text);
            return newProducto;
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            //RecuperarInformacion();
            ProductoDAL productoDAL = new ProductoDAL();
            productoDAL.Create(RecuperarInformacion());
            loadProductos();
        }
        private void Seleccionar(object sender, DataGridViewCellMouseEventArgs e)
        {
            int indice = e.RowIndex;
            labelID.Text = dataProductos.Rows[indice].Cells[0].Value.ToString();
            txtNombre.Text = dataProductos.Rows[indice].Cells[1].Value.ToString();
            numPrecio.Text = dataProductos.Rows[indice].Cells[2].Value.ToString();
            txtDescripcion.Text = dataProductos.Rows[indice].Cells[3].Value.ToString();
            numCodigoBarra.Text = dataProductos.Rows[indice].Cells[4].Value.ToString();
        }

        private void loadProductos()
        {
            dataProductos.DataSource = productoDAL.ListarProductos().Tables[0];
        }

        private void btnBorrar_Click(object sender, EventArgs e)
        {
            productoDAL.Delete(RecuperarInformacion());
            loadProductos();
        }
    }
}
