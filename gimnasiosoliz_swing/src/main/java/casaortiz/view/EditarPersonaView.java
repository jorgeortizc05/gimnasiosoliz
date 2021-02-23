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
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class EditarPersonaView extends javax.swing.JFrame {
    
    private Persona persona;
    private List<Persona> personas;
    private PersonaBuss perBuss;
    private TipoPersonaBuss tpBuss;
    
    private Executor executor = Executors.newSingleThreadExecutor();
    private AtomicBoolean initialized = new AtomicBoolean(false);
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    
    public EditarPersonaView(Persona persona) {
        initComponents();
        this.persona = persona;
        perBuss = new PersonaBuss();
        tpBuss = new TipoPersonaBuss();
        loadPersona();
    }
    
    public void loadPersona(){
        jLID.setText(""+persona.getId());
        jTFNombre.setText(persona.getNombre());
        jTFApellido.setText(persona.getApellido());
        jTFCedula.setText(persona.getCedula());
        JTADirecc.setText(persona.getDireccion());
        jTFEmail.setText(persona.getEmail());
        rSDCFechaNacimiento.setDatoFecha(persona.getFechaNacimiento());
        jTFTele.setText(persona.getTelefono());
        TipoPersona itemTipoPersona = tpBuss.getTipoPersona(persona.getIdTipoPersona());
        jCBTipoPersona.getModel().setSelectedItem(itemTipoPersona);
        loadImageGuardada(persona.getFoto());
    }
    
    public void actualizar(){
        persona = new Persona();
        persona.setId(Integer.parseInt(jLID.getText()));
        persona.setNombre(jTFNombre.getText());
        persona.setApellido(jTFApellido.getText());
        persona.setCedula(jTFCedula.getText());
        persona.setDireccion(JTADirecc.getText());
        persona.setEmail(jTFEmail.getText());
        System.out.println(rSDCFechaNacimiento.getFormatoFecha());
        persona.setFechaNacimiento(rSDCFechaNacimiento.getDatoFecha());
        persona.setTelefono(jTFTele.getText());
        persona.setActivo("A");
        persona.setFoto(jTFCedula.getText()+".png");
        TipoPersona item = (TipoPersona) jCBTipoPersona.getSelectedItem();
        persona.setIdTipoPersona(item.getId());
        boolean estadoGuardado = perBuss.actualizar(persona);
        if(estadoGuardado){
            JOptionPane.showMessageDialog(this, "Persona actualizada");
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar la Persona");
        }
    }

    public void apagarCamara(){
        webcam.close();
    }
    
    public void encenderCamara(){
        if(webcam == null){
            webcam = Webcam.getDefault();
            webcam.setViewSize(webcam.getViewSizes()[0]);
            panel = new WebcamPanel(webcam, false);
            panel.setPreferredSize(webcam.getViewSize());
            panel.setOpaque(true);
            panel.setBackground(Color.BLACK);
            panel.setBounds(0, 0, 400, 300);
            jPCamera.add(panel);
            if (initialized.compareAndSet(false, true)) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        panel.start();
                    }
                });
            }
        }else{
            webcam.open();
            panel.start();
        }
    }
    
    private void loadImageGuardada(String name) {
        System.out.println(name);
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

        jLabel1 = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFCedula = new javax.swing.JTextField();
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
        jLFoto = new javax.swing.JLabel();
        jBTomarFoto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rSDCFechaNacimiento = new rojeru_san.componentes.RSDateChooser();
        jBEncenderCam = new javax.swing.JButton();
        jBApagarCam = new javax.swing.JButton();
        jPCamera = new javax.swing.JPanel();
        jCBTipoPersona = new javax.swing.JComboBox<TipoPersona>();
        jLabel2 = new javax.swing.JLabel();
        jBActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 130, 17));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Cédula:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jTFCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(jTFCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 270, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Teléfono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Dirección:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 80, -1));
        getContentPane().add(jTFTele, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 270, -1));

        JTADirecc.setColumns(20);
        JTADirecc.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        JTADirecc.setLineWrap(true);
        JTADirecc.setRows(5);
        jScrollPane3.setViewportView(JTADirecc);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 270, 100));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nombre:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 270, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Apellido:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jTFApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFApellidoActionPerformed(evt);
            }
        });
        getContentPane().add(jTFApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 270, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Email:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));

        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });
        getContentPane().add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 270, -1));

        jLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 400, 300));

        jBTomarFoto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBTomarFoto.setText("Tomar Foto");
        jBTomarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTomarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(jBTomarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Fecha");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 50, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nacimiento");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 80, -1));

        rSDCFechaNacimiento.setBackground(java.awt.SystemColor.control);
        rSDCFechaNacimiento.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDCFechaNacimiento.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDCFechaNacimiento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rSDCFechaNacimiento.setFormatoFecha("dd/MM/yyyy");
        rSDCFechaNacimiento.setFuente(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rSDCFechaNacimiento.setPlaceholder("");
        getContentPane().add(rSDCFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 270, -1));

        jBEncenderCam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBEncenderCam.setText("Encender Cámara");
        jBEncenderCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEncenderCamActionPerformed(evt);
            }
        });
        getContentPane().add(jBEncenderCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        jBApagarCam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBApagarCam.setText("Apagar Cámara");
        jBApagarCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApagarCamActionPerformed(evt);
            }
        });
        getContentPane().add(jBApagarCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, -1, -1));

        jPCamera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPCamera.setLayout(new java.awt.GridLayout());
        getContentPane().add(jPCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 400, 300));

        getContentPane().add(jCBTipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 270, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tipo Persona:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jBActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jBActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCedulaActionPerformed

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jTFApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFApellidoActionPerformed

    private void jTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailActionPerformed

    private void jBTomarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTomarFotoActionPerformed
        // TODO add your handling code here:
        try {
            if(jTFCedula.getText().equals("")){
                JOptionPane.showMessageDialog(jTFCedula, "Debe ingresar primero la cédula");
            }else{
                BufferedImage image = webcam.getImage();
                //nombre y formato de la imagen de salida
                ImageIO.write(image, "PNG", new File(System.getProperty("user.dir") + "/media/persona/" +jTFCedula.getText()+".png"));
                loadImageGuardada(jTFCedula.getText()+".png");
                webcam.close();
            }

        } catch (IOException ex) {

        }
    }//GEN-LAST:event_jBTomarFotoActionPerformed
    
    private void jBEncenderCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEncenderCamActionPerformed
        // TODO add your handling code here:
        encenderCamara();
    }//GEN-LAST:event_jBEncenderCamActionPerformed

    private void jBApagarCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApagarCamActionPerformed
        // TODO add your handling code here:
        apagarCamara();
    }//GEN-LAST:event_jBApagarCamActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_jBActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTADirecc;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBApagarCam;
    private javax.swing.JButton jBEncenderCam;
    private javax.swing.JButton jBTomarFoto;
    private javax.swing.JComboBox<TipoPersona> jCBTipoPersona;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPCamera;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFCedula;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFTele;
    private rojeru_san.componentes.RSDateChooser rSDCFechaNacimiento;
    // End of variables declaration//GEN-END:variables
}
