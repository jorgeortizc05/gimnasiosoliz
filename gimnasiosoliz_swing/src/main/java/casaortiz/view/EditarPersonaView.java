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
import com.github.sarxos.webcam.WebcamException;
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
        loadTipoPersonas();
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
    
    public void loadTipoPersonas(){
        List<TipoPersona> items = tpBuss.getTipoPersonas();
        for(TipoPersona tp: items){
           jCBTipoPersona.addItem(tp);
        }
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
        try {
            if(webcam != null){
                webcam.close();
            }
            
        } catch (WebcamException e) {
            System.out.println("No esta encendida la camara: "+e.getMessage());
        }
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
        java.awt.GridBagConstraints gridBagConstraints;

        jBTomarFoto = new javax.swing.JButton();
        jBEncenderCam = new javax.swing.JButton();
        jLFoto = new javax.swing.JLabel();
        jPCamera = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTFCedula = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTFApellido = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFTele = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        rSDCFechaNacimiento = new rojeru_san.componentes.RSDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTADirecc = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jCBTipoPersona = new javax.swing.JComboBox<TipoPersona>();
        jBActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0, 5, 0};
        layout.rowHeights = new int[] {0};
        getContentPane().setLayout(layout);

        jBTomarFoto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBTomarFoto.setText("Tomar Foto");
        jBTomarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTomarFotoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 155, 43, 0);
        getContentPane().add(jBTomarFoto, gridBagConstraints);

        jBEncenderCam.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBEncenderCam.setText("Encender Cámara");
        jBEncenderCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEncenderCamActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 43, 0);
        getContentPane().add(jBEncenderCam, gridBagConstraints);

        jLFoto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jLFoto.setPreferredSize(new java.awt.Dimension(400, 300));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLFoto, gridBagConstraints);

        jPCamera.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Cámara", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPCamera.setPreferredSize(new java.awt.Dimension(400, 300));
        jPCamera.setLayout(new java.awt.CardLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jPCamera, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 11))); // NOI18N
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("ID:");
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel19.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel19, gridBagConstraints);

        jLID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLID.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLID, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel13.setText("Cédula:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel13, gridBagConstraints);

        jTFCedula.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jTFCedula, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel12.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel12, gridBagConstraints);

        jTFNombre.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jTFNombre, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel18.setText("Apellido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel18, gridBagConstraints);

        jTFApellido.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jTFApellido, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel16.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel16, gridBagConstraints);

        jTFEmail.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jTFEmail, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel8.setText("Teléfono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel8, gridBagConstraints);

        jTFTele.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jTFTele, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel17.setText("Fecha Nacimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel17, gridBagConstraints);

        rSDCFechaNacimiento.setBackground(java.awt.SystemColor.control);
        rSDCFechaNacimiento.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDCFechaNacimiento.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDCFechaNacimiento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rSDCFechaNacimiento.setFormatoFecha("dd/MM/yyyy");
        rSDCFechaNacimiento.setFuente(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rSDCFechaNacimiento.setPlaceholder("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(rSDCFechaNacimiento, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel15.setText("Dirección:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel15, gridBagConstraints);

        JTADirecc.setColumns(20);
        JTADirecc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JTADirecc.setLineWrap(true);
        JTADirecc.setRows(5);
        jScrollPane4.setViewportView(JTADirecc);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jScrollPane4, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel14.setText("Tipo Cliente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel14, gridBagConstraints);

        jCBTipoPersona.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jCBTipoPersona, gridBagConstraints);

        jBActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BELOW_BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jBActualizar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        apagarCamara();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTADirecc;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBEncenderCam;
    private javax.swing.JButton jBTomarFoto;
    private javax.swing.JComboBox<TipoPersona> jCBTipoPersona;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPCamera;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFCedula;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFTele;
    private rojeru_san.componentes.RSDateChooser rSDCFechaNacimiento;
    // End of variables declaration//GEN-END:variables
}
