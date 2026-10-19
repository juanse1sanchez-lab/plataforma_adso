package com.mycompany.programa_de_plataforma_adso.controladores;

// Importaciones en la parte superior:
import com.mycompany.programa_de_plataforma_adso.modelos.Usuario;
import com.mycompany.programa_de_plataforma_adso.vistas.DashboardUsuario;
import com.mycompany.programa_de_plataforma_adso.vistas.Inicio_Sesion;
import com.mycompany.programa_de_plataforma_adso.vistas.PanelCatalogo;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class DashboardUsuarioController {
    
    private DashboardUsuario vista;
    private Usuario usuarioLogueado;

    // Recibimos la vista y los datos del usuario que acaba de loguearse
    public DashboardUsuarioController(DashboardUsuario vista, Usuario usuarioLogueado) {
        this.vista = vista;
        this.usuarioLogueado = usuarioLogueado;
    }
    
    // Configura y muestra la ventana
    public void iniciar() {
        vista.setTitle("Plataforma Streaming - Bienvenido/a " + usuarioLogueado.getNombreCompleto());
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        // Inyectamos el catálogo por defecto apenas arranca la ventana
        PanelCatalogo panelInicial = new PanelCatalogo();
        mostrarPanel(panelInicial);
    }
    
    // Lógica limpia para cerrar sesión
    public void cerrarSesion() {
        vista.dispose(); // Destruye esta ventana
        Inicio_Sesion login = new Inicio_Sesion();
        login.setVisible(true); // Vuelve a mostrar el login
    }
    
    // Método reutilizable para inyectar paneles dinámicos
    public void mostrarPanel(JPanel panel) {
        vista.getPnl_contenedor().removeAll();
        vista.getPnl_contenedor().add(panel, BorderLayout.CENTER);
        vista.getPnl_contenedor().revalidate();
        vista.getPnl_contenedor().repaint();
    }
}