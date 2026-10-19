package com.mycompany.programa_de_plataforma_adso.dao;

// Importaciones en la parte superior:
import com.mycompany.programa_de_plataforma_adso.config.Conexion;
import com.mycompany.programa_de_plataforma_adso.modelos.Solicitud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDAO {
    
    public List<Solicitud> listarSolicitudes() {
        List<Solicitud> lista = new ArrayList<>();
        Connection con = Conexion.conectar();
        
        if (con == null) return lista;
        
        // INNER JOIN para cruzar la tabla solicitudes con usuarios y obtener el documento y nombre
        String sql = "SELECT s.id, u.documento, u.nombre_completo, s.tipo_solicitud, s.fecha_solicitud, s.estado " +
                     "FROM solicitudes s " +
                     "INNER JOIN usuarios u ON s.id_usuario = u.id " +
                     "ORDER BY s.fecha_solicitud DESC"; // Ordenamos para ver las más recientes primero
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Solicitud sol = new Solicitud();
                sol.setId(rs.getInt("id"));
                sol.setDocumentoUsuario(rs.getString("documento"));
                sol.setNombreUsuario(rs.getString("nombre_completo"));
                sol.setTipoSolicitud(rs.getString("tipo_solicitud"));
                sol.setFechaSolicitud(rs.getString("fecha_solicitud"));
                sol.setEstado(rs.getString("estado"));
                
                lista.add(sol);
            }
        } catch (Exception e) {
            System.out.println("Error al listar solicitudes: " + e.getMessage());
        }
        return lista;
    }
    
    public String aprobarSolicitudRecuperacion(int idSolicitud, String documentoUsuario) {
        Connection con = Conexion.conectar();
        if (con == null) return "Error de conexión";

        try {
            con.setAutoCommit(false);

            // 1. Solicitud a 'Aprobada'
            String sqlSolicitud = "UPDATE solicitudes SET estado = 'Aprobada' WHERE id = ?";
            PreparedStatement psSolicitud = con.prepareStatement(sqlSolicitud);
            psSolicitud.setInt(1, idSolicitud);
            psSolicitud.executeUpdate();

            // 2. Usuario a 'Prueba' (Conserva su token original)
            String sqlUsuario = "UPDATE usuarios SET estado_cuenta = 'Prueba' WHERE documento = ?";
            PreparedStatement psUsuario = con.prepareStatement(sqlUsuario);
            psUsuario.setString(1, documentoUsuario);
            psUsuario.executeUpdate();

            con.commit();
            return "EXITO";

        } catch (Exception e) {
            try { con.rollback(); } catch (SQLException ex) {}
            return "Error al aprobar: " + e.getMessage();
        } finally {
            try { con.setAutoCommit(true); } catch (SQLException ex) {}
        }
    }
}