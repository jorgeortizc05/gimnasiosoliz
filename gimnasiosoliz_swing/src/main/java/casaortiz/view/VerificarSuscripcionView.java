/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.PersonaBuss;
import casaortiz.buss.SuscripcionBuss;
import casaortiz.model.Persona;
import casaortiz.model.Suscripcion;
import casaortiz.model.TipoPersona;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class VerificarSuscripcionView extends javax.swing.JPanel {

    private PersonaBuss perBuss;
    private Persona persona;
    
    private SuscripcionBuss susBuss;
    
    public VerificarSuscripcionView() {
        initComponents();
        perBuss = new PersonaBuss();
        susBuss = new SuscripcionBuss();
    }

    
    public void buscarPersonaPorCedula(String cedula){
        persona = perBuss.buscarPersonaPorCedula(cedula);
        if (persona.getId() == 0){
            JOptionPane.showMessageDialog(jLNombres, "No existe esta persona");
        }else{
            jLNombres.setText(persona.getNombre()+' '+persona.getApellido());
            loadImageGuardada(persona.getFoto());
        }
    }
    
    public void vaciarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTListaPersonas.getModel();
        modelo.setRowCount(0);
        jTListaPersonas.setModel(modelo);
    }
    
    public void vaciarCamposBusqueda(){
        jTFBusNombre.setText("");
        jTFBusApell.setText("");
        jTFBusCedula.setText("");
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
    
    private void loadImageGuardada(String name) {

        try {
            String string = System.getProperty("user.dir") + "/media/persona/" +name;
            
            Image img = new ImageIcon(string).getImage();
            
            //Me permite redimensionar la imagen para que se adapte al jLabel
            ImageIcon ii = new ImageIcon(img.getScaledInstance(400, 300, Image.SCALE_SMOOTH));

            jLFoto.setIcon(ii);
            jLFoto.validate();
            jLFoto.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTFBusqCedula = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLFoto = new javax.swing.JLabel();
        jLNombres = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLDiasRestantes = new javax.swing.JLabel();
        jLMensajeAdvertencia = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jBAgregarSuscripcion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JPListaPersonas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTListaPersonas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jBLimpiar = new javax.swing.JButton();
        jTFBusCedula = new javax.swing.JTextField();
        jTFBusNombre = new javax.swing.JTextField();
        jTFBusApell = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1280, 768));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFBusqCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBusqCedulaKeyPressed(evt);
            }
        });
        jPanel1.add(jTFBusqCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, -1));

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1280, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Estado Suscripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jLFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 400, 300));

        jLNombres.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 480, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Días Restantes:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 220, -1));

        jLDiasRestantes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel2.add(jLDiasRestantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 190, 120, 30));

        jLMensajeAdvertencia.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLMensajeAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLMensajeAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 480, 30));

        jButton1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 230, -1));

        jBAgregarSuscripcion.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jBAgregarSuscripcion.setText("Agregar Suscripción");
        jBAgregarSuscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarSuscripcionActionPerformed(evt);
            }
        });
        jPanel2.add(jBAgregarSuscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, 270, -1));

        jButton2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton2.setText("Generar Tarjeta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 270, -1));

        JPListaPersonas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        JPListaPersonas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTListaPersonas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTListaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTListaPersonas);

        JPListaPersonas.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1220, 340));

        jLabel13.setText("Nombre:");
        JPListaPersonas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jLabel14.setText("Apellido:");
        JPListaPersonas.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, 20));

        jLabel15.setText("Cedula:");
        JPListaPersonas.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, 20));

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });
        JPListaPersonas.add(jBLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));

        jTFBusCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusCedulaKeyReleased(evt);
            }
        });
        JPListaPersonas.add(jTFBusCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 140, -1));

        jTFBusNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusNombreKeyReleased(evt);
            }
        });
        JPListaPersonas.add(jTFBusNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 140, -1));

        jTFBusApell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusApellKeyReleased(evt);
            }
        });
        JPListaPersonas.add(jTFBusApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 140, -1));

        jPanel2.add(JPListaPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 1240, 410));

        jScrollPane1.setViewportView(jPanel2);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1280, 768));
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarSuscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarSuscripcionActionPerformed
        // TODO add your handling code here:
        if(persona == null){
            JOptionPane.showMessageDialog(jTFBusqCedula, "Primero debes cargar el cliente");
        }else{
            SuscripcionViewJFrame vsv = new SuscripcionViewJFrame(persona);
            vsv.setLocationRelativeTo(null);
            vsv.setVisible(true);
        }
        
    }//GEN-LAST:event_jBAgregarSuscripcionActionPerformed

    private void jTFBusqCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusqCedulaKeyPressed
        // TODO add your handling code here:
        try {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                verificarSuscripcion(jTFBusqCedula.getText());
            }
        } catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_jTFBusqCedulaKeyPressed

    public void seleccionarItemTabla(){
        int fila = jTListaPersonas.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            String cedula = jTListaPersonas.getValueAt(fila, 0).toString();
            verificarSuscripcion(cedula);
        }
    }
    
    public void verificarSuscripcion(String cedula){
        buscarPersonaPorCedula(cedula);
        jTFBusqCedula.setText("");
        Date hoy = new Date();
        Date fechaMaxima = susBuss.getFechaMaximaPorPersona(persona.getId());
        int dias = (int) ((fechaMaxima.getTime() - hoy.getTime())/86400000);
        
        if(dias < 0){
            jLMensajeAdvertencia.setText("RENOVAR SUSCRIPCIÓN");
            jLMensajeAdvertencia.setForeground(Color.red);
            jLDiasRestantes.setText(dias+"");
            jLDiasRestantes.setForeground(Color.red);
        }else{
            jLMensajeAdvertencia.setText("BIENVENIDO "+persona.getNombre());
            jLMensajeAdvertencia.setForeground(Color.BLACK);
            jLDiasRestantes.setText(dias+"");
        }
    }
    
    public void loadPersonasBusqueda(List<Persona> items){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTListaPersonas.getModel();
        List<Persona> personas = items;
        Object rowData[] = new Object[4];
        for(Persona p: personas){
            rowData[0] = p.getCedula();
            rowData[1] = p.getNombre();
            rowData[2] = p.getApellido();
            rowData[3] = p.getTelefono();
            modelo.addRow(rowData);
        }
        jTListaPersonas.setModel(modelo);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(persona == null){
            JOptionPane.showMessageDialog(jTFBusqCedula, "Primero debes cargar el cliente");
        }else{
            EditarPersonaView epv = new EditarPersonaView(persona);
            epv.setLocationRelativeTo(null);
            epv.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        loadPersonas();
        vaciarCamposBusqueda();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTFBusCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusCedulaKeyReleased
        // TODO add your handling code here:
        loadPersonasBusqueda(perBuss.buscarPersonasPorCedula(jTFBusCedula.getText()));
    }//GEN-LAST:event_jTFBusCedulaKeyReleased

    private void jTFBusNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusNombreKeyReleased
        loadPersonasBusqueda(perBuss.buscarPersonasPorNombre(jTFBusNombre.getText()));
    }//GEN-LAST:event_jTFBusNombreKeyReleased

    private void jTFBusApellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusApellKeyReleased
        // TODO add your handling code here:
        loadPersonasBusqueda(perBuss.buscarPersonasPorApellido(jTFBusApell.getText()));
    }//GEN-LAST:event_jTFBusApellKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        seleccionarItemTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPListaPersonas;
    private javax.swing.JButton jBAgregarSuscripcion;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLDiasRestantes;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLMensajeAdvertencia;
    private javax.swing.JLabel jLNombres;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFBusApell;
    private javax.swing.JTextField jTFBusCedula;
    private javax.swing.JTextField jTFBusNombre;
    private javax.swing.JTextField jTFBusqCedula;
    private javax.swing.JTable jTListaPersonas;
    // End of variables declaration//GEN-END:variables
}
