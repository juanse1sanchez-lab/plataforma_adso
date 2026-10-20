package com.mycompany.programa_de_plataforma_adso.dao;

import com.mycompany.programa_de_plataforma_adso.modelos.Usuario;
import com.mycompany.programa_de_plataforma_adso.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    public boolean reiniciarSistemaYCrearAdmin(Usuario admin) {
        Connection con = Conexion.conectar();
        
        if (con == null) {
            System.out.println("No hay conexión a la base de datos.");
            return false;
        }
        
        try {
            String sql = "INSERT INTO usuarios (id, documento, nombre_completo, password, rol, estado_cuenta) "
                       + "VALUES (1, ?, ?, ?, ?, ?) "
                       + "ON DUPLICATE KEY UPDATE "
                       + "password = VALUES(password), "
                       + "documento = VALUES(documento), "
                       + "nombre_completo = VALUES(nombre_completo)";
                       
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, admin.getDocumento());
            ps.setString(2, admin.getNombreCompleto());
            ps.setString(3, admin.getPassword());
            ps.setString(4, admin.getRol());
            ps.setString(5, admin.getEstadoCuenta());
            
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            System.out.println("Error al configurar el administrador: " + e.getMessage());
            return false;
        }
    }
    
    public Usuario validarLogin(String documento, String password) {
        Usuario usuarioEncontrado = null;
        Connection con = Conexion.conectar();
        
        if (con == null) return null;
        
        String sql = "SELECT * FROM usuarios WHERE documento = ? AND password = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setDocumento(rs.getString("documento"));
                usuarioEncontrado.setNombreCompleto(rs.getString("nombre_completo"));
                usuarioEncontrado.setRol(rs.getString("rol"));
                usuarioEncontrado.setEstadoCuenta(rs.getString("estado_cuenta"));
            }
            
        } catch (Exception e) {
            System.out.println("Error al validar login: " + e.getMessage());
        }
        
        return usuarioEncontrado;
    }
    
    public boolean registrarUsuario(Usuario usuario) {
        Connection con = Conexion.conectar();
        if (con == null) return false;
        
        String sql = "INSERT INTO usuarios (documento, nombre_completo, telefono, correo, password, rol, token_recuperacion, estado_cuenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getDocumento());
            ps.setString(2, usuario.getNombreCompleto());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getPassword());
            ps.setString(6, "Usuario"); // Siempre se registra como 'Usuario'
            ps.setString(7, usuario.getTokenRecuperacion());
            ps.setString(8, "Prueba"); // Estado inicial
            
            ps.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }
    
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Connection con = Conexion.conectar();
        
        if (con == null) return listaUsuarios; 
        
        String sql = "SELECT documento, nombre_completo, telefono, correo, rol, estado_cuenta FROM usuarios";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setDocumento(rs.getString("documento"));
                u.setNombreCompleto(rs.getString("nombre_completo"));
                u.setTelefono(rs.getString("telefono"));
                u.setCorreo(rs.getString("correo"));
                u.setRol(rs.getString("rol"));
                u.setEstadoCuenta(rs.getString("estado_cuenta"));
                
                listaUsuarios.add(u);
            }
            
        } catch (Exception e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        
        return listaUsuarios;
    }
    
    public String solicitarRecuperacionPassword(String documento) {
        Connection con = Conexion.conectar();
        if (con == null) return "Error de conexión a la base de datos.";
        
        try {
            String sqlCheck = "SELECT id, rol FROM usuarios WHERE documento = ?";
            PreparedStatement psCheck = con.prepareStatement(sqlCheck);
            psCheck.setString(1, documento);
            ResultSet rs = psCheck.executeQuery();
            
            if (rs.next()) {
                int idUsuario = rs.getInt("id"); 
                String rol = rs.getString("rol");
                
                if (rol.equals("Admin")) {
                    return "Los administradores no pueden usar esta opción de recuperación.";
                }
                
                String sqlUpdate = "UPDATE usuarios SET estado_cuenta = 'Inactivo' WHERE documento = ?";
                PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
                psUpdate.setString(1, documento);
                psUpdate.executeUpdate();
                
                String sqlInsert = "INSERT INTO solicitudes (id_usuario, tipo_solicitud) VALUES (?, 'Recuperar_Credenciales')";
                PreparedStatement psInsert = con.prepareStatement(sqlInsert);
                psInsert.setInt(1, idUsuario);
                psInsert.executeUpdate();
                
                return "EXITO";
            } else {
                return "El documento ingresado no está registrado en el sistema.";
            }
            
        } catch (Exception e) {
            System.out.println("Error en recuperación: " + e.getMessage());
            return "Ocurrió un error al procesar la solicitud.";
        }
    }
    
    // --- NUEVOS MÉTODOS DEL FLUJO DEFINITIVO ---

    // Revisamos la última solicitud del usuario para saber el estado
    public String[] verificarEstadoSolicitud(String documento) {
        String[] datos = new String[2];
        Connection con = Conexion.conectar();
        if (con == null) return null;
        try {
            // Buscamos su última solicitud y traemos su token original
            String sql = "SELECT s.estado, u.token_recuperacion FROM solicitudes s " +
                         "INNER JOIN usuarios u ON s.id_usuario = u.id " +
                         "WHERE u.documento = ? ORDER BY s.fecha_solicitud DESC LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                datos[0] = rs.getString("estado"); // 'Pendiente' o 'Aprobada'
                datos[1] = rs.getString("token_recuperacion"); // Token original de la cuenta
                return datos;
            }
        } catch (Exception e) {
            System.out.println("Error al verificar estado: " + e.getMessage());
        }
        return null;
    }

    // Guarda nueva clave, nuevo token y limpia la solicitud
   public boolean restablecerPasswordYToken(String documento, String nuevaPassword, String nuevoToken) {
        Connection con = Conexion.conectar();
        if (con == null) return false;
        try {
            String sqlUpdate = "UPDATE usuarios SET password = ?, token_recuperacion = ? WHERE documento = ?";
            PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
            psUpdate.setString(1, nuevaPassword);
            psUpdate.setString(2, nuevoToken);
            psUpdate.setString(3, documento); // ¡Esta era la línea que faltaba!
            
            if (psUpdate.executeUpdate() > 0) {
                // Borramos la solicitud para que el ciclo quede limpio
                String sqlDelete = "DELETE FROM solicitudes WHERE id_usuario = (SELECT id FROM usuarios WHERE documento = ?)";
                PreparedStatement psDel = con.prepareStatement(sqlDelete);
                psDel.setString(1, documento);
                psDel.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar credenciales: " + e.getMessage());
        }
        return false;
    }
   
   // Método para verificar si el documento ya está registrado
    public boolean existeDocumento(String documento) {
        Connection con = Conexion.conectar();
        if (con == null) return false;
        try {
            String sql = "SELECT id FROM usuarios WHERE documento = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Retorna true si encontró al menos un registro
        } catch (Exception e) {
            System.out.println("Error al verificar documento: " + e.getMessage());
        }
        return false;
    }

    // Método para verificar si el correo ya está registrado
    public boolean existeCorreo(String correo) {
        Connection con = Conexion.conectar();
        if (con == null) return false;
        try {
            String sql = "SELECT id FROM usuarios WHERE correo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Retorna true si encontró al menos un registro
        } catch (Exception e) {
            System.out.println("Error al verificar correo: " + e.getMessage());
        }
        return false;
    }
   
}