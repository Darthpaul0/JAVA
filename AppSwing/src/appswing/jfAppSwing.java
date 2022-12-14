/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appswing;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author deifont
 */
public class jfAppSwing extends javax.swing.JFrame {

    /**
     * Creates new form jfAppSwing
     */
    public jfAppSwing() {
        initComponents();
        inicializar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSaludar = new javax.swing.JButton();
        jlMensaje = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAcciones = new javax.swing.JMenu();
        jmiSaludar = new javax.swing.JMenuItem();
        jmiNuevo = new javax.swing.JMenuItem();
        jmiInicializar = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();
        jmiAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MI primera aplicación");

        jbSaludar.setMnemonic('s');
        jbSaludar.setText("Saludar");
        jbSaludar.setToolTipText("pulsa para mostrar un mensaje");
        jbSaludar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saludarActionPerformed(evt);
            }
        });

        jlMensaje.setText("¡Hola! Bienvenido a mi aplicación con Swing");

        jtfNombre.setToolTipText("escribe tu nombre");

        jmAcciones.setMnemonic('a');
        jmAcciones.setText("Acciones");

        jmiSaludar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiSaludar.setMnemonic('s');
        jmiSaludar.setText("Saludar");
        jmiSaludar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saludarActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiSaludar);

        jmiNuevo.setText("Nuevo");
        jmiNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiNuevo);

        jmiInicializar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiInicializar.setMnemonic('i');
        jmiInicializar.setText("Inicializar");
        jmiInicializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiInicializarActionPerformed(evt);
            }
        });
        jmAcciones.add(jmiInicializar);

        jMenuBar1.add(jmAcciones);

        jmAyuda.setMnemonic('y');
        jmAyuda.setText("Ayuda");

        jmiAcercaDe.setText("Acerca de");
        jmiAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAcercaDeActionPerformed(evt);
            }
        });
        jmAyuda.add(jmiAcercaDe);

        jMenuBar1.add(jmAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlMensaje)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSaludar)
                        .addGap(18, 18, 18)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSaludar)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlMensaje)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saludarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saludarActionPerformed
        jlMensaje.setText("¡Hola "+jtfNombre.getText()+"! Bienvenido a mi aplicación Swing");
        jlMensaje.setVisible(true);
    }//GEN-LAST:event_saludarActionPerformed

    private void jmiInicializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiInicializarActionPerformed
        inicializar();
    }//GEN-LAST:event_jmiInicializarActionPerformed

    private void jmiAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAcercaDeActionPerformed
       String mensaje = "Aplicación con Java Swing\nAutor: José Luis Berenguel\n(c) 2021";
       String titulo = "Información de la aplicación";
       JOptionPane.showMessageDialog(rootPane, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmiAcercaDeActionPerformed

    private void jmiNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoActionPerformed
       jdNuevoUsuario nuevo = new jdNuevoUsuario(this,true);
       nuevo.setVisible(true);
       if(nuevo.haPulsadoAceptar()){
           jtfNombre.setText(nuevo.getNombre());
       }
    }//GEN-LAST:event_jmiNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(jfAppSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfAppSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfAppSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfAppSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfAppSwing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jbSaludar;
    private javax.swing.JLabel jlMensaje;
    private javax.swing.JMenu jmAcciones;
    private javax.swing.JMenu jmAyuda;
    private javax.swing.JMenuItem jmiAcercaDe;
    private javax.swing.JMenuItem jmiInicializar;
    private javax.swing.JMenuItem jmiNuevo;
    private javax.swing.JMenuItem jmiSaludar;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {
        jlMensaje.setVisible(false);
        jtfNombre.setText("");
    }
}
