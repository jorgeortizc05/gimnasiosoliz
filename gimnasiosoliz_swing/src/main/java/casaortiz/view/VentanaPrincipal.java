/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jorge
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private ProductoView pv = new ProductoView();
    private CantonView cv = new CantonView();
    private EmpresaView ev = new EmpresaView();
    private FormaPagoView fpv = new FormaPagoView();
    private TipoComprobanteView tcv = new TipoComprobanteView();
    private TipoPersonaView tpv = new TipoPersonaView();
    
    private TipoSuscripcionView tsv = new TipoSuscripcionView();
    private SuscripcionView sv = new SuscripcionView();
    private VerificarSuscripcionView vsv = new VerificarSuscripcionView();
    private ProductoCatalogoView pcv = new ProductoCatalogoView();
    public VentanaPrincipal() {
        initComponents();
        this.setLayout(new FlowLayout());
        this.add(vsv, BorderLayout.CENTER);
        this.pack();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMIVerificarSuscripcion = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMICantones = new javax.swing.JMenuItem();
        jMIEmpresa = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMIPersonas = new javax.swing.JMenuItem();
        jMITipoPersona = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        JMIProductos = new javax.swing.JMenuItem();
        jMICatalogo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gimnasio Soliz");
        setBackground(java.awt.Color.white);
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1280, 760));

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(175, 28));

        jMenu4.setText("Control de Acceso");
        jMenu4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMIVerificarSuscripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMIVerificarSuscripcion.setText("Verificar Suscripción");
        jMIVerificarSuscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIVerificarSuscripcionActionPerformed(evt);
            }
        });
        jMenu4.add(jMIVerificarSuscripcion);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("Empresa");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMICantones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMICantones.setText("Cantones");
        jMICantones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICantonesActionPerformed(evt);
            }
        });
        jMenu1.add(jMICantones);

        jMIEmpresa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMIEmpresa.setText("Empresa");
        jMIEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEmpresaActionPerformed(evt);
            }
        });
        jMenu1.add(jMIEmpresa);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMIPersonas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMIPersonas.setText("Clientes");
        jMIPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPersonasActionPerformed(evt);
            }
        });
        jMenu2.add(jMIPersonas);

        jMITipoPersona.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMITipoPersona.setText("Tipos de Clientes");
        jMITipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMITipoPersonaActionPerformed(evt);
            }
        });
        jMenu2.add(jMITipoPersona);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Inventarios");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        JMIProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JMIProductos.setText("Productos");
        JMIProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProductosActionPerformed(evt);
            }
        });
        jMenu5.add(JMIProductos);

        jMICatalogo.setText("Catalogo");
        jMICatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICatalogoActionPerformed(evt);
            }
        });
        jMenu5.add(jMICatalogo);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProductosActionPerformed
        // TODO add your handling code here:
        vaciarVentana();
        pv = new ProductoView();
        
        this.add(pv, BorderLayout.CENTER);
        this.pack();
    }//GEN-LAST:event_JMIProductosActionPerformed

    private void jMICantonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICantonesActionPerformed
        // TODO add your handling code here:
        vaciarVentana();
        cv = new CantonView();
        this.add(cv, BorderLayout.CENTER);
        this.pack();
    }//GEN-LAST:event_jMICantonesActionPerformed

    private void jMIEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEmpresaActionPerformed
        // TODO add your handling code here:
        vaciarVentana();
        ev = new EmpresaView();
        this.add(ev, BorderLayout.CENTER);
        this.pack();
    }//GEN-LAST:event_jMIEmpresaActionPerformed

    private void jMITipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITipoPersonaActionPerformed
        // TODO add your handling code here:
        vaciarVentana();
        tpv = new TipoPersonaView();
        this.add(tpv, BorderLayout.CENTER);
        this.pack();
    }//GEN-LAST:event_jMITipoPersonaActionPerformed

    private void jMIPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPersonasActionPerformed
        // TODO add your handling code here:
        
        PersonaViewJFrame perv = new PersonaViewJFrame();
        perv.setLocationRelativeTo(null);
        perv.setVisible(true);
    }//GEN-LAST:event_jMIPersonasActionPerformed

    private void jMIVerificarSuscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIVerificarSuscripcionActionPerformed
        // TODO add your handling code here:
        vaciarVentana();
        vsv = new VerificarSuscripcionView();
        this.add(vsv, BorderLayout.CENTER);
        this.pack();
    }//GEN-LAST:event_jMIVerificarSuscripcionActionPerformed

    private void jMICatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICatalogoActionPerformed
        // TODO add your handling code here:
        vaciarVentana();
        pcv = new ProductoCatalogoView();
        this.add(pcv, BorderLayout.CENTER);
        this.pack();
    }//GEN-LAST:event_jMICatalogoActionPerformed

    public void vaciarVentana(){
        
        this.remove(pv);
        this.remove(cv);
        this.remove(ev);
        this.remove(fpv);
        this.remove(tcv);
        this.remove(tpv);
        this.remove(tsv);
        this.remove(sv);
        this.remove(vsv);
        this.remove(pcv);
        
        
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                        // Set cross-platform Java L&F (also called "Metal")
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (UnsupportedLookAndFeelException e) {
                   // handle exception
                }
                catch (ClassNotFoundException e) {
                   // handle exception
                }
                catch (InstantiationException e) {
                   // handle exception
                }
                catch (IllegalAccessException e) {
                   // handle exception
                }
                VentanaPrincipal v = new VentanaPrincipal();
                v.setSize(1366,768);
                v.setLocationRelativeTo(null); //para que aparezca la ventana en el centro                
                v.setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMIProductos;
    private javax.swing.JMenuItem jMICantones;
    private javax.swing.JMenuItem jMICatalogo;
    private javax.swing.JMenuItem jMIEmpresa;
    private javax.swing.JMenuItem jMIPersonas;
    private javax.swing.JMenuItem jMITipoPersona;
    private javax.swing.JMenuItem jMIVerificarSuscripcion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
