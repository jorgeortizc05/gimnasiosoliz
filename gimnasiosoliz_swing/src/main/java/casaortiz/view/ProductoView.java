/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.ProductoBuss;
import casaortiz.model.Producto;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class ProductoView extends javax.swing.JPanel {
    
    private Producto producto;
    private ProductoBuss prodBuss;
    private JFileChooser fc;
    private File file;
    private File dest;
    
    public ProductoView() {
        initComponents();
        prodBuss = new ProductoBuss();
        loadProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPDatosProducto = new javax.swing.JPanel();
        jBGuardarProducto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        JTFNombre = new javax.swing.JTextField();
        JBListar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTFPrecio = new javax.swing.JTextField();
        JTFCodigoBarra = new javax.swing.JTextField();
        JBEditar = new javax.swing.JButton();
        JBOk = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        jLFoto = new javax.swing.JLabel();
        jBEligirImagen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTADescripcion = new javax.swing.JTextArea();
        JBVaciarFormulario = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProductos = new javax.swing.JTable();
        jTFBuscarNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFBuscarCodigoBarras = new javax.swing.JTextField();
        JBLimpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatosProducto.setBackground(java.awt.Color.white);
        jPDatosProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        jPDatosProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBGuardarProducto.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jBGuardarProducto.setText("Guardar");
        jBGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarProductoActionPerformed(evt);
            }
        });
        jPDatosProducto.add(jBGuardarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 140, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setText("ID:");
        jPDatosProducto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setText("Nombre:");
        jPDatosProducto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setText("Descripcion:");
        jPDatosProducto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPDatosProducto.add(jLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, 20));
        jPDatosProducto.add(JTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 260, -1));

        JBListar.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        JBListar.setText("Listar");
        JBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListarActionPerformed(evt);
            }
        });
        jPDatosProducto.add(JBListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 140, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setText("Codigo Barras:");
        jPDatosProducto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel7.setText("Precio:");
        jPDatosProducto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        JTFPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTFPrecio.setInputVerifier(new VerificarSoloNumeros());
        jPDatosProducto.add(JTFPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 100, -1));
        jPDatosProducto.add(JTFCodigoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 260, -1));

        JBEditar.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });
        jPDatosProducto.add(JBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 70, -1));

        JBOk.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        JBOk.setText("Ok");
        JBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBOkActionPerformed(evt);
            }
        });
        jPDatosProducto.add(JBOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 60, -1));

        JBEliminar.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });
        jPDatosProducto.add(JBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 140, -1));

        jLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPDatosProducto.add(jLFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 340, 300));

        jBEligirImagen.setText("Elegir Imagen");
        jBEligirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEligirImagenActionPerformed(evt);
            }
        });
        jPDatosProducto.add(jBEligirImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, -1, -1));

        JTADescripcion.setColumns(20);
        JTADescripcion.setLineWrap(true);
        JTADescripcion.setRows(5);
        jScrollPane2.setViewportView(JTADescripcion);

        jPDatosProducto.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        JBVaciarFormulario.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        JBVaciarFormulario.setText("Vaciar Formulario");
        JBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVaciarFormularioActionPerformed(evt);
            }
        });
        jPDatosProducto.add(JBVaciarFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 140, -1));

        jLabel9.setText("Ex: 15.89");
        jPDatosProducto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("$");
        jPDatosProducto.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 10, 30));

        add(jPDatosProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1100, 340));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Productos"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTProductos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Descripción", "Precio", "Código Barra", "Foto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTProductos);
        if (jTProductos.getColumnModel().getColumnCount() > 0) {
            jTProductos.getColumnModel().getColumn(0).setMaxWidth(70);
            jTProductos.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1070, 290));

        jTFBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBuscarNombreKeyPressed(evt);
            }
        });
        jPanel2.add(jTFBuscarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 190, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Producto:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Código Barras:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 110, 20));

        jTFBuscarCodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarCodigoBarrasKeyReleased(evt);
            }
        });
        jPanel2.add(jTFBuscarCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 200, -1));

        JBLimpiar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        JBLimpiar.setText("Limpiar");
        JBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(JBLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 140, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 1100, 400));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel8.setText("PRODUCTOS");
        jPanel1.add(jLabel8, new java.awt.GridBagConstraints());

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1100, 40));
    }// </editor-fold>//GEN-END:initComponents

    
    private void jBGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarProductoActionPerformed
        try {
            // TODO add your handling code here:
            guardarProducto();
        } catch (IOException ex) {
            Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBGuardarProductoActionPerformed

    private void JBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBListarActionPerformed
        // TODO add your handling code here:
        loadProductos();
    }//GEN-LAST:event_JBListarActionPerformed

    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed
        seleccionarItemTabla();
    }//GEN-LAST:event_JBEditarActionPerformed

    private void JBOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBOkActionPerformed
        try {       
            actualizarProducto();
        } catch (IOException ex) {
            Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBOkActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        eliminarProducto();        
    }//GEN-LAST:event_JBEliminarActionPerformed

    public void vaciarFormulario(){
        JTFNombre.setText("");
        JTADescripcion.setText("");
        JTFPrecio.setText("");
        JTFCodigoBarra.setText("");
        jLFoto.setIcon(null);
    }
    
    private void jBEligirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEligirImagenActionPerformed
        // TODO add your handling code here:
        fc = new JFileChooser();
        fc.setDialogTitle("Elegir foto o imagen de producto");
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            file = fc.getSelectedFile();
            try {
                String nombreImg = file.getName();
                System.out.println(nombreImg);
                if (nombreImg.endsWith(".jpg")
                        || nombreImg.endsWith(".png")
                        || nombreImg.endsWith(".bmp")
                        || nombreImg.endsWith(".jpeg")) {
                    UUID uuid = UUID.randomUUID();
                    String codigoImagen = uuid.toString();
                    dest = new File(System.getProperty("user.dir") + "/media/producto/" + codigoImagen);
                    //this.imagen= (dest.getName());
                    loadImageSrc(file.getAbsolutePath());

            }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error abriendo fichero");
            }
        }
                
    }//GEN-LAST:event_jBEligirImagenActionPerformed

    private void JBVaciarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVaciarFormularioActionPerformed
        vaciarFormulario();
    }//GEN-LAST:event_JBVaciarFormularioActionPerformed

    private void JBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarActionPerformed
        // TODO add your handling code here:
        vaciarCamposBusqueda();
        loadProductos();
    }//GEN-LAST:event_JBLimpiarActionPerformed

    public void vaciarCamposBusqueda(){
        jTFBuscarCodigoBarras.setText("");
        jTFBuscarNombre.setText("");
    }
    
    private void jTFBuscarNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarNombreKeyPressed
        // TODO add your handling code here:
        String buscarNombre = jTFBuscarNombre.getText();
        loadProductosPorNombre(buscarNombre);
    }//GEN-LAST:event_jTFBuscarNombreKeyPressed

    private void jTFBuscarCodigoBarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarCodigoBarrasKeyReleased
        // TODO add your handling code here:
        String codigoBarra = jTFBuscarCodigoBarras.getText();
        loadProductosPorCodigoBarra(codigoBarra);
    }//GEN-LAST:event_jTFBuscarCodigoBarrasKeyReleased
  
    private void loadImageGuardada(String name) {

        try {
            String string = System.getProperty("user.dir") + "/media/producto/" + name;
            
            Image img = new ImageIcon(string).getImage();
            
            //Me permite redimensionar la imagen para que se adapte al jLabel
            ImageIcon ii = new ImageIcon(img.getScaledInstance(340, 300, Image.SCALE_SMOOTH));

            jLFoto.setIcon(ii);
            jLFoto.validate();
            jLFoto.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadImageSrc(String name) {

        try {
            String string = name;
            
            Image img = new ImageIcon(string).getImage();
            
            //Me permite redimensionar la imagen para que se adapte al jLabel
            ImageIcon ii = new ImageIcon(img.getScaledInstance(340, 300, Image.SCALE_SMOOTH));

            jLFoto.setIcon(ii);
            jLFoto.validate();
            jLFoto.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        }
        catch (Exception e) {
        }
        
    }
    
    public void guardarProducto() throws IOException{
        prodBuss = new ProductoBuss();
        producto = new Producto();
        producto.setNombre(JTFNombre.getText());
        producto.setDescripcion(JTADescripcion.getText());
        producto.setPrecio(Double.parseDouble(JTFPrecio.getText()));
        producto.setCodigoBarra(JTFCodigoBarra.getText());
        producto.setFoto(dest.getName());
        boolean estadoGuardado = prodBuss.guardar(producto);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Producto guardado");
            copyFileUsingStream(file, dest);
            loadProductos();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al guardar el producto");
        }
    }
    
    public void actualizarProducto() throws IOException{
        prodBuss = new ProductoBuss();
        producto = new Producto();
        producto.setId(Integer.parseInt(jLID.getText()));
        producto.setNombre(JTFNombre.getText());
        producto.setDescripcion(JTADescripcion.getText());
        producto.setPrecio(Double.parseDouble(JTFPrecio.getText()));
        producto.setCodigoBarra(JTFCodigoBarra.getText());
        producto.setFoto(dest.getName());
        boolean estadoActualizacion = prodBuss.actualizar(producto);
        if(estadoActualizacion){
            JOptionPane.showMessageDialog(this, "Producto actualizado");
            copyFileUsingStream(file, dest);
            loadProductos();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar el producto");
        }
    }
    
    public void eliminarProducto(){
        prodBuss = new ProductoBuss();
        int fila = jTProductos.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTProductos.getValueAt(fila, 0).toString());
            String nombre = (String)jTProductos.getValueAt(fila, 1);        
            int estadoEliminacionDialog = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar "+nombre+"?","Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(estadoEliminacionDialog == 0){
                boolean estadoEliminacion = prodBuss.eliminar(id);
                if(estadoEliminacion){
                    JOptionPane.showMessageDialog(this, "Producto eliminado");
                    loadProductos();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al eliminar el producto");
                }
            }
        }
    }
    
    public void seleccionarItemTabla(){
        int fila = jTProductos.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTProductos.getValueAt(fila, 0).toString());
            String nombre = (String) jTProductos.getValueAt(fila, 1);
            String descripcion = (String) jTProductos.getValueAt(fila, 2);
            Double precio = Double.parseDouble((String) jTProductos.getValueAt(fila, 3).toString());
            String codigoBarra = (String) jTProductos.getValueAt(fila, 4);
            String foto = (String) jTProductos.getValueAt(fila, 5);
            jLID.setText(""+id);
            JTFNombre.setText(nombre);
            JTADescripcion.setText(descripcion);
            JTFPrecio.setText(String.valueOf(precio));
            JTFCodigoBarra.setText(codigoBarra);
            dest = new File(System.getProperty("user.dir") + "/media/producto/" + foto);
            loadImageGuardada(foto);
        }
    }
    
    public void vaciarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTProductos.getModel();
        modelo.setRowCount(0);
        jTProductos.setModel(modelo);
    }
    
    public void loadProductos(){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTProductos.getModel();
        List<Producto> productos = prodBuss.getProductos();
        Object rowData[] = new Object[6];
        for(Producto p: productos){
            rowData[0] = p.getId();
            rowData[1] = p.getNombre();
            rowData[2] = p.getDescripcion();
            rowData[3] = p.getPrecio();
            rowData[4] = p.getCodigoBarra();
            rowData[5] = p.getFoto();
            modelo.addRow(rowData);
        }
        jTProductos.setModel(modelo);
    }
    
    public void loadProductosPorNombre(String nombre){
        vaciarTabla();
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTProductos.getModel();
            List<Producto> productos = prodBuss.buscarProductosPorNombre(nombre);
            Object rowData[] = new Object[6];
            for(Producto p: productos){
                rowData[0] = p.getId();
                rowData[1] = p.getNombre();
                rowData[2] = p.getDescripcion();
                rowData[3] = p.getPrecio();
                rowData[4] = p.getCodigoBarra();
                rowData[5] = p.getFoto();
                modelo.addRow(rowData);
            }
            jTProductos.setModel(modelo);
        } catch (Exception e) {
        }  
    }
    
    public void loadProductosPorCodigoBarra(String codigoBarra){
        vaciarTabla();
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTProductos.getModel();
            List<Producto> productos = prodBuss.buscarProductosPorCodigoBarras(codigoBarra);
            Object rowData[] = new Object[6];
            for(Producto p: productos){
                rowData[0] = p.getId();
                rowData[1] = p.getNombre();
                rowData[2] = p.getDescripcion();
                rowData[3] = p.getPrecio();
                rowData[4] = p.getCodigoBarra();
                rowData[5] = p.getFoto();
                modelo.addRow(rowData);
            }
            jTProductos.setModel(modelo);
        } catch (Exception e) {
        }  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBLimpiar;
    private javax.swing.JButton JBListar;
    private javax.swing.JButton JBOk;
    private javax.swing.JButton JBVaciarFormulario;
    private javax.swing.JTextArea JTADescripcion;
    private javax.swing.JTextField JTFCodigoBarra;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JTextField JTFPrecio;
    private javax.swing.JButton jBEligirImagen;
    private javax.swing.JButton jBGuardarProducto;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPDatosProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFBuscarCodigoBarras;
    private javax.swing.JTextField jTFBuscarNombre;
    private javax.swing.JTable jTProductos;
    // End of variables declaration//GEN-END:variables
}
