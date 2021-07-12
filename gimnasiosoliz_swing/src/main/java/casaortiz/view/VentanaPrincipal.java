/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jorge
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private ProductoView productoView = new ProductoView();
    private CantonView cantonView = new CantonView();
    private EmpresaView empresaView = new EmpresaView();
    private FormaPagoView formaPagoView = new FormaPagoView();
    private TipoComprobanteView tipoComprobanteView = new TipoComprobanteView();
    private TipoPersonaView tipoPersonaView = new TipoPersonaView();
    private TipoSuscripcionView tipoSuscripcionView = new TipoSuscripcionView();
    private SuscripcionView suscripcionView = new SuscripcionView();
    private VerificarSuscripcionView verificarSuscripcionView = new VerificarSuscripcionView(this);
    private ProductoCatalogoView productoCatalogoView = new ProductoCatalogoView();
    private CategoriaView categoriaView = new CategoriaView();
    public VentanaPrincipal() {
        initComponents();
        /*this.setLayout(new FlowLayout());
        this.add(vsv, BorderLayout.CENTER);
        this.pack();*/
        JTPContenedor.add(verificarSuscripcionView);
        JTPContenedor.add(productoView);
        JTPContenedor.add(cantonView);
        JTPContenedor.add(empresaView);
        JTPContenedor.add(formaPagoView);
        JTPContenedor.add(tipoComprobanteView);
        JTPContenedor.add(tipoPersonaView);
        JTPContenedor.add(tipoSuscripcionView);
        JTPContenedor.add(suscripcionView);
        JTPContenedor.add(productoCatalogoView);
        JTPContenedor.add(categoriaView);
        JTPContenedor.add(formaPagoView);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTPContenedor = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMCaja = new javax.swing.JMenu();
        jMIFormaPago = new javax.swing.JMenuItem();
        jMITipoComprobante = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMITipoSuscripcion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gimnasio Soliz");
        setBackground(java.awt.Color.white);
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1280, 760));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.CardLayout());

        JTPContenedor.setBackground(new java.awt.Color(139, 0, 0));
        JTPContenedor.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jPanel1.add(JTPContenedor, "card2");

        getContentPane().add(jPanel1, "card2");

        jMenuBar1.setBackground(java.awt.Color.white);
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(175, 60));

        jMenu6.setIcon(new javax.swing.ImageIcon("C:\\casaortiz\\gimnasiosoliz\\gimnasiosoliz_swing\\media\\gimnasio\\logo_mini50.png")); // NOI18N
        jMenu6.setMaximumSize(new java.awt.Dimension(80, 160));
        jMenu6.setPreferredSize(new java.awt.Dimension(80, 50));
        jMenuBar1.add(jMenu6);

        jMenu4.setBackground(new java.awt.Color(255, 255, 255));
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

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
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

        jMenu2.setBackground(new java.awt.Color(255, 255, 255));
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

        jMenu5.setBackground(new java.awt.Color(255, 255, 255));
        jMenu5.setForeground(java.awt.Color.darkGray);
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

        jMICatalogo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMICatalogo.setText("Catalogo");
        jMICatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICatalogoActionPerformed(evt);
            }
        });
        jMenu5.add(jMICatalogo);

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem1.setText("Categoría");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        jMCaja.setBackground(new java.awt.Color(255, 255, 255));
        jMCaja.setForeground(java.awt.Color.darkGray);
        jMCaja.setText("Caja");
        jMCaja.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMIFormaPago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMIFormaPago.setText("Forma de Pago");
        jMIFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFormaPagoActionPerformed(evt);
            }
        });
        jMCaja.add(jMIFormaPago);

        jMITipoComprobante.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMITipoComprobante.setText("Tipo de Comprobantes");
        jMITipoComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMITipoComprobanteActionPerformed(evt);
            }
        });
        jMCaja.add(jMITipoComprobante);

        jMenuBar1.add(jMCaja);

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setForeground(java.awt.Color.darkGray);
        jMenu3.setText("Suscripción");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMITipoSuscripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMITipoSuscripcion.setText("Tipo de Suscripción");
        jMITipoSuscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMITipoSuscripcionActionPerformed(evt);
            }
        });
        jMenu3.add(jMITipoSuscripcion);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProductosActionPerformed
        // TODO add your handling code here:
        
        productoView.newProducto();
        JTPContenedor.setSelectedComponent(productoView);
    }//GEN-LAST:event_JMIProductosActionPerformed

    private void jMICantonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICantonesActionPerformed
        // TODO add your handling code here:
        JTPContenedor.setSelectedComponent(cantonView);
    }//GEN-LAST:event_jMICantonesActionPerformed

    private void jMIEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEmpresaActionPerformed
        // TODO add your handling code here:
        JTPContenedor.setSelectedComponent(empresaView);
    }//GEN-LAST:event_jMIEmpresaActionPerformed

    private void jMITipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITipoPersonaActionPerformed
        // TODO add your handling code here:
        JTPContenedor.setSelectedComponent(tipoPersonaView);
    }//GEN-LAST:event_jMITipoPersonaActionPerformed

    private void jMIPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPersonasActionPerformed
        // TODO add your handling code here:
        
        PersonaViewJFrame perv = new PersonaViewJFrame();
        perv.setLocationRelativeTo(null);
        perv.setVisible(true);
    }//GEN-LAST:event_jMIPersonasActionPerformed

    private void jMIVerificarSuscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIVerificarSuscripcionActionPerformed
        // TODO add your handling code here:
       JTPContenedor.setSelectedComponent(verificarSuscripcionView);
    }//GEN-LAST:event_jMIVerificarSuscripcionActionPerformed

    private void jMICatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICatalogoActionPerformed
        // TODO add your handling code here:
        JTPContenedor.setSelectedComponent(productoCatalogoView);
    }//GEN-LAST:event_jMICatalogoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JTPContenedor.setSelectedComponent(categoriaView);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMIFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFormaPagoActionPerformed
        // TODO add your handling code here:
        JTPContenedor.setSelectedComponent(formaPagoView);
    }//GEN-LAST:event_jMIFormaPagoActionPerformed

    private void jMITipoSuscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITipoSuscripcionActionPerformed
        // TODO add your handling code here:
        JTPContenedor.setSelectedComponent(tipoSuscripcionView);
    }//GEN-LAST:event_jMITipoSuscripcionActionPerformed

    private void jMITipoComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITipoComprobanteActionPerformed
        // TODO add your handling code here:
        JTPContenedor.setSelectedComponent(tipoComprobanteView);
    }//GEN-LAST:event_jMITipoComprobanteActionPerformed

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
                /*try {
                        // Set cross-platform Java L&F (also called "Metal")
                    UIManager.setLookAndFeel(new FastLookAndFeel());
                } 
                catch (UnsupportedLookAndFeelException e) {
                   // handle exception
                }*/
                
                VentanaPrincipal v = new VentanaPrincipal();
                ImageIcon img = new ImageIcon("media/gimnasio/logo_mini.png");
                v.setSize(1366,768);
                v.setIconImage(img.getImage());
                v.setLocationRelativeTo(null); //para que aparezca la ventana en el centro            
                v.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMIProductos;
    private javax.swing.JTabbedPane JTPContenedor;
    private javax.swing.JMenu jMCaja;
    private javax.swing.JMenuItem jMICantones;
    private javax.swing.JMenuItem jMICatalogo;
    private javax.swing.JMenuItem jMIEmpresa;
    private javax.swing.JMenuItem jMIFormaPago;
    private javax.swing.JMenuItem jMIPersonas;
    private javax.swing.JMenuItem jMITipoComprobante;
    private javax.swing.JMenuItem jMITipoPersona;
    private javax.swing.JMenuItem jMITipoSuscripcion;
    private javax.swing.JMenuItem jMIVerificarSuscripcion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
