package com.mycompany.programa_de_plataforma_adso.controladores;

import com.mycompany.programa_de_plataforma_adso.dao.UsuarioDAO;
import com.mycompany.programa_de_plataforma_adso.modelos.Usuario;
import com.mycompany.programa_de_plataforma_adso.vistas.DashboardAdmin;
import com.mycompany.programa_de_plataforma_adso.vistas.DashboardUsuario;
import com.mycompany.programa_de_plataforma_adso.vistas.Inicio_Sesion;
import javax.swing.JOptionPane;

public class LoginController {
    
    private Inicio_Sesion vistaLogin;
    private UsuarioDAO dao;

    public LoginController(Inicio_Sesion vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.dao = new UsuarioDAO();
    }
    
    public void iniciarSesion(String documento, String password) {

        vistaLogin.limpiarErrorCredenciales();
        

        if (documento.isEmpty()) {
            vistaLogin.mostrarErrorCredenciales("Usuario Obligatorio");
            return;
        }
        
        if (password.isEmpty()) {
            vistaLogin.mostrarErrorCredenciales("Contraseña Obligatoria");
            return;
        }
        

        Usuario usuarioActivo = dao.validarLogin(documento, password);
        
        if (usuarioActivo != null) {
            String rol = usuarioActivo.getRol();
            
            
            // 1. VALIDACIÓN DE SEGURIDAD: Comprobamos si está inactivo o en recuperación
            String estado = usuarioActivo.getEstadoCuenta();
            
            if (estado.equals("Inactivo") || estado.equals("Recuperacion")) {
                // Usamos el método de tu vista para mostrar el error en el Label rojo
                vistaLogin.mostrarErrorCredenciales("Su cuenta está inactiva por un proceso de recuperación de contraseña.");
                return; // Detenemos el flujo aquí mismo, no entra al sistema
            }
            
            
            if (rol.equals("Admin")) {
                   // Abrimos el Dashboard del Admin
                DashboardAdmin vistaAdmin = new DashboardAdmin();
                vistaAdmin.setVisible(true);
                vistaAdmin.setLocationRelativeTo(null);
                
                // Cerramos el login
                vistaLogin.dispose();
                
                
            } else if (rol.equals("Usuario")) {
                if(usuarioActivo.getEstadoCuenta().equals("Bloqueado")){
                    JOptionPane.showMessageDialog(vistaLogin, "Su periodo de prueba ha finalizado.\nDebe adquirir la plataforma digital para continuar.", "Cuenta Bloqueada", JOptionPane.WARNING_MESSAGE);
                    return; 
                }
                
                DashboardUsuario dashboardVista = new DashboardUsuario();
                DashboardUsuarioController dashboardController = new DashboardUsuarioController(dashboardVista, usuarioActivo);
                
                // Enlazamos el controlador a la vista y arrancamos
                dashboardVista.setControlador(dashboardController);
                dashboardController.iniciar();
                
            }
            
            vistaLogin.dispose();
            
        } else {
            
            vistaLogin.mostrarErrorCredenciales("Credenciales Incorrectas.");
        }
    }
}