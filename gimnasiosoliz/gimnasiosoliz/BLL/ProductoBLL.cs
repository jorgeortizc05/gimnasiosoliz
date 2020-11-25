using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace gimnasiosoliz.BLL
{
    class ProductoBLL
    {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public double Precio { get; set; }
        public string Descripcion { get; set; }
        public int CodigoBarras { get; set; }
        public byte[] imagen { get; set; }
    }
}
