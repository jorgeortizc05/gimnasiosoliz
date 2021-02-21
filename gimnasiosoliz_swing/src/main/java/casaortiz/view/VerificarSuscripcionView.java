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
import com.sun.glass.events.KeyEvent;
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

    
    public void buscarPersonaPorCedula(){
        persona = perBuss.buscarPersonaPorCedula(jTFBusqCedula.getText());
        if (persona.getId() == 0){
            JOptionPane.showMessageDialog(jLNombres, "No existe esta persona");
        }else{
            jLNombres.setText(persona.getNombre()+' '+persona.getApellido());
            loadImageGuardada(persona.getFoto());
        }
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
        jBVerificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLFoto = new javax.swing.JLabel();
        jLNombres = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLDiasRestantes = new javax.swing.JLabel();
        jLMensajeAdvertencia = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jBAgregarSuscripcion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFBusqCedula.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTFBusqCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBusqCedulaKeyPressed(evt);
            }
        });
        jPanel1.add(jTFBusqCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, -1));

        jBVerificar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBVerificar.setText("Verificar");
        jBVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerificarActionPerformed(evt);
            }
        });
        jPanel1.add(jBVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 980, 60));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Estado Suscripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jLFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 400, 300));

        jLNombres.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 480, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Días Restantes:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 220, -1));

        jLDiasRestantes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel2.add(jLDiasRestantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 310, 120, 30));

        jLMensajeAdvertencia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLMensajeAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLMensajeAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 480, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Editar");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 230, -1));

        jBAgregarSuscripcion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBAgregarSuscripcion.setText("Agregar Suscripción");
        jBAgregarSuscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarSuscripcionActionPerformed(evt);
            }
        });
        jPanel2.add(jBAgregarSuscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, 270, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Generar Tarjeta");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 230, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Eliminar Cliente");
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, 270, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1280, 768));
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

    private void jBVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerificarActionPerformed
        // TODO add your handling code here:
        buscarPersonaPorCedula();
        jTFBusqCedula.setText("");
    }//GEN-LAST:event_jBVerificarActionPerformed

    private void jTFBusqCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusqCedulaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarPersonaPorCedula();
            jTFBusqCedula.setText("");
            Date hoy = new Date();
            Date fechaMaxima = susBuss.getFechaMaximaPorPersona(persona.getId());
            int dias = (int) ((fechaMaxima.getTime() - hoy.getTime())/86400000);
            jLDiasRestantes.setText(dias+"");
            if(dias < 0){
                jLMensajeAdvertencia.setText("RENOVAR SUSCRIPCIÓN");
                jLMensajeAdvertencia.setForeground(Color.red);
            }else{
                jLMensajeAdvertencia.setText("BIENVENIDO "+persona.getNombre());
                jLMensajeAdvertencia.setForeground(Color.BLACK);
            }
        }
    }//GEN-LAST:event_jTFBusqCedulaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarSuscripcion;
    private javax.swing.JButton jBVerificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLDiasRestantes;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLMensajeAdvertencia;
    private javax.swing.JLabel jLNombres;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFBusqCedula;
    // End of variables declaration//GEN-END:variables
}
