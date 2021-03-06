/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import casaortiz.buss.ParametroBuss;
import casaortiz.buss.PersonaBuss;
import casaortiz.buss.SuscripcionBuss;
import casaortiz.buss.TipoSuscripcionBuss;
import casaortiz.model.Parametro;
import casaortiz.model.Persona;
import casaortiz.model.Suscripcion;
import casaortiz.model.TipoSuscripcion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class SuscripcionViewJFrame extends javax.swing.JFrame {
    
    private PersonaBuss perBuss;
    private Persona persona;
    private List<Persona> personas;
    
    private TipoSuscripcionBuss tsBuss;
    private TipoSuscripcion tipoSuscripcion;
    
    private ParametroBuss parBuss;
    private Parametro parametro;
    
    private String pCedula;
    
    private SuscripcionBuss susBuss;
    private Suscripcion suscripcion;
       
    public SuscripcionViewJFrame(Persona item) {
        initComponents();
        perBuss = new PersonaBuss();
        tsBuss = new TipoSuscripcionBuss();
        parBuss = new ParametroBuss();
        susBuss = new SuscripcionBuss();
        persona = item;
        loadTipoSuscripcion();
        loadParametro();
        calcularImporteTotal();
        jTFBusCedula.setText(persona.getCedula());
        loadSuscripcionesPorPersona();
    }
    
    public SuscripcionViewJFrame(){
        
    }
    
    public void guardar(){
        suscripcion = new Suscripcion();
        suscripcion.setNumeroRecibo(jLNoRecibo.getText());
        suscripcion.setFechaDesde(rsDCFechaDesde.getDatoFecha());
        suscripcion.setFechaHasta(rsDCFechaHasta.getDatoFecha());
        suscripcion.setPrecio(Double.parseDouble(jLPrecio.getText()));
        suscripcion.setDescuento(Double.parseDouble(jTFDescuento.getText()));
        suscripcion.setImporteTotal(Double.parseDouble(jLImporteTotal.getText()));
        suscripcion.setObservaciones(jTAObservaciones.getText());
        suscripcion.setIdPersona(persona.getId());
        tipoSuscripcion = (TipoSuscripcion) jCBTipoSuscripcion.getSelectedItem();
        suscripcion.setIdTipoSuscripcion(tipoSuscripcion.getId());
        boolean estadoGuardado = susBuss.guardar(suscripcion);
        //Actualizo el numero de recibo
        if(estadoGuardado){
            parBuss.actualizar();
            loadSuscripcionesPorPersona();
            loadParametro();
            JOptionPane.showMessageDialog(this, "Suscripción guardada con éxito");
        }else{
            JOptionPane.showMessageDialog(this, "Error al guardar");
        }
        
    }
    
    public void eliminar(){
        int fila = jTHistorialSuscripcion.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            int id = Integer.parseInt((String)jTHistorialSuscripcion.getValueAt(fila, 0).toString());       
            int estadoEliminacionDialog = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar la suscripcion numero "+id+" del cliente "+persona.getNombre()+"?","Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(estadoEliminacionDialog == 0){
                boolean estadoEliminacion = susBuss.eliminar(id);
                if(estadoEliminacion){
                    JOptionPane.showMessageDialog(this, "Suscripcion eliminado");
                    loadSuscripcionesPorPersona();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al eliminar la suscripcion");
                }
            }
        }
    }
    
    private void calcularImporteTotal(){
        double importeTotal = Double.parseDouble(jLPrecio.getText()) - Double.parseDouble(jTFDescuento.getText());
        jLImporteTotal.setText(importeTotal+"");
    }
    
    public void buscarPersonaPorCedula(){
        persona = perBuss.buscarPersonaPorCedula(jTFBusCedula.getText());
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
    
    public void loadTipoSuscripcion(){
        List<TipoSuscripcion> items = tsBuss.getTipoSuscripciones();
        for(TipoSuscripcion i: items){
           jCBTipoSuscripcion.addItem(i);
        }
    }
    
    public void loadParametro(){
        parametro = parBuss.getParametro();
        jLNoRecibo.setText(parametro.getNumero_recibo()+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFBusCedula = new javax.swing.JTextField();
        jBBuscarPersona = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLNombres = new javax.swing.JLabel();
        jLDiasDisponibles = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLNoRecibo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCBTipoSuscripcion = new javax.swing.JComboBox<TipoSuscripcion>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rsDCFechaDesde = new rojeru_san.componentes.RSDateChooser();
        rsDCFechaHasta = new rojeru_san.componentes.RSDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFDescuento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAObservaciones = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLImporteTotal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLPrecio = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTHistorialSuscripcion = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Suscripciones");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Persona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Cedula:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, 20));

        jTFBusCedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(jTFBusCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 130, -1));

        jBBuscarPersona.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBBuscarPersona.setText("Buscar");
        jBBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(jBBuscarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Nombres:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));
        jPanel1.add(jLNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 200, 20));
        jPanel1.add(jLDiasDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 170, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Días Disponibles:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 980, 70));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Suscripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("No. Recibo:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 89, -1));
        jPanel2.add(jLNoRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 200, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Tipo Suscripción:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jCBTipoSuscripcion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCBTipoSuscripcion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBTipoSuscripcionItemStateChanged(evt);
            }
        });
        jPanel2.add(jCBTipoSuscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 230, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Fecha Desde:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Fecha Hasta:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel2.add(rsDCFechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 270, -1));
        jPanel2.add(rsDCFechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 270, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Importe Total:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Descuento:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jTFDescuento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFDescuento.setText("0.0");
        jTFDescuento.setInputVerifier(new VerificarSoloNumeros());
        jTFDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFDescuentoKeyReleased(evt);
            }
        });
        jPanel2.add(jTFDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 120, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Observaciones:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jTAObservaciones.setColumns(20);
        jTAObservaciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTAObservaciones.setLineWrap(true);
        jTAObservaciones.setRows(5);
        jScrollPane2.setViewportView(jTAObservaciones);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 240, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Precio:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLImporteTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLImporteTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLImporteTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLImporteTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 120, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("$");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("$");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("$");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, 20));

        jLPrecio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 120, 20));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 420, 480));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historial Suscripciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTHistorialSuscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha Desde", "Fecha Hasta", "Importe Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTHistorialSuscripcion);
        if (jTHistorialSuscripcion.getColumnModel().getColumnCount() > 0) {
            jTHistorialSuscripcion.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, 518, 440));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 550, 480));

        jBGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 80, -1));

        jBEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBEliminar.setText("Eliminar Suscripción");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarPersonaActionPerformed
        // TODO add your handling code here:
        //persona = null; //quito la referencia, es decir libero la memoria
        buscarPersonaPorCedula();
    }//GEN-LAST:event_jBBuscarPersonaActionPerformed

    private void jCBTipoSuscripcionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBTipoSuscripcionItemStateChanged
        // TODO add your handling code here:
        Date fechaMaxima = susBuss.getFechaMaximaPorPersona(persona.getId());
        TipoSuscripcion item = (TipoSuscripcion) jCBTipoSuscripcion.getSelectedItem();
        jLPrecio.setText(String.valueOf(item.getPrecio()));
        calcularImporteTotal();
        if(fechaMaxima == null){
            Date fechaDesde = new Date();
            rsDCFechaDesde.setDatoFecha(fechaDesde);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaDesde);
            calendar.add(Calendar.DAY_OF_YEAR, item.getNumeroDias());//sumo los dias desde la fecha de hoy
            Date fechaHasta = calendar.getTime();
            rsDCFechaHasta.setDatoFecha(fechaHasta);
        }else{
            Date fechaDesde = fechaMaxima;
            rsDCFechaDesde.setDatoFecha(fechaDesde);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaDesde);
            calendar.add(Calendar.DAY_OF_YEAR, item.getNumeroDias());//sumo los dias desde la fecha de hoy
            Date fechaHasta = calendar.getTime();
            rsDCFechaHasta.setDatoFecha(fechaHasta);
        }
       
        
        
        
    }//GEN-LAST:event_jCBTipoSuscripcionItemStateChanged

    private void jTFDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDescuentoKeyReleased
        // TODO add your handling code here:
        calcularImporteTotal();
    }//GEN-LAST:event_jTFDescuentoKeyReleased

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jBEliminarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscarPersona;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JComboBox<TipoSuscripcion> jCBTipoSuscripcion;
    private javax.swing.JLabel jLDiasDisponibles;
    private javax.swing.JLabel jLImporteTotal;
    private javax.swing.JLabel jLNoRecibo;
    private javax.swing.JLabel jLNombres;
    private javax.swing.JLabel jLPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAObservaciones;
    private javax.swing.JTextField jTFBusCedula;
    private javax.swing.JTextField jTFDescuento;
    private javax.swing.JTable jTHistorialSuscripcion;
    private rojeru_san.componentes.RSDateChooser rsDCFechaDesde;
    private rojeru_san.componentes.RSDateChooser rsDCFechaHasta;
    // End of variables declaration//GEN-END:variables
}
