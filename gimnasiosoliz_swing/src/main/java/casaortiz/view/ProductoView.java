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

    public void guardar() throws IOException{
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
    
    public void actualizar() throws IOException{
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
    
    public void eliminar(){
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
    
    public void vaciarFormulario(){
        jLID.setText("");
        JTFNombre.setText("");
        JTADescripcion.setText("");
        JTFPrecio.setText("");
        JTFCodigoBarra.setText("");
        jLFoto.setIcon(null);
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
    
    public void vaciarCamposBusqueda(){
        jTFBuscarCodigoBarras.setText("");
        jTFBuscarNombre.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTFNombre = new javax.swing.JTextField();
        JTFPrecio = new javax.swing.JTextField();
        JTFCodigoBarra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        jLFoto = new javax.swing.JLabel();
        jBEligirImagen = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBListar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBVaciarFormulario = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBOk = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFBuscarCodigoBarras = new javax.swing.JTextField();
        jTFBuscarNombre = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTProductos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTADescripcion = new javax.swing.JTextArea();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(null), "Datos de Productos"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 31, -1, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setText("Descripción:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel4.setText("Precio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel5.setText("Código de Barras:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        jPanel1.add(JTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 290, -1));

        JTFPrecio.setInputVerifier(new VerificarSoloNumeros());
        jPanel1.add(JTFPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 93, -1));
        jPanel1.add(JTFCodigoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 290, -1));

        jLabel6.setText("$");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        jLabel7.setText("Ex. 15.89");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));
        jPanel1.add(jLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 31, 129, 17));

        jLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        jPanel1.add(jLFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 400, 300));

        jBEligirImagen.setText("Elegir Imágen");
        jBEligirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEligirImagenActionPerformed(evt);
            }
        });
        jPanel1.add(jBEligirImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 340, -1, -1));

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 150, -1));

        jBListar.setText("Listar");
        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarActionPerformed(evt);
            }
        });
        jPanel1.add(jBListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 150, -1));

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 150, -1));

        jBVaciarFormulario.setText("Vaciar Formulario");
        jBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVaciarFormularioActionPerformed(evt);
            }
        });
        jPanel1.add(jBVaciarFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 150, -1));

        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });
        jPanel1.add(jBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 81, -1));

        jBOk.setText("Ok");
        jBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOkActionPerformed(evt);
            }
        });
        jPanel1.add(jBOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 60, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(null), "Lista de Productos"));

        jLabel10.setText("Producto:");

        jLabel11.setText("Código Barra:");

        jTFBuscarCodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarCodigoBarrasKeyReleased(evt);
            }
        });

        jTFBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBuscarNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarNombreKeyReleased(evt);
            }
        });

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jTProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Descripción", "Precio", "Cód. Barra", "Foto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFBuscarCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 958, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jTFBuscarCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1760, 660));

        JTADescripcion.setColumns(20);
        JTADescripcion.setRows(5);
        jScrollPane3.setViewportView(JTADescripcion);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 290, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            guardar();
        } catch (IOException ex) {
            Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarActionPerformed
        // TODO add your handling code here:
        loadProductos();
    }//GEN-LAST:event_jBListarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // TODO add your handling code here:
        jBGuardar.setVisible(false);
        seleccionarItemTabla();
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOkActionPerformed
        // TODO add your handling code here:
        try {       
            actualizar();
            jBGuardar.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBOkActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jBEliminarActionPerformed

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

    private void jBVaciarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVaciarFormularioActionPerformed
        // TODO add your handling code here:
        vaciarFormulario();
        jBGuardar.setVisible(true);
    }//GEN-LAST:event_jBVaciarFormularioActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        vaciarCamposBusqueda();
        loadProductos();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTFBuscarNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarNombreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBuscarNombreKeyPressed

    private void jTFBuscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarNombreKeyReleased
        // TODO add your handling code here:
        String buscarNombre = jTFBuscarNombre.getText();
        loadProductosPorNombre(buscarNombre);
    }//GEN-LAST:event_jTFBuscarNombreKeyReleased

    private void jTFBuscarCodigoBarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarCodigoBarrasKeyReleased
        // TODO add your handling code here:
        String codigoBarra = jTFBuscarCodigoBarras.getText();
        loadProductosPorCodigoBarra(codigoBarra);
    }//GEN-LAST:event_jTFBuscarCodigoBarrasKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTADescripcion;
    private javax.swing.JTextField JTFCodigoBarra;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JTextField JTFPrecio;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBEligirImagen;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBListar;
    private javax.swing.JButton jBOk;
    private javax.swing.JButton jBVaciarFormulario;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFBuscarCodigoBarras;
    private javax.swing.JTextField jTFBuscarNombre;
    private javax.swing.JTable jTProductos;
    // End of variables declaration//GEN-END:variables
}
