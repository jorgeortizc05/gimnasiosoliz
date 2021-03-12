/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.PersonaBuss;
import casaortiz.buss.SuscripcionBuss;
import casaortiz.model.Persona;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
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
            jLDiasRestantes.setForeground(Color.BLACK);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTFBusqCedula = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLFoto = new javax.swing.JLabel();
        jLMensajeAdvertencia = new javax.swing.JLabel();
        jLNombres = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLDiasRestantes = new javax.swing.JLabel();
        jBEditarPersona = new javax.swing.JButton();
        jBAgregarSuscripcion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFBusNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTFBusApell = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaPersonas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTFBusCedula = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFBusqCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBusqCedulaKeyPressed(evt);
            }
        });
        jPanel1.add(jTFBusqCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, -1));

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jBBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1090, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Estado de Suscripción"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 400, 300));

        jLMensajeAdvertencia.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLMensajeAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLMensajeAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 480, 30));

        jLNombres.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 480, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Días Restantes:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, -1, -1));

        jLDiasRestantes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel2.add(jLDiasRestantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, 150, 30));

        jBEditarPersona.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jBEditarPersona.setText("Editar");
        jBEditarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(jBEditarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 200, -1));

        jBAgregarSuscripcion.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jBAgregarSuscripcion.setText("Agregar Suscripción");
        jBAgregarSuscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarSuscripcionActionPerformed(evt);
            }
        });
        jPanel2.add(jBAgregarSuscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, -1, -1));

        jButton3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton3.setText("Generar Tarjeta");
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 250, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista de Clientes\n"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jTFBusNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusNombreKeyReleased(evt);
            }
        });
        jPanel3.add(jTFBusNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 160, -1));

        jLabel2.setText("Apellido:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jTFBusApell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusApellKeyReleased(evt);
            }
        });
        jPanel3.add(jTFBusApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 150, -1));

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(jBLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        jTListaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTListaPersonas);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1210, 420));

        jLabel4.setText("Cédula:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 50, -1));

        jTFBusCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusCedulaKeyReleased(evt);
            }
        });
        jPanel3.add(jTFBusCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 150, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 1230, 330));

        jScrollPane1.setViewportView(jPanel2);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1280, 668));
    }// </editor-fold>//GEN-END:initComponents

    private void jTFBusqCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusqCedulaKeyPressed
        // TODO add your handling code here:
        try {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                verificarSuscripcion(jTFBusqCedula.getText());
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jTFBusqCedulaKeyPressed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        seleccionarItemTabla();
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTFBusNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusNombreKeyReleased
        // TODO add your handling code here:
        loadPersonasBusqueda(perBuss.buscarPersonasPorNombre(jTFBusNombre.getText()));
    }//GEN-LAST:event_jTFBusNombreKeyReleased

    private void jTFBusApellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusApellKeyReleased
        // TODO add your handling code here:
        loadPersonasBusqueda(perBuss.buscarPersonasPorApellido(jTFBusApell.getText()));
    }//GEN-LAST:event_jTFBusApellKeyReleased

    private void jTFBusCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusCedulaKeyReleased
        // TODO add your handling code here:
        loadPersonasBusqueda(perBuss.buscarPersonasPorCedula(jTFBusCedula.getText()));
    }//GEN-LAST:event_jTFBusCedulaKeyReleased

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        vaciarTabla();
        vaciarCamposBusqueda();
    }//GEN-LAST:event_jBLimpiarActionPerformed

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

    private void jBEditarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarPersonaActionPerformed
        // TODO add your handling code here:
        if(persona == null){
            JOptionPane.showMessageDialog(jTFBusqCedula, "Primero debes cargar el cliente");
        }else{
            EditarPersonaView epv = new EditarPersonaView(persona);
            epv.setLocationRelativeTo(null);
            epv.setVisible(true);

        }
    }//GEN-LAST:event_jBEditarPersonaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarSuscripcion;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEditarPersona;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLDiasRestantes;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLMensajeAdvertencia;
    private javax.swing.JLabel jLNombres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFBusApell;
    private javax.swing.JTextField jTFBusCedula;
    private javax.swing.JTextField jTFBusNombre;
    private javax.swing.JTextField jTFBusqCedula;
    private javax.swing.JTable jTListaPersonas;
    // End of variables declaration//GEN-END:variables
}
