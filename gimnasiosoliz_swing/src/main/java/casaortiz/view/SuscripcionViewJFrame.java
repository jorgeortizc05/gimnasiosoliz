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
        initComponents();
        perBuss = new PersonaBuss();
        tsBuss = new TipoSuscripcionBuss();
        parBuss = new ParametroBuss();
        susBuss = new SuscripcionBuss();
        loadTipoSuscripcion();
        loadParametro();
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
    
    public void buscarPersonaPorCedula(String cedula){
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
        java.awt.GridBagConstraints gridBagConstraints;

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
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Cedula:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel2, gridBagConstraints);

        jTFBusCedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 125;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jTFBusCedula, gridBagConstraints);

        jBBuscarPersona.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBBuscarPersona.setText("Buscar");
        jBBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarPersonaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jBBuscarPersona, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Nombres:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLNombres, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLDiasDisponibles, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Días Disponibles:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel13, gridBagConstraints);

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 980, 70));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Suscripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 5, 0, 5, 0};
        jPanel2Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("No. Recibo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLNoRecibo, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Tipo Suscripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel7, gridBagConstraints);

        jCBTipoSuscripcion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCBTipoSuscripcion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBTipoSuscripcionItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jCBTipoSuscripcion, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Fecha Desde:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Fecha Hasta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(rsDCFechaDesde, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(rsDCFechaHasta, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Importe Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel10, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Descuento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel11, gridBagConstraints);

        jTFDescuento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTFDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFDescuento.setText("0.0");
        jTFDescuento.setInputVerifier(new VerificarSoloNumeros());
        jTFDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFDescuentoKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 112);
        jPanel2.add(jTFDescuento, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Observaciones:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel12, gridBagConstraints);

        jTAObservaciones.setColumns(20);
        jTAObservaciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTAObservaciones.setLineWrap(true);
        jTAObservaciones.setRows(5);
        jScrollPane2.setViewportView(jTAObservaciones);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Precio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel14, gridBagConstraints);

        jLImporteTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLImporteTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLImporteTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 112);
        jPanel2.add(jLImporteTotal, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel16, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel17, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("$");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel18, gridBagConstraints);

        jLPrecio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 112);
        jPanel2.add(jLPrecio, gridBagConstraints);

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 420, 480));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historial Suscripciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.setLayout(new java.awt.CardLayout());

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

        jPanel3.add(jScrollPane1, "card2");

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 550, 480));

        jBGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 90, -1));

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
        buscarPersonaPorCedula(jTFBusCedula.getText());
        loadSuscripcionesPorPersona();
        
    }//GEN-LAST:event_jBBuscarPersonaActionPerformed

    private void jCBTipoSuscripcionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBTipoSuscripcionItemStateChanged
        // TODO add your handling code here:
        try {
            
        
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
        } catch (Exception e) {
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
