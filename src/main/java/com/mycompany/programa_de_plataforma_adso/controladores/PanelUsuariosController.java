package com.mycompany.programa_de_plataforma_adso.controladores;

import com.mycompany.programa_de_plataforma_adso.dao.UsuarioDAO;
import com.mycompany.programa_de_plataforma_adso.modelos.Usuario;
import com.mycompany.programa_de_plataforma_adso.vistas.PanelUsuarios;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PanelUsuariosController {
    
    private PanelUsuarios vista;
    private UsuarioDAO dao;

    public PanelUsuariosController(PanelUsuarios vista) {
        this.vista = vista;
        this.dao = new UsuarioDAO();
    }
    
    public void cargarUsuarios() {
        // 1. Obtenemos el modelo estructural de tu tabla
        DefaultTableModel modelo = (DefaultTableModel) vista.getTbUsuarios().getModel();
        
        // 2. Limpiamos la tabla desde la fila 0 para que no se dupliquen datos al recargar
        modelo.setRowCount(0);
        
        // 3. Llamamos al método que acabas de crear en el DAO
        List<Usuario> lista = dao.listarUsuarios();
        
        // 4. Recorremos la lista y armamos las filas
        for (Usuario u : lista) {
            Object[] fila = new Object[6]; // 6 columnas
            fila[0] = u.getDocumento();
            fila[1] = u.getNombreCompleto();
            fila[2] = u.getTelefono();
            fila[3] = u.getCorreo();
            fila[4] = u.getRol();
            fila[5] = u.getEstadoCuenta();
            
            // Añadimos la fila a la tabla
            modelo.addRow(fila);
        }
    }
}
