/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.CantonBuss;
import casaortiz.model.Canton;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class CantonView extends javax.swing.JPanel {

    private CantonBuss canBuss;
    private Canton canton;
    public CantonView() {
        initComponents();
        canBuss = new CantonBuss();
        jBActualizar.setEnabled(false);
        loadCantones();
    }

    public void guardar(){
        canton = new Canton();
        canton.setNombre(jTFNombre.getText());
        canton.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = canBuss.guardar(canton);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Cantón guardado");
            loadCantones();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al guardar el cantón");
        }
    }
    
    public void actualizar(){
        canton = new Canton();
        canton.setId(Integer.parseInt(jLID.getText()));
        canton.setNombre(jTFNombre.getText());
        canton.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = canBuss.actualizar(canton);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Cantón actualizado");
            loadCantones();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar el cantón");
        }
    }
    
    public void eliminar(){
        int fila = jTListaCantones.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaCantones.getValueAt(fila, 0).toString());
            String nombre = (String)jTListaCantones.getValueAt(fila, 1);        
            int estadoEliminacionDialog = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar "+nombre+"?","Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(estadoEliminacionDialog == 0){
                boolean estadoEliminacion = canBuss.eliminar(id);
                if(estadoEliminacion){
                    JOptionPane.showMessageDialog(this, "Cantón eliminado");
                    loadCantones();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al eliminar el cantón");
                }
            }
        }
    }
    
    public void seleccionarItemTabla(){
        int fila = jTListaCantones.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaCantones.getValueAt(fila, 0).toString());
            Canton item = canBuss.getCanton(id);
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
        DefaultTableModel modelo = (DefaultTableModel) jTListaCantones.getModel();
        modelo.setRowCount(0);
        jTListaCantones.setModel(modelo);
    }
    
    public void loadCantones(){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTListaCantones.getModel();
        List<Canton> cantones = canBuss.getCantones();
        Object rowData[] = new Object[3];
        for(Canton c: cantones){
            System.out.println(c);
            rowData[0] = c.getId();
            rowData[1] = c.getNombre();
            rowData[2] = c.getDescripcion();
            modelo.addRow(rowData);
        }
        jTListaCantones.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTListaCantones = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTFNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTADescripcion = new javax.swing.JTextArea();
        jLID = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBGuardar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBVaciarFormulario = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista de Cantones\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel2.setLayout(new java.awt.CardLayout());

        jTListaCantones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTListaCantones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cantón", "Descripción"
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
        jTListaCantones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListaCantonesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTListaCantones);
        if (jTListaCantones.getColumnModel().getColumnCount() > 0) {
            jTListaCantones.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTListaCantones.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTListaCantones.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        jPanel2.add(jScrollPane3, "card2");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos del Cantón", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 200));
        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {0, 5, 0};
        jPanel3Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel3.setLayout(jPanel3Layout);

        jTFNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jTFNombre, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Cantón:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel3, gridBagConstraints);

        jTADescripcion.setColumns(20);
        jTADescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTADescripcion.setLineWrap(true);
        jTADescripcion.setRows(5);
        jScrollPane2.setViewportView(jTADescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jScrollPane2, gridBagConstraints);

        jLID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLID.setPreferredSize(new java.awt.Dimension(400, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLID, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridLayout(1, 4));

        jBGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(jBGuardar);

        jBActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });
        jPanel4.add(jBActualizar);

        jBEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(jBEliminar);

        jBVaciarFormulario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBVaciarFormulario.setText("Vaciar Formulario");
        jBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVaciarFormularioActionPerformed(evt);
            }
        });
        jPanel4.add(jBVaciarFormulario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jPanel3, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        // TODO add your handling code here:
        actualizar();
        jBGuardar.setEnabled(true);
        jBActualizar.setEnabled(false);
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBVaciarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVaciarFormularioActionPerformed
        // TODO add your handling code here:
        vaciarFormulario();
        loadCantones();
        jBGuardar.setEnabled(true);
        jBActualizar.setEnabled(false);
    }//GEN-LAST:event_jBVaciarFormularioActionPerformed

    private void jTListaCantonesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListaCantonesMouseClicked
        // TODO add your handling code here:
        int fila = jTListaCantones.getSelectedRow();
        if(fila == -1){
            
        }else{
            jBActualizar.setEnabled(true);
            int id = Integer.parseInt((String)jTListaCantones.getValueAt(fila, 0).toString());
            Canton item = canBuss.getCanton(id);
            jLID.setText(""+item.getId());
            jTFNombre.setText(item.getNombre());
            jTADescripcion.setText(item.getDescripcion());
        }
    }//GEN-LAST:event_jTListaCantonesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBVaciarFormulario;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTListaCantones;
    // End of variables declaration//GEN-END:variables
}
