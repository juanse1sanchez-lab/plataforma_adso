
package com.mycompany.programa_de_plataforma_adso.vistas;

import com.mycompany.programa_de_plataforma_adso.controladores.DashboardUsuarioController;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author juans
 */
public class DashboardUsuario extends javax.swing.JFrame {
    
    private DashboardUsuarioController controlador;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashboardUsuario.class.getName());

    /**
     * Creates new form DashboardUsuario
     */
    public DashboardUsuario() {
        initComponents();
    }

    public JButton getBtn_catalogo() {
        return btn_catalogo;
    }

    public JButton getBtn_cerrarSesion() {
        return btn_cerrarSesion;
    }

    public JPanel getPnl_contenedor() {
        return pnl_contenedor;
    }
    
    public void setControlador(DashboardUsuarioController controlador) {
        this.controlador = controlador;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_lateral = new javax.swing.JPanel();
        btn_catalogo = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();
        pnl_contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_catalogo.setText("Ver catálogo");
        btn_catalogo.addActionListener(this::btn_catalogoActionPerformed);

        btn_cerrarSesion.setText("Cerrar sesion");
        btn_cerrarSesion.addActionListener(this::btn_cerrarSesionActionPerformed);

        javax.swing.GroupLayout pnl_lateralLayout = new javax.swing.GroupLayout(pnl_lateral);
        pnl_lateral.setLayout(pnl_lateralLayout);
        pnl_lateralLayout.setHorizontalGroup(
            pnl_lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_lateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_catalogo)
                    .addComponent(btn_cerrarSesion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_lateralLayout.setVerticalGroup(
            pnl_lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_lateralLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_catalogo)
                .addGap(18, 18, 18)
                .addComponent(btn_cerrarSesion)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        pnl_contenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_lateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_lateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_catalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_catalogoActionPerformed
       if (controlador != null) {
            PanelCatalogo panel = new PanelCatalogo();
            controlador.mostrarPanel(panel);
        }
    }//GEN-LAST:event_btn_catalogoActionPerformed

    private void btn_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionActionPerformed
        //  Preguntamos al usuario si realmente desea salir
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea cerrar sesión?",
                "Cerrar Sesión",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        // Si responde que "Sí" (YES_OPTION)
        if (confirmacion == JOptionPane.YES_OPTION) {
            
            // Cerramos la ventana actual del Dashboard
            this.dispose();

            // Abrimos nuevamente la ventana de Login limpia y centrada
            Inicio_Sesion vistaLogin = new Inicio_Sesion();
            vistaLogin.setVisible(true);
            vistaLogin.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btn_cerrarSesionActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_catalogo;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JPanel pnl_lateral;
    // End of variables declaration//GEN-END:variables
}
