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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
        }
    }
    
    public void loadSuscripcionesPorPersona(){
        vaciarTabla();
        DefaultTableModel modelo = (DefaultTableModel) jTHistorialSuscripcion.getModel();
        List<Suscripcion> items = susBuss.getHistorialSuscripcionesPersona(persona.getId());
        Object rowData[] = new Object[4];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(Suscripcion s: items){
            System.out.println(s);
            rowData[0] = s.getId();
            rowData[1] = sdf.format(s.getFechaDesde());
            rowData[2] = sdf.format(s.getFechaHasta());
            rowData[3] = s.getImporteTotal();
            modelo.addRow(rowData);
        }
        jTHistorialSuscripcion.setModel(modelo);
    }
    
    public void vaciarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTHistorialSuscripcion.getModel();
        modelo.setRowCount(0);
        jTHistorialSuscripcion.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTFBusqCedula = new javax.swing.JTextField();
        jBVerificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLNombres = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLDiasRestantes = new javax.swing.JLabel();
        jLMensajeAdvertencia = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jBAgregarSuscripcion = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTHistorialSuscripcion = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFBusqCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBusqCedulaKeyPressed(evt);
            }
        });
        jPanel1.add(jTFBusqCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 183, -1));

        jBVerificar.setText("Verificar");
        jBVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerificarActionPerformed(evt);
            }
        });
        jPanel1.add(jBVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 980, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Estado Suscripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("jLabel1");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 400, 340));

        jLNombres.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 480, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("DIAS RESTANTES:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 220, -1));

        jLDiasRestantes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel2.add(jLDiasRestantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 190, 30));

        jLMensajeAdvertencia.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLMensajeAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLMensajeAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 480, 30));

        jButton1.setText("Editar");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 100, -1));

        jBAgregarSuscripcion.setText("Agregar una Suscripción");
        jBAgregarSuscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarSuscripcionActionPerformed(evt);
            }
        });
        jPanel2.add(jBAgregarSuscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 960, 390));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Suscripciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTHistorialSuscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha Desde", "Fecha Hasta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTHistorialSuscripcion);
        if (jTHistorialSuscripcion.getColumnModel().getColumnCount() > 0) {
            jTHistorialSuscripcion.getColumnModel().getColumn(0).setPreferredWidth(6);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 940, 450));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 960, 490));
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
        loadSuscripcionesPorPersona();
        jTFBusqCedula.setText("");
    }//GEN-LAST:event_jBVerificarActionPerformed

    private void jTFBusqCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusqCedulaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarPersonaPorCedula();
            loadSuscripcionesPorPersona();
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
    private javax.swing.JLabel jLDiasRestantes;
    private javax.swing.JLabel jLMensajeAdvertencia;
    private javax.swing.JLabel jLNombres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFBusqCedula;
    private javax.swing.JTable jTHistorialSuscripcion;
    // End of variables declaration//GEN-END:variables
}
