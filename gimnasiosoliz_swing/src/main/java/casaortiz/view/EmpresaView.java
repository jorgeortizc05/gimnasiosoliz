/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.CantonBuss;
import casaortiz.buss.EmpresaBuss;
import casaortiz.model.Canton;
import casaortiz.model.Empresa;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class EmpresaView extends javax.swing.JPanel {

    private Canton canton;
    
    private EmpresaBuss empBuss;
    private CantonBuss canBuss;
    private Empresa empresa;
    
    public EmpresaView() {
        initComponents();
        empBuss = new EmpresaBuss();
        canBuss = new CantonBuss();
        //loadEmpresas();
        loadCantones();
        loadEmpresas();
    }

    public void guardar(){
        empresa = new Empresa();
        empresa.setNombre(jTFNombre.getText());
        empresa.setDescripcion(jTADescripcion.getText());
        empresa.setRUC(jTFRUC.getText());
        empresa.setDireccionMatriz(JTADireccMatriz.getText());
        empresa.setDireccionSucursal(JTADireccSucur.getText());
        //recupero id del canton
        Canton item = (Canton) jCBCanton.getSelectedItem();
        empresa.setIdCanton(item.getId());
        boolean estadoGuardado = empBuss.guardar(empresa);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Empresa guardado");
            loadEmpresas();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al guardar la empresa");
        }
    }
    
    public void actualizar(){
        empresa = new Empresa();
        empresa.setId(Integer.parseInt(jLID.getText()));
        empresa.setNombre(jTFNombre.getText());
        empresa.setDescripcion(jTADescripcion.getText());
        empresa.setRUC(jTFRUC.getText());
        empresa.setDireccionMatriz(JTADireccMatriz.getText());
        empresa.setDireccionSucursal(JTADireccSucur.getText());
        //recupero id del canton
        Canton item = (Canton) jCBCanton.getSelectedItem();
        System.out.println(empresa);
        empresa.setIdCanton(item.getId());
        boolean estadoActualizacion = empBuss.actualizar(empresa);
        if(estadoActualizacion){
            JOptionPane.showMessageDialog(this, "Empresa actualizado");
            loadEmpresas();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar la empresa");
        }
    }
    
    public void eliminar(){
        canBuss = new CantonBuss();
        int fila = jTListaEmpresas.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaEmpresas.getValueAt(fila, 0).toString());
            String nombre = (String)jTListaEmpresas.getValueAt(fila, 1);        
            int estadoEliminacionDialog = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar "+nombre+"?","Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(estadoEliminacionDialog == 0){
                boolean estadoEliminacion = empBuss.eliminar(id);
                if(estadoEliminacion){
                    JOptionPane.showMessageDialog(this, "Empresa eliminado");
                    loadEmpresas();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al eliminar la empresa");
                }
            }
        }
    }
    
    public void seleccionarItemTabla(){
        int fila = jTListaEmpresas.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaEmpresas.getValueAt(fila, 0).toString());
            Empresa item = empBuss.getEmpresa(id);
            jLID.setText(""+item.getId());
            jTFNombre.setText(item.getNombre());
            jTADescripcion.setText(item.getDescripcion());
            jTFRUC.setText(item.getRUC());
            JTADireccMatriz.setText(item.getDireccionMatriz());
            JTADireccSucur.setText(item.getDireccionSucursal());
            //Cargo mi canton al combobox
            Canton itemCanton = canBuss.getCanton(item.getIdCanton());
            System.out.println(itemCanton);
            jCBCanton.getModel().setSelectedItem(itemCanton);
        }
    }
    
    public void vaciarFormulario(){
        jLID.setText("");
        jTFNombre.setText("");
        jTADescripcion.setText("");
    }
    
    public void vaciarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTListaEmpresas.getModel();
        modelo.setRowCount(0);
        jTListaEmpresas.setModel(modelo);
    }
    
    public void loadEmpresas(){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTListaEmpresas.getModel();
        List<Empresa> empresas = empBuss.getEmpresas();
        Object rowData[] = new Object[5];
        for(Empresa e: empresas){
            System.out.println(e);
            rowData[0] = e.getId();
            rowData[1] = e.getRUC();
            rowData[2] = e.getNombre();
            rowData[3] = e.getDescripcion();
            rowData[4] = e.getDireccionMatriz();
            modelo.addRow(rowData);
        }
        jTListaEmpresas.setModel(modelo);
    }
    
    public void loadCantones(){
        List<Canton> cantones = canBuss.getCantones();
        for(Canton c: cantones){
           jCBCanton.addItem(c);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTListaEmpresas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTADescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jCBCanton = new javax.swing.JComboBox<Canton>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTADireccMatriz = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTADireccSucur = new javax.swing.JTextArea();
        jTFRUC = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jBGuardar = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBOk = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBListar = new javax.swing.JButton();
        jBVaciarFormulario = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1280, 768));
        setLayout(new java.awt.CardLayout());

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0};
        jPanel1.setLayout(jPanel1Layout);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Lista de Empresas"));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(600, 0));

        jTListaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "RUC", "Nombre", "Descripción", "Dirección Matriz"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTListaEmpresas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTListaEmpresas.setPreferredSize(new java.awt.Dimension(450, 450));
        jScrollPane5.setViewportView(jTListaEmpresas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jScrollPane5, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos de Empresas"));
        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel3Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel3.setLayout(jPanel3Layout);

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
        jLabel2.setText("Empresa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Descripcion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLID, gridBagConstraints);

        jTFNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFNombre.setPreferredSize(new java.awt.Dimension(280, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jTFNombre, gridBagConstraints);

        jTADescripcion.setColumns(20);
        jTADescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTADescripcion.setLineWrap(true);
        jTADescripcion.setRows(5);
        jScrollPane2.setViewportView(jTADescripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jScrollPane2, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Cantón");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel5, gridBagConstraints);

        jCBCanton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCBCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCantonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jCBCanton, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("RUC:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Dirección Matriz:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel7, gridBagConstraints);

        JTADireccMatriz.setColumns(20);
        JTADireccMatriz.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JTADireccMatriz.setLineWrap(true);
        JTADireccMatriz.setRows(5);
        jScrollPane3.setViewportView(JTADireccMatriz);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jScrollPane3, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Dirección Sucursal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jLabel8, gridBagConstraints);

        JTADireccSucur.setColumns(20);
        JTADireccSucur.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JTADireccSucur.setLineWrap(true);
        JTADireccSucur.setRows(5);
        jScrollPane4.setViewportView(JTADireccSucur);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jScrollPane4, gridBagConstraints);

        jTFRUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jTFRUC, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridLayout(2, 3));

        jBGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(jBGuardar);

        jBEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });
        jPanel4.add(jBEditar);

        jBOk.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBOk.setText("OK");
        jBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOkActionPerformed(evt);
            }
        });
        jPanel4.add(jBOk);

        jBEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(jBEliminar);

        jBListar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBListar.setText("Listar");
        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarActionPerformed(evt);
            }
        });
        jPanel4.add(jBListar);

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
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel3.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jPanel3, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarActionPerformed
        // TODO add your handling code here:
        loadEmpresas();
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

    private void jCBCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCantonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBCantonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTADireccMatriz;
    private javax.swing.JTextArea JTADireccSucur;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBListar;
    private javax.swing.JButton jBOk;
    private javax.swing.JButton jBVaciarFormulario;
    private javax.swing.JComboBox<Canton> jCBCanton;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFRUC;
    private javax.swing.JTable jTListaEmpresas;
    // End of variables declaration//GEN-END:variables
}
