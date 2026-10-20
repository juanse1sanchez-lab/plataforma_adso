package com.mycompany.programa_de_plataforma_adso.controladores;

import com.mycompany.programa_de_plataforma_adso.dao.ContenidoDAO;
import com.mycompany.programa_de_plataforma_adso.modelos.Contenido;
import com.mycompany.programa_de_plataforma_adso.vistas.PanelVerPeliculas;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VerPeliculasController {

    private PanelVerPeliculas vista;
    private ContenidoDAO dao;

    public VerPeliculasController(PanelVerPeliculas vista) {
        this.vista = vista;
        this.dao = new ContenidoDAO();
    }

    // Este método lee la base de datos y dibuja las filas
    public void cargarTabla() {
        // 1. Obtener los valores que el usuario escribió en los filtros
        String filtroNombre = vista.getTxt_buscar().getText().trim();
        String filtroCategoria = vista.getCbx_filtroCategoria().getSelectedItem().toString();

        // 2. Pedirle al DAO la lista filtrada
        List<Contenido> lista = dao.listarContenido(filtroNombre, filtroCategoria);

        // 3. Obtener el modelo de la tabla visual y limpiarla por si tenía datos viejos
        DefaultTableModel modelo = (DefaultTableModel) vista.getTbl_contenido().getModel();
        modelo.setRowCount(0);

        // 4. Llenar la tabla fila por fila
        for (Contenido c : lista) {
            Object[] fila = new Object[6];
            fila[0] = c.getIdContenido();
            fila[1] = c.getTipo();
            fila[2] = c.getNombre();
            fila[3] = c.getAnio();
            fila[4] = c.getCategoria();
            fila[5] = c.getEstado();
            
            modelo.addRow(fila);
        }
    }
    
   

    // Método para Editar (Cumple RF-06: Editar nombre, año, tipo y categoría)
    public void editarSeleccionado() {
        int fila = vista.getTbl_contenido().getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Por favor, seleccione una fila para editar.", "Ninguna selección", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Extraemos los datos actuales de la tabla
        int id = (int) vista.getTbl_contenido().getValueAt(fila, 0);
        String tipoActual = vista.getTbl_contenido().getValueAt(fila, 1).toString();
        String nombreActual = vista.getTbl_contenido().getValueAt(fila, 2).toString();
        String anioActual = vista.getTbl_contenido().getValueAt(fila, 3).toString();
        String catActual = vista.getTbl_contenido().getValueAt(fila, 4).toString();

        // Creamos pequeños campos dinámicos para la ventana de edición
        javax.swing.JTextField txtNombre = new javax.swing.JTextField(nombreActual);
        javax.swing.JTextField txtAnio = new javax.swing.JTextField(anioActual);
        javax.swing.JComboBox<String> cbxTipo = new javax.swing.JComboBox<>(new String[]{"PELICULA", "SERIE"});
        cbxTipo.setSelectedItem(tipoActual);
        javax.swing.JComboBox<String> cbxCat = new javax.swing.JComboBox<>(new String[]{"Acción", "Comedia", "Terror", "Ciencia ficción"});
        cbxCat.setSelectedItem(catActual);

        Object[] formularioEdicion = {
            "Tipo de contenido:", cbxTipo,
            "Nombre:", txtNombre,
            "Año de lanzamiento:", txtAnio,
            "Categoría:", cbxCat
        };

        int opcion = javax.swing.JOptionPane.showConfirmDialog(vista, formularioEdicion, "Editar Contenido", javax.swing.JOptionPane.OK_CANCEL_OPTION);
        
        if (opcion == javax.swing.JOptionPane.OK_OPTION) {
            // Validaciones al guardar (RF-06)
            if (txtNombre.getText().trim().isEmpty() || txtAnio.getText().trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(vista, "El nombre y el año no pueden estar vacíos.", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int nuevoAnio = Integer.parseInt(txtAnio.getText().trim());
                int anioActualHoy = java.time.Year.now().getValue();
                
                if (nuevoAnio < 1888 || nuevoAnio > anioActualHoy) {
                    javax.swing.JOptionPane.showMessageDialog(vista, "El año debe ser válido y no posterior al actual.", "Año Inválido", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Ensamblar objeto y enviar al DAO
                Contenido c = new Contenido();
                c.setIdContenido(id);
                c.setTipo(cbxTipo.getSelectedItem().toString());
                c.setNombre(txtNombre.getText().trim());
                c.setAnio(nuevoAnio);
                c.setCategoria(cbxCat.getSelectedItem().toString());
                c.setDescripcion("Editado por el administrador"); // Se mantiene una genérica por agilidad
                
                if(dao.actualizar(c)){
                    javax.swing.JOptionPane.showMessageDialog(vista, "Contenido actualizado correctamente.");
                    cargarTabla(); // Refrescar la tabla
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(vista, "El año debe ser un número entero.", "Error de formato", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Método unificado para alternar entre ACTIVO e INACTIVO
    public void cambiarEstadoSeleccionado() {
        int fila = vista.getTbl_contenido().getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Por favor, seleccione una fila de la tabla.", "Ninguna selección", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Extraer los datos de la fila
        int idContenido = (int) vista.getTbl_contenido().getValueAt(fila, 0);
        String nombre = vista.getTbl_contenido().getValueAt(fila, 2).toString();
        String estadoActual = vista.getTbl_contenido().getValueAt(fila, 5).toString();

        // Evaluamos el estado actual y decidimos la acción contraria
        if (estadoActual.equals("ACTIVO")) {
            
            int confirmacion = javax.swing.JOptionPane.showConfirmDialog(vista, 
                "¿Desea DESACTIVAR '" + nombre + "'?\nPasará a estado INACTIVO y se ocultará a los usuarios.", 
                "Confirmar desactivación", javax.swing.JOptionPane.YES_NO_OPTION);
                
            if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
                if (dao.desactivar(idContenido)) {
                    javax.swing.JOptionPane.showMessageDialog(vista, "Contenido desactivado correctamente.");
                    cargarTabla(); // Refresca visualmente la tabla
                }
            }
            
        } else { // Si el estado es INACTIVO
            
            int confirmacion = javax.swing.JOptionPane.showConfirmDialog(vista, 
                "¿Desea REACTIVAR '" + nombre + "'?\nVolverá a estar visible para los usuarios.", 
                "Confirmar reactivación", javax.swing.JOptionPane.YES_NO_OPTION);
                
            if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
                if (dao.activar(idContenido)) {
                    javax.swing.JOptionPane.showMessageDialog(vista, "Contenido reactivado correctamente.");
                    cargarTabla(); // Refresca visualmente la tabla
                }
            }
        }
    }
    
}