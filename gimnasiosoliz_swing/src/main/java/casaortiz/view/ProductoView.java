/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.CategoriaBuss;
import casaortiz.buss.ProductoBuss;
import casaortiz.buss.SubCategoriaBuss;
import casaortiz.model.Categoria;
import casaortiz.model.Producto;
import casaortiz.model.SubCategoria;
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
    private SubCategoriaBuss subCategBuss;
    private JFileChooser fc;
    private File file;
    private File dest;
    public ProductoView() {
        initComponents();
        jBActualizar.setEnabled(false);
        prodBuss = new ProductoBuss();
        subCategBuss = new SubCategoriaBuss();
        loadProductos();
        loadSubCategorias();
    }

    public void guardar() throws IOException{
        prodBuss = new ProductoBuss();
        producto = new Producto();
        producto.setNombre(JTFNombre.getText());
        producto.setDescripcion(JTADescripcion.getText());
        producto.setPrecio(Double.parseDouble(JTFPrecio.getText()));
        producto.setCodigoBarra(JTFCodigoBarra.getText());
        producto.setFoto(dest.getName());
        SubCategoria subCategoria = (SubCategoria) jCBSubCategoria.getSelectedItem();
        producto.setSubCategoriaId(subCategoria.getId());
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
        SubCategoria subCategoria = (SubCategoria) jCBSubCategoria.getSelectedItem();
        producto.setSubCategoriaId(subCategoria.getId());
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
            Producto producto = prodBuss.getProducto(id);
            System.out.println(producto);
            jLID.setText(""+id);
            JTFNombre.setText(producto.getNombre());
            JTADescripcion.setText(producto.getDescripcion());
            JTFPrecio.setText(String.valueOf(producto.getPrecio()));
            JTFCodigoBarra.setText(producto.getCodigoBarra());
            SubCategoria subCategoria = subCategBuss.getSubCategoria(producto.getSubCategoriaId());
            jCBSubCategoria.getModel().setSelectedItem(subCategoria);
            dest = new File(System.getProperty("user.dir") + "/media/producto/" + producto.getFoto());
            loadImageGuardada(producto.getFoto());
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
        addDataTablaProducto(modelo, productos);
    }
    
    public void loadProductosPorNombre(String nombre){
        vaciarTabla();
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTProductos.getModel();
            List<Producto> productos = prodBuss.buscarProductosPorNombre(nombre);
            addDataTablaProducto(modelo, productos);
        } catch (Exception e) {
        }  
    }
    
    public void loadProductosPorCodigoBarra(String codigoBarra){
        vaciarTabla();
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTProductos.getModel();
            List<Producto> productos = prodBuss.buscarProductosPorCodigoBarras(codigoBarra);
            addDataTablaProducto(modelo, productos);
        } catch (Exception e) {
        }  
    }
    
    public void addDataTablaProducto(DefaultTableModel modelo, List<Producto> productos){
        Object rowData[] = new Object[6];
            for(Producto p: productos){
                rowData[0] = p.getId();
                rowData[1] = p.getNombre();
                rowData[2] = p.getDescripcion();
                rowData[3] = p.getPrecio();
                rowData[4] = p.getCodigoBarra();
                rowData[5] = p.getFoto();
                SubCategoria subCategoria = subCategBuss.getSubCategoria(p.getSubCategoriaId());
                rowData[5] = subCategoria.getNombre();
                modelo.addRow(rowData);
            }
            jTProductos.setModel(modelo);
    }
    
    public void loadSubCategorias(){
        List<SubCategoria> items = subCategBuss.getSubCategorias();
        for(SubCategoria tp: items){
           jCBSubCategoria.addItem(tp);
        }
    }
    
    private void loadImageGuardada(String name) {

        try {
            String string = System.getProperty("user.dir") + "/media/producto/" + name;
            
            Image img = new ImageIcon(string).getImage();
            
            //Me permite redimensionar la imagen para que se adapte al jLabel
            ImageIcon ii = new ImageIcon(img.getScaledInstance(400, 300, Image.SCALE_SMOOTH));

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
            ImageIcon ii = new ImageIcon(img.getScaledInstance(400, 300, Image.SCALE_SMOOTH));

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
    
    public void elegirImagenProducto(){
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
    }
    
    public void newProducto(){
        jCBSubCategoria.removeAllItems();
        loadSubCategorias();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLFoto = new javax.swing.JLabel();
        jBEligirImagen = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFBuscarCodigoBarras = new javax.swing.JTextField();
        jTFBuscarNombre = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        JTADescripcion = new javax.swing.JTextArea();
        jCBSubCategoria = new javax.swing.JComboBox<SubCategoria>();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jBGuardar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBVaciarFormulario = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1280, 728));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jLFoto.setPreferredSize(new java.awt.Dimension(400, 300));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLFoto, gridBagConstraints);

        jBEligirImagen.setBackground(new java.awt.Color(194, 60, 61));
        jBEligirImagen.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBEligirImagen.setForeground(java.awt.Color.white);
        jBEligirImagen.setText("Elegir Imagen");
        jBEligirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEligirImagenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jBEligirImagen, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista de Productos"));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel2Layout.rowHeights = new int[] {0, 5, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Producto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel10, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Código Barra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel11, gridBagConstraints);

        jTFBuscarCodigoBarras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFBuscarCodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarCodigoBarrasKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jTFBuscarCodigoBarras, gridBagConstraints);

        jTFBuscarNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBuscarNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarNombreKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jTFBuscarNombre, gridBagConstraints);

        jBLimpiar.setBackground(new java.awt.Color(194, 60, 61));
        jBLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBLimpiar.setForeground(java.awt.Color.white);
        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jBLimpiar, gridBagConstraints);

        jTProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Descripción", "Precio", "Cód. Barra", "Categoría"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTProductos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Precio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Código de Barras:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel5, gridBagConstraints);

        JTFNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(JTFNombre, gridBagConstraints);

        JTFPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JTFPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTFPrecio.setInputVerifier(new VerificarSoloNumeros());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(JTFPrecio, gridBagConstraints);

        JTFCodigoBarra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(JTFCodigoBarra, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Ex. 15.89");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel7, gridBagConstraints);

        jLID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLID.setPreferredSize(new java.awt.Dimension(100, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLID, gridBagConstraints);

        JTADescripcion.setColumns(20);
        JTADescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JTADescripcion.setRows(5);
        jScrollPane3.setViewportView(JTADescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jScrollPane3, gridBagConstraints);

        jCBSubCategoria.setBackground(new java.awt.Color(194, 60, 61));
        jCBSubCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCBSubCategoria.setForeground(java.awt.Color.white);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(jCBSubCategoria, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Categoría:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        jPanel3.add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridLayout(1, 4));

        jBGuardar.setBackground(new java.awt.Color(194, 60, 61));
        jBGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBGuardar.setForeground(java.awt.Color.white);
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(jBGuardar);

        jBActualizar.setBackground(new java.awt.Color(194, 60, 61));
        jBActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBActualizar.setForeground(java.awt.Color.white);
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });
        jPanel5.add(jBActualizar);

        jBEliminar.setBackground(new java.awt.Color(194, 60, 61));
        jBEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBEliminar.setForeground(java.awt.Color.white);
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(jBEliminar);

        jBVaciarFormulario.setBackground(new java.awt.Color(194, 60, 61));
        jBVaciarFormulario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBVaciarFormulario.setForeground(java.awt.Color.white);
        jBVaciarFormulario.setText("Vaciar Formulario");
        jBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVaciarFormularioActionPerformed(evt);
            }
        });
        jPanel5.add(jBVaciarFormulario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jPanel5, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, "card2");
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

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        // TODO add your handling code here:
        try {       
            actualizar();
            jBGuardar.setEnabled(true);
            jBActualizar.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBEligirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEligirImagenActionPerformed
        // TODO add your handling code here:
        elegirImagenProducto();
    }//GEN-LAST:event_jBEligirImagenActionPerformed

    private void jBVaciarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVaciarFormularioActionPerformed
        // TODO add your handling code here:
        vaciarFormulario();
        loadProductos();
        loadSubCategorias();
        jBGuardar.setEnabled(true);
        jBActualizar.setEnabled(false);
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

    private void jTProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProductosMouseClicked
        // TODO add your handling code here:
        jBGuardar.setEnabled(false);
        jBActualizar.setEnabled(true);
        seleccionarItemTabla();
    }//GEN-LAST:event_jTProductosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTADescripcion;
    private javax.swing.JTextField JTFCodigoBarra;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JTextField JTFPrecio;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBEligirImagen;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBVaciarFormulario;
    private javax.swing.JComboBox<SubCategoria> jCBSubCategoria;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFBuscarCodigoBarras;
    private javax.swing.JTextField jTFBuscarNombre;
    private javax.swing.JTable jTProductos;
    // End of variables declaration//GEN-END:variables
}
