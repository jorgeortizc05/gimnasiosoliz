/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.PersonaBuss;
import casaortiz.buss.TipoPersonaBuss;
import casaortiz.model.Persona;
import casaortiz.model.TipoPersona;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class PersonaView extends javax.swing.JPanel {

    private Persona persona;
    private List<Persona> personas;
    private PersonaBuss perBuss;
    private TipoPersonaBuss tpBuss;
    
    public PersonaView() {
        initComponents();
        perBuss = new PersonaBuss();
        tpBuss = new TipoPersonaBuss();
        loadPersonas();
        loadTipoPersonas();
    }

    public void guardar(){
        persona = new Persona();
        persona.setNombre(jTFNombre.getText());
        persona.setApellido(jTFApellido.getText());
        persona.setCedula(jTFCedula.getText());
        persona.setDireccion(jTFApellido.getText());
        persona.setEmail(jTFEmail.getText());
        persona.setFechaNacimiento(rSDCFechaNacimiento.getDatoFecha());
        persona.setTelefono(jTFTele.getText());
        persona.setActivo("A");
        TipoPersona item = (TipoPersona) jCBTipoPersona.getSelectedItem();
        persona.setIdTipoPersona(item.getId());
        boolean estadoGuardado = perBuss.guardar(persona);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Persona guardado");
            loadPersonas();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al guardar la Persona");
        }
    }
    
    public void actualizar(){
        persona = new Persona();
        persona.setId(Integer.parseInt(jLID.getText()));
        persona.setNombre(jTFNombre.getText());
        persona.setApellido(jTFApellido.getText());
        persona.setCedula(jTFCedula.getText());
        persona.setDireccion(jTFApellido.getText());
        persona.setEmail(jTFEmail.getText());
        System.out.println(rSDCFechaNacimiento.getFormatoFecha());
        persona.setFechaNacimiento(rSDCFechaNacimiento.getDatoFecha());
        persona.setTelefono(jTFTele.getText());
        persona.setActivo("A");
        TipoPersona item = (TipoPersona) jCBTipoPersona.getSelectedItem();
        persona.setIdTipoPersona(item.getId());
        boolean estadoGuardado = perBuss.actualizar(persona);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Persona actualizada");
            loadPersonas();
            vaciarFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar la Persona");
        }
    }
    
    public void eliminar(){
        int fila = jTListaPersonas.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaPersonas.getValueAt(fila, 0).toString());
            String nombre = (String)jTListaPersonas.getValueAt(fila, 1);        
            int estadoEliminacionDialog = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar "+nombre+"?","Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(estadoEliminacionDialog == 0){
                boolean estadoEliminacion = perBuss.eliminar(id);
                if(estadoEliminacion){
                    JOptionPane.showMessageDialog(this, "Persona eliminado");
                    loadPersonas();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al eliminar la Persona");
                }
            }
        }
    }
    
    public void seleccionarItemTabla(){
        int fila = jTListaPersonas.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTListaPersonas.getValueAt(fila, 0).toString());
            Persona item = perBuss.getPersona(id);
            jLID.setText(""+item.getId());
            jTFNombre.setText(item.getNombre());
            jTFApellido.setText(item.getApellido());
            jTFCedula.setText(item.getCedula());
            JTADirecc.setText(item.getDireccion());
            jTFEmail.setText(item.getEmail());
            rSDCFechaNacimiento.setDatoFecha(item.getFechaNacimiento());
            jTFTele.setText(item.getTelefono());
            TipoPersona itemTipoPersona = tpBuss.getTipoPersona(item.getIdTipoPersona());
            jCBTipoPersona.getModel().setSelectedItem(itemTipoPersona);
            
        }
    }
    
    public void vaciarFormulario(){
        jLID.setText("");
        jTFNombre.setText("");
        jTFApellido.setText("");
        jTFCedula.setText("");
        JTADirecc.setText("");
        jTFEmail.setText("");
        rSDCFechaNacimiento.setDatoFecha(null);
        jTFTele.setText("");
    }
    
    public void vaciarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTListaPersonas.getModel();
        modelo.setRowCount(0);
        jTListaPersonas.setModel(modelo);
    }
    
    public void loadTipoPersonas(){
        List<TipoPersona> items = tpBuss.getTipoPersonas();
        for(TipoPersona tp: items){
           jCBTipoPersona.addItem(tp);
        }
    }
    
    public void loadPersonas(){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTListaPersonas.getModel();
        List<Persona> personas = perBuss.getPersonas();
        Object rowData[] = new Object[6];
        for(Persona p: personas){
            rowData[0] = p.getId();
            rowData[1] = p.getNombre();
            rowData[2] = p.getApellido();
            rowData[3] = p.getEmail();
            rowData[4] = p.getTelefono();
            rowData[5] = p.getActivo();
            modelo.addRow(rowData);
        }
        jTListaPersonas.setModel(modelo);
    }
    
    public void loadPersonasBusqueda(List<Persona> items){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTListaPersonas.getModel();
        List<Persona> personas = items;
        Object rowData[] = new Object[6];
        for(Persona p: personas){
            rowData[0] = p.getId();
            rowData[1] = p.getNombre();
            rowData[2] = p.getApellido();
            rowData[3] = p.getEmail();
            rowData[4] = p.getTelefono();
            rowData[5] = p.getActivo();
            modelo.addRow(rowData);
        }
        jTListaPersonas.setModel(modelo);
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
        jTFCedula = new javax.swing.JTextField();
        jBGuardar = new javax.swing.JButton();
        JBListar = new javax.swing.JButton();
        JBEditar = new javax.swing.JButton();
        JBOk = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        JBVaciarFormulario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCBTipoPersona = new javax.swing.JComboBox<TipoPersona>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFTele = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTADirecc = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTFApellido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rSDCFechaNacimiento = new rojeru_san.componentes.RSDateChooser();
        JPListaPersonas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaPersonas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jBLimpiar = new javax.swing.JButton();
        jTFBusCedula = new javax.swing.JTextField();
        jTFBusNombre = new javax.swing.JTextField();
        jTFBusApell = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("Persona");
        jPanel2.add(jLabel8, new java.awt.GridBagConstraints());

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 11, 950, 40));

        jPDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        jPDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("ID:");
        jPDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPDatos.add(jLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 130, 17));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Cédula:");
        jPDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jTFCedula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCedulaActionPerformed(evt);
            }
        });
        jPDatos.add(jTFCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 270, -1));

        jBGuardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPDatos.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 140, -1));

        JBListar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBListar.setText("Listar");
        JBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListarActionPerformed(evt);
            }
        });
        jPDatos.add(JBListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 140, -1));

        JBEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });
        jPDatos.add(JBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        JBOk.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBOk.setText("Ok");
        JBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBOkActionPerformed(evt);
            }
        });
        jPDatos.add(JBOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 60, -1));

        JBEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });
        jPDatos.add(JBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 140, -1));

        JBVaciarFormulario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JBVaciarFormulario.setText("Vaciar Formulario");
        JBVaciarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVaciarFormularioActionPerformed(evt);
            }
        });
        jPDatos.add(JBVaciarFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Tipo Persona:");
        jPDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jCBTipoPersona.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPDatos.add(jCBTipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 270, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Teléfono:");
        jPDatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Dirección:");
        jPDatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 80, -1));

        jTFTele.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPDatos.add(jTFTele, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 270, -1));

        JTADirecc.setColumns(20);
        JTADirecc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JTADirecc.setLineWrap(true);
        JTADirecc.setRows(5);
        jScrollPane3.setViewportView(JTADirecc);

        jPDatos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 270, 100));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Nombre:");
        jPDatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        jTFNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });
        jPDatos.add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 270, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Apellido:");
        jPDatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 20));

        jTFApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFApellidoActionPerformed(evt);
            }
        });
        jPDatos.add(jTFApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 270, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Email:");
        jPDatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        jTFEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });
        jPDatos.add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 270, -1));

        jLabel12.setText("jLabel12");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPDatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 360, 260));

        jButton1.setText("Seleccionar");
        jPDatos.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Fecha");
        jPDatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 50, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Nacimiento");
        jPDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, -1));

        rSDCFechaNacimiento.setBackground(java.awt.SystemColor.control);
        rSDCFechaNacimiento.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDCFechaNacimiento.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDCFechaNacimiento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rSDCFechaNacimiento.setFormatoFecha("dd/MM/yyyy");
        rSDCFechaNacimiento.setFuente(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rSDCFechaNacimiento.setPlaceholder("");
        jPDatos.add(rSDCFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 270, -1));

        add(jPDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 970, 510));

        JPListaPersonas.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Empresas"));
        JPListaPersonas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTListaPersonas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTListaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Email", "Telefono", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTListaPersonas);

        JPListaPersonas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 938, 357));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Nombre:");
        JPListaPersonas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Apellido:");
        JPListaPersonas.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, 20));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Cedula:");
        JPListaPersonas.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, 20));

        jBLimpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });
        JPListaPersonas.add(jBLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));

        jTFBusCedula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFBusCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusCedulaKeyReleased(evt);
            }
        });
        JPListaPersonas.add(jTFBusCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 140, -1));

        jTFBusNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFBusNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusNombreKeyReleased(evt);
            }
        });
        JPListaPersonas.add(jTFBusNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 140, -1));

        jTFBusApell.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFBusApell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusApellKeyReleased(evt);
            }
        });
        JPListaPersonas.add(jTFBusApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 140, -1));

        add(JPListaPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 950, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void jTFCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCedulaActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        //guardarCanton();
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void JBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBListarActionPerformed
        // TODO add your handling code here:
        loadPersonas();
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

    private void jTFApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFApellidoActionPerformed

    private void jTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailActionPerformed

    private void jTFBusNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusNombreKeyReleased
        loadPersonasBusqueda(perBuss.buscarPersonaPorNombre(jTFBusNombre.getText()));
    }//GEN-LAST:event_jTFBusNombreKeyReleased

    private void jTFBusApellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusApellKeyReleased
        // TODO add your handling code here:
        loadPersonasBusqueda(perBuss.buscarPersonaPorApellido(jTFBusApell.getText()));
    }//GEN-LAST:event_jTFBusApellKeyReleased

    private void jTFBusCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusCedulaKeyReleased
        // TODO add your handling code here:
        loadPersonasBusqueda(perBuss.buscarPersonaPorCedula(jTFBusCedula.getText()));
    }//GEN-LAST:event_jTFBusCedulaKeyReleased

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        loadPersonas();
        vaciarCamposBusqueda();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    public void vaciarCamposBusqueda(){
        jTFBusNombre.setText("");
        jTFBusApell.setText("");
        jTFBusCedula.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBListar;
    private javax.swing.JButton JBOk;
    private javax.swing.JButton JBVaciarFormulario;
    private javax.swing.JPanel JPListaPersonas;
    private javax.swing.JTextArea JTADirecc;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<TipoPersona> jCBTipoPersona;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPDatos;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFBusApell;
    private javax.swing.JTextField jTFBusCedula;
    private javax.swing.JTextField jTFBusNombre;
    private javax.swing.JTextField jTFCedula;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFTele;
    private javax.swing.JTable jTListaPersonas;
    private rojeru_san.componentes.RSDateChooser rSDCFechaNacimiento;
    // End of variables declaration//GEN-END:variables
}
