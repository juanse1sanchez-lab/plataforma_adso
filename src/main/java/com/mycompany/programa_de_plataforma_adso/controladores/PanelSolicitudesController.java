package com.mycompany.programa_de_plataforma_adso.controladores;

// Importaciones en la parte superior:
import com.mycompany.programa_de_plataforma_adso.dao.SolicitudDAO;
import com.mycompany.programa_de_plataforma_adso.modelos.Solicitud;
import com.mycompany.programa_de_plataforma_adso.servicios.GeneradorCredenciales;
import com.mycompany.programa_de_plataforma_adso.vistas.PanelSolicitudes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelSolicitudesController {
    
    private PanelSolicitudes vista;
    private SolicitudDAO dao;

    public PanelSolicitudesController(PanelSolicitudes vista) {
        this.vista = vista;
        this.dao = new SolicitudDAO();
    }
    
    public void cargarSolicitudes() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTbSolicitudes().getModel();
        modelo.setRowCount(0); // Limpiamos la tabla
        
        List<Solicitud> lista = dao.listarSolicitudes();
        
        for (Solicitud s : lista) {
            Object[] fila = new Object[6];
            fila[0] = s.getId();
            fila[1] = s.getDocumentoUsuario();
            fila[2] = s.getNombreUsuario();
            fila[3] = s.getTipoSolicitud();
            fila[4] = s.getFechaSolicitud();
            fila[5] = s.getEstado();
            
            modelo.addRow(fila);
        }
    }
    
    public void aprobarSolicitudSeleccionada() {
        int fila = vista.getTbSolicitudes().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una solicitud.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int idSolicitud = (int) vista.getTbSolicitudes().getValueAt(fila, 0);
        String documento = (String) vista.getTbSolicitudes().getValueAt(fila, 1);
        String estadoActual = (String) vista.getTbSolicitudes().getValueAt(fila, 5);
        
        if (estadoActual.equals("Aprobada")) {
            JOptionPane.showMessageDialog(vista, "Esta solicitud ya fue aprobada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Llamamos al DAO sin generar tokens nuevos
        String respuesta = dao.aprobarSolicitudRecuperacion(idSolicitud, documento);
        
        if (respuesta.equals("EXITO")) {
            JOptionPane.showMessageDialog(vista, "Solicitud aprobada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarSolicitudes(); 
        } else {
            JOptionPane.showMessageDialog(vista, respuesta, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}