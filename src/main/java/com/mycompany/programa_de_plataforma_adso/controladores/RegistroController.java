package com.mycompany.programa_de_plataforma_adso.controladores;

import com.mycompany.programa_de_plataforma_adso.dao.UsuarioDAO;
import com.mycompany.programa_de_plataforma_adso.modelos.Usuario;
import com.mycompany.programa_de_plataforma_adso.servicios.GeneradorCredenciales;
import com.mycompany.programa_de_plataforma_adso.vistas.Inicio_Sesion;
import com.mycompany.programa_de_plataforma_adso.vistas.Registrarse;
import javax.swing.JOptionPane;

public class RegistroController {
    
    private Registrarse vistaRegistro;
    private UsuarioDAO dao;

    public RegistroController(Registrarse vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
        this.dao = new UsuarioDAO();
    }
    
    public void registrarNuevoUsuario(String documento, String nombreCompleto, String telefono, String correo) {
        
        // 1. Validar que no haya campos vacíos
        if (documento.isEmpty() || nombreCompleto.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            // Aquí puedes usar un JOptionPane o un JLabel si tienes uno en esta vista
            JOptionPane.showMessageDialog(vistaRegistro, "Todos los campos son obligatorios.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 2. Generar credenciales dinámicas
        String nuevaPassword = GeneradorCredenciales.generarPassword();
        String nuevoToken = GeneradorCredenciales.generarToken();
        
        // 3. Armar el objeto Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setDocumento(documento);
        nuevoUsuario.setNombreCompleto(nombreCompleto);
        nuevoUsuario.setTelefono(telefono);
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setPassword(nuevaPassword);
        nuevoUsuario.setTokenRecuperacion(nuevoToken);
        
        // 4. Enviar al DAO para guardar
        boolean exito = dao.registrarUsuario(nuevoUsuario);
        
        if (exito) {
            // 5. Imprimir credenciales (Requisito del PDF: el usuario debe verlas para copiarlas)
            JOptionPane.showMessageDialog(vistaRegistro, 
                "¡Registro Exitoso!\n\n" +
                "Por favor, guarde sus credenciales de acceso:\n" +
                "Usuario (Documento): " + documento + "\n" +
                "Contraseña: " + nuevaPassword + "\n" +
                "Token de recuperación: " + nuevoToken + "\n\n" +
                "Con estas credenciales podrá ingresar a la plataforma.",
                "Credenciales Generadas",
                JOptionPane.INFORMATION_MESSAGE);
                
            // Opcional: Cerrar la ventana de registro después del éxito
            vistaRegistro.dispose();
            // Redirigimos al Login de forma limpia
            Inicio_Sesion vistaLogin = new Inicio_Sesion();
            vistaLogin.setVisible(true);
            vistaLogin.setLocationRelativeTo(null);
            
        } else {
            JOptionPane.showMessageDialog(vistaRegistro, 
                "Error al registrar. Es posible que el documento ya exista en el sistema.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}