package com.mycompany.programa_de_plataforma_adso.vistas;

import com.mycompany.programa_de_plataforma_adso.controladores.LoginController;
import com.mycompany.programa_de_plataforma_adso.dao.UsuarioDAO;
import com.mycompany.programa_de_plataforma_adso.servicios.GeneradorCredenciales;
import javax.swing.JOptionPane;

public class Inicio_Sesion extends javax.swing.JFrame {
    
    private String documentoEnRecuperacion = "";

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName());

    public Inicio_Sesion() {
        initComponents();
    }

    private boolean validarCampos(String usuario, String password) {

        if (usuario.isBlank()) {
            lbl_credenciales_incorrectas.setText("Ingrese un usuario.");
            return false;
        }

        if (password.isBlank()) {
            lbl_credenciales_incorrectas.setText("Ingrese una contraseña.");
            return false;
        }

        return true;
    }

    public void mostrarErrorCredenciales(String mensaje) {
        lbl_credenciales_incorrectas.setText(mensaje);
    }

    public void limpiarErrorCredenciales() {
        lbl_credenciales_incorrectas.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_inicio_sesion = new javax.swing.JLabel();
        tf_Usuario = new javax.swing.JTextField();
        lbl_Usuario = new javax.swing.JLabel();
        pf_Password = new javax.swing.JPasswordField();
        lbl_Password = new javax.swing.JLabel();
        btn_Entrar = new javax.swing.JButton();
        btn_Olv_Password = new javax.swing.JButton();
        btn_generarCredenciales = new javax.swing.JButton();
        lbl_O = new javax.swing.JLabel();
        btn_Registrarse = new javax.swing.JButton();
        lbl_credenciales_incorrectas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_inicio_sesion.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbl_inicio_sesion.setText("Inicio de sesion ");

        tf_Usuario.setForeground(new java.awt.Color(51, 51, 51));
        tf_Usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_UsuarioFocusGained(evt);
            }
        });
        tf_Usuario.addActionListener(this::tf_UsuarioActionPerformed);

        lbl_Usuario.setText("Usuario");

        pf_Password.setForeground(new java.awt.Color(51, 51, 51));

        lbl_Password.setText("Contraseña");

        btn_Entrar.setText("Entrar");
        btn_Entrar.addActionListener(this::btn_EntrarActionPerformed);

        btn_Olv_Password.setText("¿Olvidó la contraseña?");
        btn_Olv_Password.setBorder(null);
        btn_Olv_Password.addActionListener(this::btn_Olv_PasswordActionPerformed);

        btn_generarCredenciales.setText("Generar nuevas credenciales");
        btn_generarCredenciales.setBorder(null);
        btn_generarCredenciales.setEnabled(false);
        btn_generarCredenciales.addActionListener(this::btn_generarCredencialesActionPerformed);

        lbl_O.setText("o");

        btn_Registrarse.setText("Registrarse");
        btn_Registrarse.addActionListener(this::btn_RegistrarseActionPerformed);

        lbl_credenciales_incorrectas.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_generarCredenciales)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(btn_Olv_Password))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(btn_Entrar)
                                            .addGap(55, 55, 55))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(lbl_O)
                                            .addGap(89, 89, 89))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(btn_Registrarse)
                                            .addGap(42, 42, 42)))))
                            .addComponent(pf_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lbl_inicio_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbl_credenciales_incorrectas, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbl_inicio_sesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Usuario)
                .addGap(18, 18, 18)
                .addComponent(pf_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Password)
                .addGap(18, 18, 18)
                .addComponent(lbl_credenciales_incorrectas, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Entrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Olv_Password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_generarCredenciales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_O)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Registrarse)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarseActionPerformed
        Registrarse registrarse = new Registrarse();
        registrarse.setLocationRelativeTo(null);
        registrarse.setVisible(true);

        dispose();
    }//GEN-LAST:event_btn_RegistrarseActionPerformed

    private void btn_Olv_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Olv_PasswordActionPerformed
        String documento = JOptionPane.showInputDialog(this, 
            "Ingrese su número de documento:", 
            "Recuperación", 
            JOptionPane.QUESTION_MESSAGE);
            
        if (documento != null && !documento.trim().isEmpty()) {
            documento = documento.trim();
            UsuarioDAO dao = new UsuarioDAO();
            
            // 1. Verificamos si ya hay una solicitud y en qué estado está
            String[] datos = dao.verificarEstadoSolicitud(documento);
            
            if (datos != null && datos[0].equals("Pendiente")) {
                JOptionPane.showMessageDialog(this, "Su solicitud aún está pendiente de aprobación por el administrador.", "Atención", JOptionPane.WARNING_MESSAGE);
                return; // Detenemos el código aquí
            } 
            
            if (datos != null && datos[0].equals("Aprobada")) {
                // FASE 2: Aprobada. Pedimos el token original de la cuenta
                String tokenGuardado = datos[1];
                
                String tokenIngresado = JOptionPane.showInputDialog(this, 
                    "Su solicitud fue aprobada.\nIngrese el token de seguridad de su cuenta:", 
                    "Validar Token", 
                    JOptionPane.QUESTION_MESSAGE);
                
                // Validamos que el token coincida (protegido contra nulos por seguridad)
                if (tokenIngresado != null && tokenGuardado != null && tokenGuardado.equals(tokenIngresado.trim())) {
                    JOptionPane.showMessageDialog(this, "Token validado correctamente.\nHaga clic en el botón 'Generar nuevas credenciales'.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Activamos el botón final y guardamos el documento
                    btn_generarCredenciales.setEnabled(true);
                    this.documentoEnRecuperacion = documento;
                } else if (tokenIngresado != null) {
                    mostrarErrorCredenciales("El token ingresado es incorrecto.");
                }
                return; // Detenemos el código aquí
            }
            
            // FASE 1: Si no tiene solicitudes pendientes ni aprobadas, creamos una nueva
            String respuesta = dao.solicitarRecuperacionPassword(documento);
            
            if (respuesta.equals("EXITO")) {
                JOptionPane.showMessageDialog(this, "Solicitud enviada al administrador.\nSu cuenta estará inactiva hasta ser aprobada.", "Solicitud Enviada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                mostrarErrorCredenciales(respuesta);
            }
        }

    }//GEN-LAST:event_btn_Olv_PasswordActionPerformed

    private void tf_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_UsuarioActionPerformed

    }//GEN-LAST:event_tf_UsuarioActionPerformed

    private void tf_UsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_UsuarioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_UsuarioFocusGained

    private void btn_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EntrarActionPerformed
        String documento = tf_Usuario.getText();
        String password = new String(pf_Password.getPassword());

        LoginController controlador = new LoginController(this);
        controlador.iniciarSesion(documento, password);

    }//GEN-LAST:event_btn_EntrarActionPerformed

    private void btn_generarCredencialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarCredencialesActionPerformed
        if (this.documentoEnRecuperacion != null && !this.documentoEnRecuperacion.isEmpty()) {
            
            // Generamos la clave y el NUEVO token
            GeneradorCredenciales generador = new GeneradorCredenciales();
            String nuevaClave = generador.generarPassword(); 
            String nuevoToken = generador.generarToken(); 
            
            UsuarioDAO dao = new UsuarioDAO();
            
            if (dao.restablecerPasswordYToken(this.documentoEnRecuperacion, nuevaClave, nuevoToken)) {
                
                // Mensaje en texto plano y directo
                String mensaje = "Nuevas Credenciales Generadas con Éxito\n\n"
                               + "Documento: " + this.documentoEnRecuperacion + "\n"
                               + "Nueva Contraseña: " + nuevaClave + "\n"
                               + "Nuevo Token: " + nuevoToken + "\n\n"
                               + "Por favor, guarde estos datos en un lugar seguro e inicie sesión.";
                               
                JOptionPane.showMessageDialog(this, mensaje, "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
                
               
            } else {
                mostrarErrorCredenciales("Error al actualizar la base de datos.");
            }
            
            // Desactivamos el botón y limpiamos el documento
            btn_generarCredenciales.setEnabled(false);
            this.documentoEnRecuperacion = "";
        }
    }//GEN-LAST:event_btn_generarCredencialesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Entrar;
    private javax.swing.JButton btn_Olv_Password;
    private javax.swing.JButton btn_Registrarse;
    private javax.swing.JButton btn_generarCredenciales;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_O;
    private javax.swing.JLabel lbl_Password;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JLabel lbl_credenciales_incorrectas;
    private javax.swing.JLabel lbl_inicio_sesion;
    private javax.swing.JPasswordField pf_Password;
    private javax.swing.JTextField tf_Usuario;
    // End of variables declaration//GEN-END:variables
}
