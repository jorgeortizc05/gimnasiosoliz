/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.CategoriaBuss;
import casaortiz.model.Categoria;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class CategoriaView extends javax.swing.JPanel {

    private CategoriaBuss catBuss;
    private Categoria categoria;
    public CategoriaView() {
        initComponents();
        jBActualizar.setEnabled(false);
        catBuss = new CategoriaBuss();
        loadCategorias();
    }
    
    public void guardar(){
        categoria = new Categoria();
        categoria.setNombre(jTFNombre.getText());
        categoria.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = catBuss.guardar(categoria);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Categoria guardado");
            loadCategorias();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al guardar la categoria");
        }
    }
    
    public void actualizar(){
        categoria = new Categoria();
        categoria.setId(Integer.parseInt(jLID.getText()));
        categoria.setNombre(jTFNombre.getText());
        categoria.setDescripcion(jTADescripcion.getText());
        boolean estadoGuardado = catBuss.actualizar(categoria);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Categoria actualizado");
            loadCategorias();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar la categoria");
        }
    }
    
    public void eliminar(){
        int fila = jTListaCategorias.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaCategorias.getValueAt(fila, 0).toString());
            String nombre = (String)jTListaCategorias.getValueAt(fila, 1);        
            int estadoEliminacionDialog = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar "+nombre+"?","Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(estadoEliminacionDialog == 0){
                boolean estadoEliminacion = catBuss.eliminar(id);
                if(estadoEliminacion){
                    JOptionPane.showMessageDialog(this, "Categoria eliminado");
                    loadCategorias();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al eliminar la categoria");
                }
            }
        }
    }
    
    public void seleccionarItemTabla(){
        int fila = jTListaCategorias.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaCategorias.getValueAt(fila, 0).toString());
            Categoria item = catBuss.getCategoria(id);
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
        DefaultTableModel modelo = (DefaultTableModel) jTListaCategorias.getModel();
        modelo.setRowCount(0);
        jTListaCategorias.setModel(modelo);
    }
    
    public void loadCategorias(){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTListaCategorias.getModel();
        List<Categoria> items = catBuss.getCategorias();
        Object rowData[] = new Object[3];
        for(Categoria c: items){
            System.out.println(c);
            rowData[0] = c.getId();
            rowData[1] = c.getNombre();
            rowData[2] = c.getDescripcion();
            modelo.addRow(rowData);
        }
        jTListaCategorias.setModel(modelo);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTADescripcion = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jBGuardar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBVaciarFormulario = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaCategorias = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Ingresar Categoría", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jLabel2, gridBagConstraints);

        jLID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLID.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jLID, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jLabel3, gridBagConstraints);

        jTFNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFNombre.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jTFNombre, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jLabel4, gridBagConstraints);

        jTADescripcion.setColumns(20);
        jTADescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTADescripcion.setLineWrap(true);
        jTADescripcion.setRows(5);
        jTADescripcion.setPreferredSize(new java.awt.Dimension(100, 20));
        jScrollPane3.setViewportView(jTADescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jScrollPane3, gridBagConstraints);

        jPanel1.add(jPanel7, java.awt.BorderLayout.WEST);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jBGuardar.setBackground(new java.awt.Color(194, 60, 61));
        jBGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBGuardar.setForeground(java.awt.Color.white);
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel6.add(jBGuardar);

        jBActualizar.setBackground(new java.awt.Color(194, 60, 61));
        jBActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBActualizar.setForeground(java.awt.Color.white);
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });
        jPanel6.add(jBActualizar);

        jBEliminar.setBackground(new java.awt.Color(194, 60, 61));
        jBEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBEliminar.setForeground(java.awt.Color.white);
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel6.add(jBEliminar);

        jBVaciarFormulario.setBackground(new java.awt.Color(194, 60, 61));
        jBVaciarFormulario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBVaciarFormulario.setForeground(java.awt.Color.white);
        jBVaciarFormulario.setText("Vaciar Formulario");
        jBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVaciarFormularioActionPerformed(evt);
            }
        });
        jPanel6.add(jBVaciarFormulario);

        jPanel1.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista de Categorías", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setLayout(new java.awt.CardLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTListaCategorias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTListaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoría", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTListaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTListaCategorias);

        jPanel5.add(jScrollPane2, "card2");

        jPanel3.add(jPanel5);

        add(jPanel3, java.awt.BorderLayout.CENTER);
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
        loadCategorias();
        jBGuardar.setEnabled(true);
        jBActualizar.setEnabled(false);
    }//GEN-LAST:event_jBVaciarFormularioActionPerformed

    private void jTListaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListaCategoriasMouseClicked
        // TODO add your handling code here:
        jBGuardar.setEnabled(false);
        jBActualizar.setEnabled(true);
        seleccionarItemTabla();
    }//GEN-LAST:event_jTListaCategoriasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBVaciarFormulario;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTListaCategorias;
    // End of variables declaration//GEN-END:variables
}
