/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.FormaPagoBuss;
import casaortiz.model.FormaPago;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class FormaPagoView extends javax.swing.JPanel {

    private FormaPago formaPago;
    private FormaPagoBuss fpBuss;
    
    public FormaPagoView() {
        initComponents();
        fpBuss = new FormaPagoBuss();
        loadFormaPagos();
    }
    
    public void guardar(){
        formaPago = new FormaPago();
        formaPago.setNombre(jTFNombre.getText());
        formaPago.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = fpBuss.guardar(formaPago);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Forma de Pago guardado");
            loadFormaPagos();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al guardar la Forma de Pago");
        }
    }
    
    public void actualizar(){
        formaPago = new FormaPago();
        formaPago.setId(Integer.parseInt(jLID.getText()));
        formaPago.setNombre(jTFNombre.getText());
        formaPago.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = fpBuss.actualizar(formaPago);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Forma de Pago actualizado");
            loadFormaPagos();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar la Forma de Pago");
        }
    }
    
    public void eliminar(){
        int fila = jTListaFormaPagos.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaFormaPagos.getValueAt(fila, 0).toString());
            String nombre = (String)jTListaFormaPagos.getValueAt(fila, 1);        
            int estadoEliminacionDialog = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar "+nombre+"?","Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(estadoEliminacionDialog == 0){
                boolean estadoEliminacion = fpBuss.eliminar(id);
                if(estadoEliminacion){
                    JOptionPane.showMessageDialog(this, "Cantón eliminado");
                    loadFormaPagos();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al eliminar el cantón");
                }
            }
        }
    }
    
    public void seleccionarItemTabla(){
        int fila = jTListaFormaPagos.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaFormaPagos.getValueAt(fila, 0).toString());
            FormaPago item = fpBuss.getFormaPago(id);
            jLID.setText(""+item.getId());
            jTFNombre.setText(item.getNombre());
            jTADescripcion.setText(item.getDescripcion());
        }
    }
    
    public void vaciarFormulario(){
        jLID.setText("");
        jTFNombre.setText("");
        jTADescripcion.setText("");
    }
    
    public void vaciarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTListaFormaPagos.getModel();
        modelo.setRowCount(0);
        jTListaFormaPagos.setModel(modelo);
    }
    
    public void loadFormaPagos(){
        
        vaciarTabla();
        
        DefaultTableModel modelo = (DefaultTableModel) jTListaFormaPagos.getModel();
        
        List<FormaPago> items = fpBuss.getFormaPagos();
        Object rowData[] = new Object[3];
        for(FormaPago fp: items){
            rowData[0] = fp.getId();
            rowData[1] = fp.getNombre();
            rowData[2] = fp.getDescripcion();
            modelo.addRow(rowData);
        }
        jTListaFormaPagos.setModel(modelo);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
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
        JPListaFormaPagos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaFormaPagos = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Forma de Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID:");
        jPDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPDatos.add(jLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 91, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Forma de Pago:");
        jPDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descripcion:");
        jPDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        jPDatos.add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 210, -1));

        jTADescripcion.setColumns(20);
        jTADescripcion.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTADescripcion.setLineWrap(true);
        jTADescripcion.setRows(5);
        jScrollPane1.setViewportView(jTADescripcion);

        jPDatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 210, -1));

        jBGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPDatos.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 150, -1));

        JBListar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JBListar.setText("Listar");
        JBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListarActionPerformed(evt);
            }
        });
        jPDatos.add(JBListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 150, -1));

        JBEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });
        jPDatos.add(JBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 80, -1));

        JBOk.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JBOk.setText("Ok");
        JBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBOkActionPerformed(evt);
            }
        });
        jPDatos.add(JBOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 70, -1));

        JBEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });
        jPDatos.add(JBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 150, -1));

        JBVaciarFormulario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JBVaciarFormulario.setText("Vaciar Formulario");
        JBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVaciarFormularioActionPerformed(evt);
            }
        });
        jPDatos.add(JBVaciarFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 150, -1));

        JPListaFormaPagos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Formas de Pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        JPListaFormaPagos.setLayout(new java.awt.GridLayout(1, 0));

        jTListaFormaPagos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTListaFormaPagos);

        JPListaFormaPagos.add(jScrollPane2);

        jPDatos.add(JPListaFormaPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 920, 400));

        jScrollPane3.setViewportView(jPDatos);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1280, 768));
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void JBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBListarActionPerformed
        // TODO add your handling code here:
        loadFormaPagos();
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
    private javax.swing.JPanel JPListaFormaPagos;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTListaFormaPagos;
    // End of variables declaration//GEN-END:variables
}
