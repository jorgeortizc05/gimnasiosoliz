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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTADescripcion = new javax.swing.JTextArea();
        jBVaciarFormulario = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBListar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBOk = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTListaFormaPagos = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos de Forma de Pago"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 29, -1, -1));

        jLabel2.setText("Forma de Pago:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setText("Descripción:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel1.add(jLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, 20));
        jPanel1.add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 220, -1));

        jTADescripcion.setColumns(20);
        jTADescripcion.setRows(5);
        jScrollPane2.setViewportView(jTADescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jBVaciarFormulario.setText("Vaciar Formulario");
        jBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVaciarFormularioActionPerformed(evt);
            }
        });
        jPanel1.add(jBVaciarFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 160, -1));

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 160, -1));

        jBListar.setText("Listar");
        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarActionPerformed(evt);
            }
        });
        jPanel1.add(jBListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 160, -1));

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 160, -1));

        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });
        jPanel1.add(jBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 90, -1));

        jBOk.setText("Ok");
        jBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOkActionPerformed(evt);
            }
        });
        jPanel1.add(jBOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 70, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista Forma de Pagos"));

        jTListaFormaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTListaFormaPagos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1240, 560));

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
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarActionPerformed
        // TODO add your handling code here:
        loadFormaPagos();
    }//GEN-LAST:event_jBListarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // TODO add your handling code here:
        jBGuardar.setVisible(false);
        seleccionarItemTabla();
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOkActionPerformed
        // TODO add your handling code here:
        actualizar();
        jBGuardar.setVisible(true);
    }//GEN-LAST:event_jBOkActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBVaciarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVaciarFormularioActionPerformed
        // TODO add your handling code here:
        vaciarFormulario();
        jBGuardar.setVisible(true);
    }//GEN-LAST:event_jBVaciarFormularioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBListar;
    private javax.swing.JButton jBOk;
    private javax.swing.JButton jBVaciarFormulario;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTListaFormaPagos;
    // End of variables declaration//GEN-END:variables
}
