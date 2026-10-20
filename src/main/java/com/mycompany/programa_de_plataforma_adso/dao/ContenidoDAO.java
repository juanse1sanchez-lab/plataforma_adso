package com.mycompany.programa_de_plataforma_adso.dao;

import com.mycompany.programa_de_plataforma_adso.config.Conexion;
import com.mycompany.programa_de_plataforma_adso.modelos.Contenido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContenidoDAO {

    // Método para registrar una nueva película o serie en la BD
    public boolean crear(Contenido contenido) {
        Connection con = Conexion.conectar();
        if (con == null) return false;
        
        try {
            String sql = "INSERT INTO contenido (tipo, nombre, descripcion, anio, categoria, estado) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, contenido.getTipo());
            ps.setString(2, contenido.getNombre());
            ps.setString(3, contenido.getDescripcion());
            ps.setInt(4, contenido.getAnio());
            ps.setString(5, contenido.getCategoria());
            ps.setString(6, contenido.getEstado()); // Por defecto será 'ACTIVO'
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (Exception e) {
            System.out.println("Error al guardar contenido: " + e.getMessage());
            return false;
        }
    }
    
    // Validar duplicados (Regla: mismo nombre y mismo tipo)
    public boolean existeContenido(String nombre, String tipo) {
        Connection con = Conexion.conectar();
        if (con == null) return false;
        
        try {
            String sql = "SELECT id_contenido FROM contenido WHERE nombre = ? AND tipo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Retorna true si ya existe
        } catch (Exception e) {
            System.out.println("Error al verificar contenido duplicado: " + e.getMessage());
            return false;
        }
    }
    
    public List<Contenido> listarContenido(String filtroNombre, String filtroCategoria) {
        List<Contenido> lista = new ArrayList<>();
        Connection con = Conexion.conectar();
        if (con == null) return lista;

        try {
            // Consulta base. (El 1=1 es un truco SQL para concatenar filtros fácilmente)
            String sql = "SELECT * FROM contenido WHERE 1=1";
            
            if (filtroNombre != null && !filtroNombre.trim().isEmpty()) {
                sql += " AND nombre LIKE ?";
            }
            if (filtroCategoria != null && !filtroCategoria.equals("Todas")) {
                sql += " AND categoria = ?";
            }
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            int paramIndex = 1;
            if (filtroNombre != null && !filtroNombre.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + filtroNombre + "%");
            }
            if (filtroCategoria != null && !filtroCategoria.equals("Todas")) {
                ps.setString(paramIndex++, filtroCategoria);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Contenido c = new Contenido();
                c.setIdContenido(rs.getInt("id_contenido"));
                c.setTipo(rs.getString("tipo"));
                c.setNombre(rs.getString("nombre"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setAnio(rs.getInt("anio"));
                c.setCategoria(rs.getString("categoria"));
                c.setEstado(rs.getString("estado"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al listar contenido: " + e.getMessage());
        }
        return lista;
    }
    
    // Método para actualizar un contenido existente (RF-06)
    public boolean actualizar(Contenido contenido) {
        Connection con = Conexion.conectar();
        if (con == null) return false;
        
        try {
            // Actualizamos los datos permitidos por el documento
            String sql = "UPDATE contenido SET tipo=?, nombre=?, descripcion=?, anio=?, categoria=? WHERE id_contenido=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, contenido.getTipo());
            ps.setString(2, contenido.getNombre());
            ps.setString(3, contenido.getDescripcion());
            ps.setInt(4, contenido.getAnio());
            ps.setString(5, contenido.getCategoria());
            ps.setInt(6, contenido.getIdContenido());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (Exception e) {
            System.out.println("Error al actualizar contenido: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminación lógica (cambiar estado a INACTIVO) (RF-07)
    public boolean desactivar(int idContenido) {
        Connection con = Conexion.conectar();
        if (con == null) return false;
        
        try {
            String sql = "UPDATE contenido SET estado = 'INACTIVO' WHERE id_contenido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idContenido);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (Exception e) {
            System.out.println("Error al desactivar contenido: " + e.getMessage());
            return false;
        }
    }
    
    public boolean activar(int idContenido) {
        Connection con = Conexion.conectar();
        if (con == null) return false;
        
        try {
            String sql = "UPDATE contenido SET estado = 'ACTIVO' WHERE id_contenido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idContenido);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (Exception e) {
            System.out.println("Error al activar contenido: " + e.getMessage());
            return false;
        }
    }
}