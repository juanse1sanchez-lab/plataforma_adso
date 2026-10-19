
package com.mycompany.programa_de_plataforma_adso.vistas;


import javax.swing.JPanel;
import com.mycompany.programa_de_plataforma_adso.vistas.Inicio_Sesion;
import javax.swing.JOptionPane;

/**
 *
 * @author juans
 */
public class DashboardAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashboardAdmin.class.getName());

    /**
     * Creates new form DashboardAdmin
     */
    public DashboardAdmin() {
        initComponents();
    }
    
        // Importa JPanel arriba si NetBeans te lo pide: import javax.swing.JPanel;
    // Importa BorderLayout: import java.awt.BorderLayout;

    public void mostrarPanel(JPanel panelNuevo) {
        // Ajustamos el tamaño y la posición del nuevo panel
        panelNuevo.setSize(pnl_contenedor.getWidth(), pnl_contenedor.getHeight());
        panelNuevo.setLocation(0, 0);
        
        // Limpiamos el contenedor actual
        pnl_contenedor.removeAll();
        
        // Añadimos el nuevo panel al centro
        pnl_contenedor.add(panelNuevo, java.awt.BorderLayout.CENTER);
        
        // Actualizamos la vista para que los cambios se dibujen en pantalla
        pnl_contenedor.revalidate();
        pnl_contenedor.repaint();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_menulateral = new javax.swing.JPanel();
        btn_inicio = new javax.swing.JButton();
        btn_usuarios = new javax.swing.JButton();
        lbl_titulomenu = new javax.swing.JLabel();
        btn_peliculas = new javax.swing.JButton();
        btn_cerrarsesion = new javax.swing.JButton();
        btn_solicitudes = new javax.swing.JButton();
        pnl_contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_menulateral.setBackground(new java.awt.Color(30, 40, 50));

        btn_inicio.setText("Inicio / General");
        btn_inicio.setContentAreaFilled(false);

        btn_usuarios.setText("Gestion de Usuarios");
        btn_usuarios.setContentAreaFilled(false);
        btn_usuarios.addActionListener(this::btn_usuariosActionPerformed);

        lbl_titulomenu.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lbl_titulomenu.setText("PLATAFORMA ADSO");

        btn_peliculas.setText("Catálogo de Películas");
        btn_peliculas.setContentAreaFilled(false);
        btn_peliculas.addActionListener(this::btn_peliculasActionPerformed);

        btn_cerrarsesion.setText("Cerrar Sesion");
        btn_cerrarsesion.setContentAreaFilled(false);
        btn_cerrarsesion.addActionListener(this::btn_cerrarsesionActionPerformed);

        btn_solicitudes.setText("Solicitudes");
        btn_solicitudes.addActionListener(this::btn_solicitudesActionPerformed);

        javax.swing.GroupLayout pnl_menulateralLayout = new javax.swing.GroupLayout(pnl_menulateral);
        pnl_menulateral.setLayout(pnl_menulateralLayout);
        pnl_menulateralLayout.setHorizontalGroup(
            pnl_menulateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menulateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulomenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_menulateralLayout.createSequentialGroup()
                .addGroup(pnl_menulateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_inicio)
                    .addComponent(btn_usuarios)
                    .addComponent(btn_peliculas)
                    .addComponent(btn_cerrarsesion)
                    .addComponent(btn_solicitudes))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        pnl_menulateralLayout.setVerticalGroup(
            pnl_menulateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menulateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulomenu)
                .addGap(40, 40, 40)
                .addComponent(btn_inicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_usuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_peliculas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_solicitudes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btn_cerrarsesion)
                .addGap(14, 14, 14))
        );

        pnl_contenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_menulateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_menulateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuariosActionPerformed
                                                        
        PanelUsuarios vistaUsuarios = new PanelUsuarios();
        mostrarPanel(vistaUsuarios);
    
    }//GEN-LAST:event_btn_usuariosActionPerformed

    private void btn_peliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_peliculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_peliculasActionPerformed

    private void btn_cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarsesionActionPerformed
       // 1. Preguntamos al usuario si realmente desea salir
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea cerrar sesión?",
                "Cerrar Sesión",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        // 2. Si responde que "Sí" (YES_OPTION)
        if (confirmacion == JOptionPane.YES_OPTION) {
            
            // Cerramos la ventana actual del Dashboard
            this.dispose();

            // Abrimos nuevamente la ventana de Login limpia y centrada
            Inicio_Sesion vistaLogin = new Inicio_Sesion();
            vistaLogin.setVisible(true);
            vistaLogin.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btn_cerrarsesionActionPerformed

    private void btn_solicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_solicitudesActionPerformed
        PanelSolicitudes vistaSolicitudes = new PanelSolicitudes();
        mostrarPanel(vistaSolicitudes);
    }//GEN-LAST:event_btn_solicitudesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrarsesion;
    private javax.swing.JButton btn_inicio;
    private javax.swing.JButton btn_peliculas;
    private javax.swing.JButton btn_solicitudes;
    private javax.swing.JButton btn_usuarios;
    private javax.swing.JLabel lbl_titulomenu;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JPanel pnl_menulateral;
    // End of variables declaration//GEN-END:variables
}
