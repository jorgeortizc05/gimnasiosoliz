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

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
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
        JPListaTipoPersonas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaTipoPersonas = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("Tipo de Persona");
        jPanel2.add(jLabel8, new java.awt.GridBagConstraints());

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 850, 40));

        jPDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("ID:");
        jPDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 37, -1, -1));

        jLID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPDatos.add(jLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 91, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Comprobante:");
        jPDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 79, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Descripcion:");
        jPDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 125, -1, -1));

        jTFNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPDatos.add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 210, -1));

        jTADescripcion.setColumns(20);
        jTADescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTADescripcion.setLineWrap(true);
        jTADescripcion.setRows(5);
        jScrollPane1.setViewportView(jTADescripcion);

        jPDatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 210, -1));

        jBGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPDatos.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 150, -1));

        JBListar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JBListar.setText("Listar");
        JBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListarActionPerformed(evt);
            }
        });
        jPDatos.add(JBListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 150, -1));

        JBEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });
        jPDatos.add(JBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 80, -1));

        JBOk.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JBOk.setText("Ok");
        JBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBOkActionPerformed(evt);
            }
        });
        jPDatos.add(JBOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 70, -1));

        JBEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });
        jPDatos.add(JBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 150, -1));

        JBVaciarFormulario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JBVaciarFormulario.setText("Vaciar Formulario");
        JBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVaciarFormularioActionPerformed(evt);
            }
        });
        jPDatos.add(JBVaciarFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        add(jPDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 850, 280));

        JPListaTipoPersonas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Tipo de Personas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        JPListaTipoPersonas.setLayout(new java.awt.GridLayout(1, 0));

        jTListaTipoPersonas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        jScrollPane2.setViewportView(jTListaTipoPersonas);

        JPListaTipoPersonas.add(jScrollPane2);

        add(JPListaTipoPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 850, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void JBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBListarActionPerformed
        // TODO add your handling code here:
        loadTipoPersonas();
    }//GEN-LAST:event_JBListarActionPerformed

    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed
        jBGuardar.setVisible(false);
        seleccionarItemTabla();
    }//GEN-LAST:event_JBEditarActionPerformed

    private void JBOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBOkActionPerformed
        actualizar();
        jBGuardar.setVisible(true);
    }//GEN-LAST:event_JBOkActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
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
    private javax.swing.JPanel JPListaTipoPersonas;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPDatos;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTListaTipoPersonas;
    // End of variables declaration//GEN-END:variables
}
