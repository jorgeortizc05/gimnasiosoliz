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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
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
        jBGuardar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBVaciarFormulario = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBOk = new javax.swing.JButton();
        jBListar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTListaEmpresas = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos de la Empresa"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 27, -1, -1));

        jLabel2.setText("Empresa:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 61, -1, -1));

        jLabel3.setText("Descripcion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 87, -1, -1));
        jPanel1.add(jLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 93, 14));
        jPanel1.add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 220, -1));

        jTADescripcion.setColumns(20);
        jTADescripcion.setRows(5);
        jScrollPane2.setViewportView(jTADescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel5.setText("Cantón");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jPanel1.add(jCBCanton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 220, -1));

        jLabel6.setText("RUC:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        jLabel7.setText("Dirección Matriz:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        JTADireccMatriz.setColumns(20);
        JTADireccMatriz.setRows(5);
        jScrollPane3.setViewportView(JTADireccMatriz);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jLabel8.setText("Dirección Sucursal:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        JTADireccSucur.setColumns(20);
        JTADireccSucur.setRows(5);
        jScrollPane4.setViewportView(JTADireccSucur);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));
        jPanel1.add(jTFRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 166, -1));

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 150, -1));

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 150, -1));

        jBVaciarFormulario.setText("Vaciar Formulario");
        jBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVaciarFormularioActionPerformed(evt);
            }
        });
        jPanel1.add(jBVaciarFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 150, -1));

        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });
        jPanel1.add(jBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 80, -1));

        jBOk.setText("OK");
        jBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOkActionPerformed(evt);
            }
        });
        jPanel1.add(jBOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 64, -1));

        jBListar.setText("Listar");
        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarActionPerformed(evt);
            }
        });
        jPanel1.add(jBListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 150, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista de Empresas\n"));

        jTListaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUC", "Nombre", "Descripción", "Dirección Matriz"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTListaEmpresas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 294, 1231, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
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
    private javax.swing.JPanel jPanel2;
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
