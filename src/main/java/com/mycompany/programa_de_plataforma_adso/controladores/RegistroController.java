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
        
        // Limpiamos los JLabel de error por si el usuario está corrigiendo un error anterior
        vistaRegistro.getLbl_errorDocumento().setText("");
        vistaRegistro.getLbl_errorCorreo().setText("");
        
        // Quitamos espacios en blanco al inicio y final por seguridad
        documento = documento.trim();
        correo = correo.trim();
        
        // 1. Validar que no haya campos vacíos (se usa JOptionPane para errores generales)
        if (documento.isEmpty() || nombreCompleto.trim().isEmpty() || telefono.trim().isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(vistaRegistro, "Todos los campos son obligatorios.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        boolean hayErrores = false;

        // 2. Validar que el documento no esté duplicado en la BD
        if (dao.existeDocumento(documento)) {
            vistaRegistro.getLbl_errorDocumento().setText("Este documento ya está registrado.");
            hayErrores = true;
        }

        // 3. Validar el formato estricto del correo y su unicidad
        if (!esCorreoGmailValido(correo)) {
            vistaRegistro.getLbl_errorCorreo().setText("Correo inválido. Exclusivo @gmail.com (sin espacios ni puntos raros).");
            hayErrores = true;
        } else if (dao.existeCorreo(correo)) {
            vistaRegistro.getLbl_errorCorreo().setText("Este correo ya está registrado.");
            hayErrores = true;
        }

        // Si hay algún error en los campos, detenemos el proceso aquí mismo
        if (hayErrores) {
            return;
        }
        
        // 4. Generar credenciales dinámicas
        String nuevaPassword = GeneradorCredenciales.generarPassword();
        String nuevoToken = GeneradorCredenciales.generarToken();
        
        // 5. Armar el objeto Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setDocumento(documento);
        nuevoUsuario.setNombreCompleto(nombreCompleto.trim());
        nuevoUsuario.setTelefono(telefono.trim());
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setPassword(nuevaPassword);
        nuevoUsuario.setTokenRecuperacion(nuevoToken);
        
        // 6. Enviar al DAO para guardar
        boolean exito = dao.registrarUsuario(nuevoUsuario);
        
        if (exito) {
            // Imprimir credenciales
            JOptionPane.showMessageDialog(vistaRegistro, 
                "¡Registro Exitoso!\n\n" +
                "Por favor, guarde sus credenciales de acceso:\n" +
                "Usuario (Documento): " + documento + "\n" +
                "Contraseña: " + nuevaPassword + "\n" +
                "Token de recuperación: " + nuevoToken + "\n\n" +
                "Con estas credenciales podrá ingresar a la plataforma.",
                "Credenciales Generadas",
                JOptionPane.INFORMATION_MESSAGE);
                
            // Cerrar la ventana de registro y redirigir al Login
            vistaRegistro.dispose();
            Inicio_Sesion vistaLogin = new Inicio_Sesion();
            vistaLogin.setVisible(true);
            vistaLogin.setLocationRelativeTo(null);
            
        } else {
            // Error genérico a nivel de base de datos
            JOptionPane.showMessageDialog(vistaRegistro, 
                "Ocurrió un error inesperado al intentar guardar en la base de datos.", 
                "Error Interno", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // --- MÉTODO AUXILIAR PARA VALIDAR EL CORREO EXACTO ---
    private boolean esCorreoGmailValido(String correo) {
        if (correo == null || correo.trim().isEmpty()) return false;
        
        // No debe contener espacios en ninguna posición
        if (correo.contains(" ")) return false;
        
        // Debe tener exactamente un símbolo '@'
        long countArrobas = correo.chars().filter(ch -> ch == '@').count();
        if (countArrobas != 1) return false;
        
        String[] partes = correo.split("@");
        if (partes.length != 2) return false;
        
        String local = partes[0];
        String dominio = partes[1];
        
        // Debe haber texto antes de la '@'
        if (local.isEmpty()) return false;
        
        // Rechazar puntos consecutivos o al inicio/final de la parte local
        if (local.startsWith(".") || local.endsWith(".") || local.contains("..")) return false;
        
        // El dominio debe ser exactamente "gmail.com"
        if (!dominio.equals("gmail.com")) return false;
        
        return true;
    }
}