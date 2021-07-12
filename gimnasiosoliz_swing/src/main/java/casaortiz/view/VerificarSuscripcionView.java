/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.PersonaBuss;
import casaortiz.buss.SuscripcionBuss;
import casaortiz.db.Conector;
import casaortiz.model.Persona;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jorge
 */
public class VerificarSuscripcionView extends javax.swing.JPanel {

    private PersonaBuss perBuss;
    private Persona persona;
    
    private SuscripcionBuss susBuss;
    private boolean hayPersona = false;
    VentanaPrincipal vp;
    public VerificarSuscripcionView(VentanaPrincipal vp) {
        initComponents();
        this.vp = vp;
        perBuss = new PersonaBuss();
        susBuss = new SuscripcionBuss();
    }
    
    public void buscarPersonaPorCedula(String cedula){
        persona = perBuss.buscarPersonaPorCedula(cedula);
        if (persona.getId() == 0){
            JOptionPane.showMessageDialog(jLNombres, "No existe esta persona");
            hayPersona = false;
        }else{
            jLNombres.setText(persona.getNombre()+' '+persona.getApellido());
            loadImageGuardada(persona.getFoto());
            hayPersona = true;
        }
    }
    
    public void vaciarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTListaPersonas.getModel();
        modelo.setRowCount(0);
        jTListaPersonas.setModel(modelo);
    }
    
    public void vaciarCamposBusqueda(){
        jTFBusqueda.setText("");
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
        try {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jTFBusqueda, persona.getNombre()+" no dispone de suscripciones");
            jLMensajeAdvertencia.setText("RENOVAR SUSCRIPCIÓN");
            jLMensajeAdvertencia.setForeground(Color.red);
            jLDiasRestantes.setText(0+"");
            jLDiasRestantes.setForeground(Color.red);
        }
        
    }
    
    public void generarTarjetaGimnasio(Persona persona){
        String ubicacionJrxml = "src/main/resources/tarjetaGimnasioPersona.jrxml";
        Conector conector = new Conector();
        Connection connect = null;
        try {
            // TODO add your handling code here:
            if(persona == null){
                JOptionPane.showMessageDialog(jTFBusqCedula, "Primero debes cargar el cliente");
            }else{
                JasperReport reporte;
                connect = conector.getConexion();
                Map<String, Object> parametros = new HashMap<String, Object>();
                parametros.put("pv_cedula", persona.getCedula());
                parametros.put("pv_nombres", persona.getNombre()+" "+persona.getApellido());

                reporte = JasperCompileManager.compileReport(ubicacionJrxml);
                JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, connect);
                JasperViewer.viewReport(jp, false);
                conector.close(connect);
            }
        } catch (JRException ex) {
            Logger.getLogger(VerificarSuscripcionView.class.getName()).log(Level.SEVERE, null, ex);
            conector.close(connect);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jTFBusqCedula = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPEstadoSuscripcion = new javax.swing.JPanel();
        jPFoto = new javax.swing.JPanel();
        jLFoto = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLNombres = new javax.swing.JLabel();
        jLMensajeAdvertencia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLDiasRestantes = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jBEditarPersona = new javax.swing.JButton();
        jBAgregarSuscripcion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPListaClientes = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFBusqueda = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaPersonas = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(373, 40));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jTFBusqCedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFBusqCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Código Barras"));
        jTFBusqCedula.setMinimumSize(new java.awt.Dimension(300, 20));
        jTFBusqCedula.setPreferredSize(new java.awt.Dimension(300, 19));
        jTFBusqCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFBusqCedulaKeyPressed(evt);
            }
        });
        jPanel1.add(jTFBusqCedula);

        jBBuscar.setBackground(new java.awt.Color(194, 60, 61));
        jBBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jBBuscar);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPEstadoSuscripcion.setBackground(java.awt.Color.white);
        jPEstadoSuscripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Estado de Suscripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPEstadoSuscripcion.setLayout(new javax.swing.BoxLayout(jPEstadoSuscripcion, javax.swing.BoxLayout.LINE_AXIS));

        jPFoto.setPreferredSize(new java.awt.Dimension(400, 300));
        jPFoto.setLayout(new javax.swing.BoxLayout(jPFoto, javax.swing.BoxLayout.LINE_AXIS));

        jLFoto.setBackground(new java.awt.Color(24, 23, 23));
        jLFoto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLFoto.setMaximumSize(new java.awt.Dimension(400, 300));
        jLFoto.setMinimumSize(new java.awt.Dimension(400, 300));
        jLFoto.setPreferredSize(new java.awt.Dimension(400, 300));
        jPFoto.add(jLFoto);

        jPEstadoSuscripcion.add(jPFoto);

        jPanel8.setBackground(java.awt.Color.white);
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(java.awt.Color.white);
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLNombres.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLNombres.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jLNombres.setPreferredSize(new java.awt.Dimension(700, 70));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel9.add(jLNombres, gridBagConstraints);

        jLMensajeAdvertencia.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLMensajeAdvertencia.setForeground(new java.awt.Color(255, 255, 255));
        jLMensajeAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLMensajeAdvertencia.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jLMensajeAdvertencia.setPreferredSize(new java.awt.Dimension(700, 70));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel9.add(jLMensajeAdvertencia, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Días Restantes:");
        jLabel3.setPreferredSize(new java.awt.Dimension(350, 29));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel9.add(jLabel3, gridBagConstraints);

        jLDiasRestantes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLDiasRestantes.setForeground(new java.awt.Color(255, 255, 255));
        jLDiasRestantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLDiasRestantes.setPreferredSize(new java.awt.Dimension(350, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel9.add(jLDiasRestantes, gridBagConstraints);

        jPanel8.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel10.setBackground(java.awt.Color.white);

        jBEditarPersona.setBackground(new java.awt.Color(194, 60, 61));
        jBEditarPersona.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jBEditarPersona.setForeground(java.awt.Color.white);
        jBEditarPersona.setText("Editar");
        jBEditarPersona.setPreferredSize(new java.awt.Dimension(280, 39));
        jBEditarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarPersonaActionPerformed(evt);
            }
        });
        jPanel10.add(jBEditarPersona);

        jBAgregarSuscripcion.setBackground(new java.awt.Color(194, 60, 61));
        jBAgregarSuscripcion.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jBAgregarSuscripcion.setForeground(java.awt.Color.white);
        jBAgregarSuscripcion.setText("Agregar Suscripción");
        jBAgregarSuscripcion.setPreferredSize(new java.awt.Dimension(280, 39));
        jBAgregarSuscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarSuscripcionActionPerformed(evt);
            }
        });
        jPanel10.add(jBAgregarSuscripcion);

        jButton3.setBackground(new java.awt.Color(194, 60, 61));
        jButton3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton3.setForeground(java.awt.Color.white);
        jButton3.setText("Generar Tarjeta");
        jButton3.setPreferredSize(new java.awt.Dimension(280, 39));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton3);

        jPanel8.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jPEstadoSuscripcion.add(jPanel8);

        jPanel2.add(jPEstadoSuscripcion);

        jPListaClientes.setBackground(java.awt.Color.white);
        jPListaClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Lista de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPListaClientes.setForeground(new java.awt.Color(255, 255, 255));
        jPListaClientes.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Busqueda");
        jPanel5.add(jLabel1);

        jTFBusqueda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFBusqueda.setPreferredSize(new java.awt.Dimension(200, 20));
        jTFBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusquedaKeyReleased(evt);
            }
        });
        jPanel5.add(jTFBusqueda);

        jBLimpiar.setBackground(new java.awt.Color(194, 60, 61));
        jBLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });
        jPanel5.add(jBLimpiar);

        jPListaClientes.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(java.awt.Color.white);

        jTListaPersonas.setBackground(new java.awt.Color(24, 23, 23));
        jTListaPersonas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTListaPersonas.setForeground(new java.awt.Color(255, 255, 255));
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
        jTListaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListaPersonasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTListaPersonas);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 141, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 141, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPListaClientes.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPListaClientes);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFBusqCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusqCedulaKeyPressed
        
    }//GEN-LAST:event_jTFBusqCedulaKeyPressed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        seleccionarItemTabla();
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTFBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaKeyReleased
        // TODO add your handling code here:
        loadPersonasBusqueda(perBuss.buscarPersonasPorNombre(jTFBusqueda.getText().toUpperCase()));
    }//GEN-LAST:event_jTFBusquedaKeyReleased

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        vaciarTabla();
        vaciarCamposBusqueda();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTListaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListaPersonasMouseClicked
        // TODO add your handling code here:
        seleccionarItemTabla();
    }//GEN-LAST:event_jTListaPersonasMouseClicked

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

    private void jBAgregarSuscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarSuscripcionActionPerformed
        // TODO add your handling code here:
        if(persona == null){
            JOptionPane.showMessageDialog(jTFBusqCedula, "Primero debes cargar el cliente");
        }else{
            /*SuscripcionViewJFrame vsv = new SuscripcionViewJFrame(persona);
            vsv.setLocationRelativeTo(null);
            vsv.setVisible(true);
            this.setVisible(false);*/
            SuscripcionViewJDialog jd = new SuscripcionViewJDialog(vp, true, persona);
            jd.setLocationRelativeTo(null);
            jd.setVisible(true);
        }
    }//GEN-LAST:event_jBAgregarSuscripcionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        generarTarjetaGimnasio(persona);

    }//GEN-LAST:event_jButton3ActionPerformed


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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPEstadoSuscripcion;
    private javax.swing.JPanel jPFoto;
    private javax.swing.JPanel jPListaClientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFBusqCedula;
    private javax.swing.JTextField jTFBusqueda;
    private javax.swing.JTable jTListaPersonas;
    // End of variables declaration//GEN-END:variables
}
