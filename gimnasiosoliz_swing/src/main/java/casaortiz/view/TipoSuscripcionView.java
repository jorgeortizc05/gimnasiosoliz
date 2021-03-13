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

        jPDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescripcion = new javax.swing.JTextArea();
        jBGuardar = new javax.swing.JButton();
        JBListar = new javax.swing.JButton();
        JBEditar = new javax.swing.JButton();
        JBOk = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        JBVaciarFormulario = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JTFPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSNumeroDias = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        JPListaTipoSuscripciones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaTipoSuscripciones = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        java.awt.GridBagLayout jPDatosLayout = new java.awt.GridBagLayout();
        jPDatosLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPDatosLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPDatos.setLayout(jPDatosLayout);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLabel1, gridBagConstraints);

        jLID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
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

        jTFNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFNombre.setPreferredSize(new java.awt.Dimension(300, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jTFNombre, gridBagConstraints);

        jTADescripcion.setColumns(20);
        jTADescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        jBGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jBGuardar, gridBagConstraints);

        JBListar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JBListar.setText("Listar");
        JBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(JBListar, gridBagConstraints);

        JBEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(JBEditar, gridBagConstraints);

        JBOk.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JBOk.setText("Ok");
        JBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBOkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(JBOk, gridBagConstraints);

        JBEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(JBEliminar, gridBagConstraints);

        JBVaciarFormulario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JBVaciarFormulario.setText("Vaciar Formulario");
        JBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVaciarFormularioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(JBVaciarFormulario, gridBagConstraints);

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

        JTFPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JTFPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JTFPrecio.setInputVerifier(new VerificarSoloNumeros());
        JTFPrecio.setPreferredSize(new java.awt.Dimension(120, 21));
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

        jSNumeroDias.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jSNumeroDias, gridBagConstraints);

        add(jPDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 650, 260));

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("Tipo de Suscripciones");
        jPanel2.add(jLabel8, new java.awt.GridBagConstraints());

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 860, 40));

        JPListaTipoSuscripciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Suscripciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        JPListaTipoSuscripciones.setLayout(new java.awt.GridLayout(1, 0));

        jTListaTipoSuscripciones.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        jScrollPane2.setViewportView(jTListaTipoSuscripciones);
        if (jTListaTipoSuscripciones.getColumnModel().getColumnCount() > 0) {
            jTListaTipoSuscripciones.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTListaTipoSuscripciones.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTListaTipoSuscripciones.getColumnModel().getColumn(4).setPreferredWidth(400);
        }

        JPListaTipoSuscripciones.add(jScrollPane2);

        add(JPListaTipoSuscripciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 850, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void JBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBListarActionPerformed
        // TODO add your handling code here:
        loadTipoSuscripciones();
    }//GEN-LAST:event_JBListarActionPerformed

    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed
        //seleccionarItemTabla();
        jBGuardar.setVisible(false);
        seleccionarItemTabla();
    }//GEN-LAST:event_JBEditarActionPerformed

    private void JBOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBOkActionPerformed
        actualizar();
        jBGuardar.setVisible(true);
    }//GEN-LAST:event_JBOkActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        //eliminarProducto();
        eliminar();
    }//GEN-LAST:event_JBEliminarActionPerformed

    private void JBVaciarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVaciarFormularioActionPerformed
        vaciarFormulario();
        jBGuardar.setVisible(true);
    }//GEN-LAST:event_JBVaciarFormularioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBListar;
    private javax.swing.JButton JBOk;
    private javax.swing.JButton JBVaciarFormulario;
    private javax.swing.JPanel JPListaTipoSuscripciones;
    private javax.swing.JTextField JTFPrecio;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPDatos;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSNumeroDias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTListaTipoSuscripciones;
    // End of variables declaration//GEN-END:variables
}
