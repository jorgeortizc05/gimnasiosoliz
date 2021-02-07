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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jLabel2 = new javax.swing.JLabel();
        jCBCanton = new javax.swing.JComboBox<Canton>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTFRUC = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTADireccMatriz = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTADireccSucur = new javax.swing.JTextArea();
        JPListaEmpresas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaEmpresas = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("EMPRESA");
        jPanel2.add(jLabel8, new java.awt.GridBagConstraints());

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 11, 950, 40));

        jPDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        jPDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("ID:");
        jPDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 37, -1, -1));

        jLID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPDatos.add(jLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 91, 17));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Empresa:");
        jPDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 65, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Descripcion:");
        jPDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 103, -1, -1));

        jTFNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });
        jPDatos.add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 304, -1));

        jTADescripcion.setColumns(20);
        jTADescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTADescripcion.setLineWrap(true);
        jTADescripcion.setRows(5);
        jScrollPane1.setViewportView(jTADescripcion);

        jPDatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 304, -1));

        jBGuardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPDatos.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 140, -1));

        JBListar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBListar.setText("Listar");
        JBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListarActionPerformed(evt);
            }
        });
        jPDatos.add(JBListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 140, -1));

        JBEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });
        jPDatos.add(JBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, -1, -1));

        JBOk.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBOk.setText("Ok");
        JBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBOkActionPerformed(evt);
            }
        });
        jPDatos.add(JBOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 60, -1));

        JBEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });
        jPDatos.add(JBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 140, -1));

        JBVaciarFormulario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBVaciarFormulario.setText("Vaciar Formulario");
        JBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVaciarFormularioActionPerformed(evt);
            }
        });
        jPDatos.add(JBVaciarFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Cantón:");
        jPDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jCBCanton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPDatos.add(jCBCanton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 192, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("RUC:");
        jPDatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Dirección Matriz:");
        jPDatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Direccion Sucursal:");
        jPDatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));
        jPDatos.add(jTFRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 230, -1));

        JTADireccMatriz.setColumns(20);
        JTADireccMatriz.setLineWrap(true);
        JTADireccMatriz.setRows(5);
        jScrollPane3.setViewportView(JTADireccMatriz);

        jPDatos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 230, 100));

        JTADireccSucur.setColumns(20);
        JTADireccSucur.setLineWrap(true);
        JTADireccSucur.setRows(5);
        jScrollPane4.setViewportView(JTADireccSucur);

        jPDatos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 230, -1));

        add(jPDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 950, 300));

        JPListaEmpresas.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Empresas"));
        JPListaEmpresas.setLayout(new java.awt.GridLayout(1, 0));

        jTListaEmpresas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTListaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUC", "Nombre", "Descripcion", "Direccion Matriz"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTListaEmpresas);

        JPListaEmpresas.add(jScrollPane2);

        add(JPListaEmpresas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 950, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        //guardarCanton();
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void JBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBListarActionPerformed
        // TODO add your handling code here:
        loadEmpresas();
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

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBListar;
    private javax.swing.JButton JBOk;
    private javax.swing.JButton JBVaciarFormulario;
    private javax.swing.JPanel JPListaEmpresas;
    private javax.swing.JTextArea JTADireccMatriz;
    private javax.swing.JTextArea JTADireccSucur;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JComboBox<Canton> jCBCanton;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPDatos;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFRUC;
    private javax.swing.JTable jTListaEmpresas;
    // End of variables declaration//GEN-END:variables
}
