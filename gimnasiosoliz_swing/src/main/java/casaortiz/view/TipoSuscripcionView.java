/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.TipoSuscripcionBuss;
import casaortiz.model.TipoSuscripcion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class TipoSuscripcionView extends javax.swing.JPanel {

    private TipoSuscripcionBuss tsBuss;
    private TipoSuscripcion tipoSuscripcion;
    
    public TipoSuscripcionView() {
        initComponents();
        tsBuss = new TipoSuscripcionBuss();
        loadTipoSuscripciones();
    }
    
    public void guardar(){
        tipoSuscripcion = new TipoSuscripcion();
        tipoSuscripcion.setNombre(jTFNombre.getText());
        tipoSuscripcion.setPrecio(Double.parseDouble(JTFPrecio.getText()));
        tipoSuscripcion.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = tsBuss.guardar(tipoSuscripcion);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Tipo de Suscripcion guardado");
            loadTipoSuscripciones();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al guardar el Tipo de Suscripcion");
        }
    }
    
    public void actualizar(){
        tipoSuscripcion = new TipoSuscripcion();
        tipoSuscripcion.setId(Integer.parseInt(jLID.getText()));
        tipoSuscripcion.setNombre(jTFNombre.getText());
        tipoSuscripcion.setNumeroDias((int) jSNumeroDias.getValue());
        tipoSuscripcion.setPrecio(Double.parseDouble(JTFPrecio.getText()));
        tipoSuscripcion.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = tsBuss.actualizar(tipoSuscripcion);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Tipo de Suscripcion actualizado");
            loadTipoSuscripciones();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar el Tipo de Suscripcion");
        }
    }
    
    public void eliminar(){
        int fila = jTListaTipoSuscripciones.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaTipoSuscripciones.getValueAt(fila, 0).toString());
            String nombre = (String)jTListaTipoSuscripciones.getValueAt(fila, 1);        
            int estadoEliminacionDialog = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar "+nombre+"?","Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(estadoEliminacionDialog == 0){
                boolean estadoEliminacion = tsBuss.eliminar(id);
                if(estadoEliminacion){
                    JOptionPane.showMessageDialog(this, "Tipo de Suscripcion eliminado");
                    loadTipoSuscripciones();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al eliminar el Tipo de Suscripcion");
                }
            }
        }
    }
    
    public void seleccionarItemTabla(){
        int fila = jTListaTipoSuscripciones.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaTipoSuscripciones.getValueAt(fila, 0).toString());
            TipoSuscripcion item = tsBuss.getTipoSuscripcion(id);
            jLID.setText(""+item.getId());
            jTFNombre.setText(item.getNombre());
            jSNumeroDias.setValue(item.getNumeroDias());
            JTFPrecio.setText(String.valueOf(item.getPrecio()));
            jTADescripcion.setText(item.getDescripcion());
        }
    }
    
    public void vaciarFormulario(){
        jLID.setText("");
        jTFNombre.setText("");
        jSNumeroDias.setValue(0);
        JTFPrecio.setText("");
        jTADescripcion.setText("");
    }
    
    public void vaciarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTListaTipoSuscripciones.getModel();
        modelo.setRowCount(0);
        jTListaTipoSuscripciones.setModel(modelo);
    }
    
    public void loadTipoSuscripciones(){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTListaTipoSuscripciones.getModel();
        List<TipoSuscripcion> items = tsBuss.getTipoSuscripciones();
        Object rowData[] = new Object[5];
        for(TipoSuscripcion ts: items){
            rowData[0] = ts.getId();
            rowData[1] = ts.getNombre();
            rowData[2] = ts.getNumeroDias();
            rowData[3] = ts.getPrecio();
            rowData[4] = ts.getDescripcion();
            modelo.addRow(rowData);
        }
        jTListaTipoSuscripciones.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JTFPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSNumeroDias = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jBGuardar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        JBVaciarFormulario = new javax.swing.JButton();
        JPListaTipoSuscripciones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaTipoSuscripciones = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0};
        jPanel1.setLayout(jPanel1Layout);

        jPDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos Tipo de Suscripciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        java.awt.GridBagLayout jPDatosLayout = new java.awt.GridBagLayout();
        jPDatosLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPDatosLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPDatos.setLayout(jPDatosLayout);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLabel1, gridBagConstraints);

        jLID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLID.setPreferredSize(new java.awt.Dimension(0, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLID, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Tipo Suscripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLabel4, gridBagConstraints);

        jTFNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFNombre.setPreferredSize(new java.awt.Dimension(300, 29));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jTFNombre, gridBagConstraints);

        jTADescripcion.setColumns(20);
        jTADescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTADescripcion.setLineWrap(true);
        jTADescripcion.setRows(5);
        jScrollPane1.setViewportView(jTADescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jScrollPane1, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Precio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLabel5, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Ex: 15.89");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLabel10, gridBagConstraints);

        JTFPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JTFPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTFPrecio.setInputVerifier(new VerificarSoloNumeros());
        JTFPrecio.setPreferredSize(new java.awt.Dimension(120, 29));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(JTFPrecio, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("No. de Días:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLabel6, gridBagConstraints);

        jSNumeroDias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jSNumeroDias, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridLayout(1, 4));

        jBGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(jBGuardar);

        jBActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jBActualizar);

        JBEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(JBEliminar);

        JBVaciarFormulario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JBVaciarFormulario.setText("Vaciar Formulario");
        JBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVaciarFormularioActionPerformed(evt);
            }
        });
        jPanel2.add(JBVaciarFormulario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jPDatos, gridBagConstraints);

        JPListaTipoSuscripciones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista Tipos de Suscripciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        JPListaTipoSuscripciones.setPreferredSize(new java.awt.Dimension(600, 427));
        JPListaTipoSuscripciones.setLayout(new java.awt.CardLayout());

        jTListaTipoSuscripciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTListaTipoSuscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Numero Días", "Precio", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTListaTipoSuscripciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListaTipoSuscripcionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTListaTipoSuscripciones);
        if (jTListaTipoSuscripciones.getColumnModel().getColumnCount() > 0) {
            jTListaTipoSuscripciones.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTListaTipoSuscripciones.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTListaTipoSuscripciones.getColumnModel().getColumn(4).setPreferredWidth(400);
        }

        JPListaTipoSuscripciones.add(jScrollPane2, "card2");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(JPListaTipoSuscripciones, gridBagConstraints);

        jScrollPane3.setViewportView(jPanel1);

        add(jScrollPane3, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        actualizar();
        jBGuardar.setVisible(true);
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        //eliminarProducto();
        eliminar();
    }//GEN-LAST:event_JBEliminarActionPerformed

    private void JBVaciarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVaciarFormularioActionPerformed
        vaciarFormulario();
        loadTipoSuscripciones();
        jBGuardar.setVisible(true);
    }//GEN-LAST:event_JBVaciarFormularioActionPerformed

    private void jTListaTipoSuscripcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListaTipoSuscripcionesMouseClicked
        // TODO add your handling code here:
        jBGuardar.setVisible(false);
        seleccionarItemTabla();
    }//GEN-LAST:event_jTListaTipoSuscripcionesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBVaciarFormulario;
    private javax.swing.JPanel JPListaTipoSuscripciones;
    private javax.swing.JTextField JTFPrecio;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPDatos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSNumeroDias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTListaTipoSuscripciones;
    // End of variables declaration//GEN-END:variables
}
