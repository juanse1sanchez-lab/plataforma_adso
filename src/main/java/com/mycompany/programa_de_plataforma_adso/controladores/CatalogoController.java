package com.mycompany.programa_de_plataforma_adso.controladores;

import com.mycompany.programa_de_plataforma_adso.dao.ContenidoDAO;
import com.mycompany.programa_de_plataforma_adso.modelos.Contenido;
import com.mycompany.programa_de_plataforma_adso.vistas.PanelGestionCatalogo;
import java.time.Year;
import javax.swing.JOptionPane;

public class CatalogoController {

    private PanelGestionCatalogo vista;
    private ContenidoDAO dao;

    public CatalogoController(PanelGestionCatalogo vista) {
        this.vista = vista;
        this.dao = new ContenidoDAO();
    }

    public void guardarContenido() {
        // 1. Extraer datos de la vista
        String nombre = vista.getTxt_nombre().getText().trim();
        String descripcion = vista.getTxt_descripcion().getText().trim();
        String strAnio = vista.getTxt_anio().getText().trim();
        String tipo = vista.getCbx_tipo().getSelectedItem().toString();
        String categoria = vista.getCbx_categoria().getSelectedItem().toString();

        // 2. Validar que no haya campos vacíos
        if (nombre.isEmpty() || descripcion.isEmpty() || strAnio.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Validar el Año (debe ser un número válido y no estar en el futuro)
        int anio;
        try {
            anio = Integer.parseInt(strAnio);
            int anioActual = Year.now().getValue();
            
            // Regla del documento: año dentro de un rango y no posterior al actual
            if (anio < 1888 || anio > anioActual) { 
                JOptionPane.showMessageDialog(vista, "El año debe ser válido y no posterior al año actual (" + anioActual + ").", "Año Inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El año debe ser un número entero.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 4. Validar duplicados (Regla: mismo nombre y mismo tipo)
        if (dao.existeContenido(nombre, tipo)) {
            JOptionPane.showMessageDialog(vista, "Ya existe un/a " + tipo + " con ese nombre en el catálogo.", "Contenido Duplicado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 5. Crear objeto y guardar
        Contenido nuevoContenido = new Contenido();
        nuevoContenido.setTipo(tipo);
        nuevoContenido.setNombre(nombre);
        nuevoContenido.setDescripcion(descripcion);
        nuevoContenido.setAnio(anio);
        nuevoContenido.setCategoria(categoria);
        nuevoContenido.setEstado("ACTIVO");

        if (dao.crear(nuevoContenido)) {
            JOptionPane.showMessageDialog(vista, "Contenido guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al guardar en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        vista.getTxt_nombre().setText("");
        vista.getTxt_descripcion().setText("");
        vista.getTxt_anio().setText("");
        vista.getCbx_tipo().setSelectedIndex(0);
        vista.getCbx_categoria().setSelectedIndex(0);
    }
}