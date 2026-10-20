package com.mycompany.programa_de_plataforma_adso.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelCatalogo extends javax.swing.JPanel {

  
    public PanelCatalogo() {
        initComponents();
        cargarPeliculasDePrueba();
    }

    private void cargarPeliculasDePrueba() {
        // 1. Configuramos el panel como una cuadrícula: 
        // 0 filas (crecen infinitamente), 3 columnas, y 20px de espacio entre tarjetas
        pnl_cuadricula.setLayout(new GridLayout(0, 3, 20, 20)); 
        pnl_cuadricula.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

        // 2. Simulamos una lista de películas (luego vendrán de la base de datos)
        String[] peliculas = {"The Matrix", "Inception", "Interstellar", "El Padrino", "Shrek", "Toy Story", "Avengers", "Gladiador", "Parasite"};

        // 3. Generamos una "Tarjeta" visual por cada película
        for (String titulo : peliculas) {
            
            // Panel principal de la tarjeta
            JPanel tarjeta = new JPanel();
            tarjeta.setLayout(new BorderLayout(10, 10));
            tarjeta.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            tarjeta.setPreferredSize(new Dimension(150, 220));
            tarjeta.setBackground(new Color(40, 40, 40)); // Fondo gris oscuro

            // Etiqueta del título (Arriba)
            JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
            lblTitulo.setForeground(Color.WHITE); // Letra blanca
            tarjeta.add(lblTitulo, BorderLayout.NORTH);

            // Panel simulando la portada de la película (Centro)
            JPanel portada = new JPanel();
            portada.setBackground(Color.BLACK);
            tarjeta.add(portada, BorderLayout.CENTER);

            // Botón de acción (Abajo)
            JButton btnReproducir = new JButton("Ver Detalles");
            btnReproducir.setBackground(new Color(200, 0, 0)); // Toque rojo tipo Netflix
            btnReproducir.setForeground(Color.WHITE);
            tarjeta.add(btnReproducir, BorderLayout.SOUTH);

            // Agregamos la tarjeta terminada a nuestra cuadrícula
            pnl_cuadricula.add(tarjeta);
        }

        // Actualizamos la interfaz gráfica
        pnl_cuadricula.revalidate();
        pnl_cuadricula.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_contenido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnl_cuadricula = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        lbl_contenido.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lbl_contenido.setText("Catálogo de Contenido");
        add(lbl_contenido, java.awt.BorderLayout.CENTER);

        pnl_cuadricula.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnl_cuadriculaLayout = new javax.swing.GroupLayout(pnl_cuadricula);
        pnl_cuadricula.setLayout(pnl_cuadriculaLayout);
        pnl_cuadriculaLayout.setHorizontalGroup(
            pnl_cuadriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        pnl_cuadriculaLayout.setVerticalGroup(
            pnl_cuadriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnl_cuadricula);

        add(jScrollPane1, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_contenido;
    private javax.swing.JPanel pnl_cuadricula;
    // End of variables declaration//GEN-END:variables
}
