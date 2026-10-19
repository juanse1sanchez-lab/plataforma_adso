package com.mycompany.programa_de_plataforma_adso.controladores;

import com.mycompany.programa_de_plataforma_adso.modelos.Usuario;
import com.mycompany.programa_de_plataforma_adso.dao.UsuarioDAO;
import com.mycompany.programa_de_plataforma_adso.servicios.GeneradorCredenciales;
import com.mycompany.programa_de_plataforma_adso.vistas.DashboardAdmin;
import com.mycompany.programa_de_plataforma_adso.vistas.Inicio_Sesion;
import javax.swing.JOptionPane;

public class InicioController {
    

    // permitirSinConexion es un switch para dejar entrar o no cuando no haya conexion con la BD
    // true deja entrar sin conexion, False no
    private boolean permitirSinConexion = true; 

    public void arrancarPrograma() {
        String passwordGenerada = GeneradorCredenciales.generarPassword();
        
        Usuario admin = new Usuario();
        admin.setDocumento("admin");
        admin.setNombreCompleto("Administrador Principal");
        admin.setPassword(passwordGenerada);
        admin.setRol("Admin");
        admin.setEstadoCuenta("Premium");
        
        UsuarioDAO dao = new UsuarioDAO();
        boolean exito = dao.reiniciarSistemaYCrearAdmin(admin);
        
        if (exito) {
            // Si la Conexión es exitosa a la BD ocurrirá esto
            JOptionPane.showMessageDialog(null,                
                "Usuario Admin: " + admin.getDocumento() + "\n" +
                "Contraseña: " + passwordGenerada + "\n\n" +
                "Por favor, copie y guarde esta contraseña. No se volverá a mostrar.",
                "Credenciales de Administrador",
                JOptionPane.INFORMATION_MESSAGE);
                
            abrirVentanaLogin();
            
        } else {
            // Si la conexion con la BD falla, le preguntamos a nuestro interruptor qué hacer
            if (permitirSinConexion) {
                
                JOptionPane.showMessageDialog(null, 
                    "Actualmente No hay conexión a la base de datos.\nEl sistema se iniciará en modo desconectado.",
                    "Modo de Pruebas",
                    JOptionPane.WARNING_MESSAGE);
                   abrirVentanaLogin();

                
            } else {
                
                JOptionPane.showMessageDialog(null, 
                    "Error del sistema: No se pudo conectar a la base de datos.\nRevise su servidor MySQL.",
                    "Error de Conexión",
                    JOptionPane.ERROR_MESSAGE);
                    
                System.exit(0); // Este comando "mata" el proceso de Java y cierra todo.
            }
        }
    }
    
    // Creamos un método para abrir la ventana Logig para no repetir código
    private void abrirVentanaLogin() {
        Inicio_Sesion vistaLogin = new Inicio_Sesion();
        vistaLogin.setVisible(true);
        vistaLogin.setLocationRelativeTo(null);
    }
}