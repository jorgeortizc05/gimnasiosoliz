/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.TipoPersonaBuss;
import casaortiz.model.TipoPersona;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class TipoPersonaView extends javax.swing.JPanel {

    private TipoPersonaBuss tpBuss;
    private TipoPersona tipoPersona;
    private List<TipoPersona> tipoPersonas;
    public TipoPersonaView() {
        initComponents();
        tpBuss = new TipoPersonaBuss();
        loadTipoPersonas();
    }

    
    public void guardar(){
        tipoPersona = new TipoPersona();
        tipoPersona.setNombre(jTFNombre.getText());
        tipoPersona.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = tpBuss.guardar(tipoPersona);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Tipo de Persona guardado");
            loadTipoPersonas();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al guardar el Tipo de Persona");
        }
    }
    
    public void actualizar(){
        tipoPersona = new TipoPersona();
        tipoPersona.setId(Integer.parseInt(jLID.getText()));
        tipoPersona.setNombre(jTFNombre.getText());
        tipoPersona.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = tpBuss.actualizar(tipoPersona);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Tipo de Persona actualizado");
            loadTipoPersonas();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar el Tipo de Persona");
        }
    }
    
    public void eliminar(){
        int fila = jTListaTipoPersonas.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaTipoPersonas.getValueAt(fila, 0).toString());
            String nombre = (String)jTListaTipoPersonas.getValueAt(fila, 1);        
            int estadoEliminacionDialog = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar "+nombre+"?","Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(estadoEliminacionDialog == 0){
                boolean estadoEliminacion = tpBuss.eliminar(id);
                if(estadoEliminacion){
                    JOptionPane.showMessageDialog(this, "Tipo de Persona eliminado");
                    loadTipoPersonas();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al eliminar el Tipo de Persona");
                }
            }
        }
    }
    
    public void seleccionarItemTabla(){
        int fila = jTListaTipoPersonas.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaTipoPersonas.getValueAt(fila, 0).toString());
            tipoPersona = tpBuss.getTipoPersona(id);
            jLID.setText(""+tipoPersona.getId());
            jTFNombre.setText(tipoPersona.getNombre());
            jTADescripcion.setText(tipoPersona.getDescripcion());
        }
    }
    
    public void vaciarFormulario(){
        jLID.setText("");
        jTFNombre.setText("");
        jTADescripcion.setText("");
    }
    
    public void vaciarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTListaTipoPersonas.getModel();
        modelo.setRowCount(0);
        jTListaTipoPersonas.setModel(modelo);
    }
    
    public void loadTipoPersonas(){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTListaTipoPersonas.getModel();
        tipoPersonas = tpBuss.getTipoPersonas();
        Object rowData[] = new Object[3];
        for(TipoPersona tp: tipoPersonas){
            rowData[0] = tp.getId();
            rowData[1] = tp.getNombre();
            rowData[2] = tp.getDescripcion();
            modelo.addRow(rowData);
        }
        jTListaTipoPersonas.setModel(modelo);
    }
    
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
        jPanel1 = new javax.swing.JPanel();
        jBGuardar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        JBVaciarFormulario = new javax.swing.JButton();
        JPListaTipoPersonas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaTipoPersonas = new javax.swing.JTable();

        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0};
        layout.rowHeights = new int[] {0};
        setLayout(layout);

        jPDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos Tipo de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        java.awt.GridBagLayout jPDatosLayout = new java.awt.GridBagLayout();
        jPDatosLayout.columnWidths = new int[] {0, 5, 0, 5, 0};
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

        jLID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLID, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Comprobante:");
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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jLabel4, gridBagConstraints);

        jTFNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jScrollPane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridLayout(1, 4));

        jBGuardar.setBackground(new java.awt.Color(194, 60, 61));
        jBGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBGuardar.setForeground(java.awt.Color.white);
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBGuardar);

        jBActualizar.setBackground(new java.awt.Color(194, 60, 61));
        jBActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBActualizar.setForeground(java.awt.Color.white);
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jBActualizar);

        JBEliminar.setBackground(new java.awt.Color(194, 60, 61));
        JBEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JBEliminar.setForeground(java.awt.Color.white);
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(JBEliminar);

        JBVaciarFormulario.setBackground(new java.awt.Color(194, 60, 61));
        JBVaciarFormulario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JBVaciarFormulario.setForeground(java.awt.Color.white);
        JBVaciarFormulario.setText("Vaciar Formulario");
        JBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVaciarFormularioActionPerformed(evt);
            }
        });
        jPanel1.add(JBVaciarFormulario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPDatos.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(jPDatos, gridBagConstraints);

        JPListaTipoPersonas.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista Tipo de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        JPListaTipoPersonas.setLayout(new java.awt.CardLayout());

        jTListaTipoPersonas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTListaTipoPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTListaTipoPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListaTipoPersonasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTListaTipoPersonas);

        JPListaTipoPersonas.add(jScrollPane2, "card2");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(JPListaTipoPersonas, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        actualizar();
        jBGuardar.setEnabled(true);
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_JBEliminarActionPerformed

    private void JBVaciarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVaciarFormularioActionPerformed
        vaciarFormulario();
        loadTipoPersonas();
        jBGuardar.setEnabled(true);
    }//GEN-LAST:event_JBVaciarFormularioActionPerformed

    private void jTListaTipoPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListaTipoPersonasMouseClicked
        // TODO add your handling code here:
        jBGuardar.setEnabled(false);
        seleccionarItemTabla();
    }//GEN-LAST:event_jTListaTipoPersonasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBVaciarFormulario;
    private javax.swing.JPanel JPListaTipoPersonas;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPDatos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTListaTipoPersonas;
    // End of variables declaration//GEN-END:variables
}
