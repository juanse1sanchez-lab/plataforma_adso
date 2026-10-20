/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.programa_de_plataforma_adso.vistas;

import com.mycompany.programa_de_plataforma_adso.controladores.CatalogoController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author juans
 */
public class PanelGestionCatalogo extends javax.swing.JPanel {

    /**
     * Creates new form PanelGestionCatalogo
     */
    public PanelGestionCatalogo() {
        initComponents();
    }

    public JButton getBtn_guardarContenido() {
        return btn_guardarContenido;
    }

    public JComboBox<String> getCbx_categoria() {
        return cbx_categoria;
    }

    public JComboBox<String> getCbx_tipo() {
        return cbx_tipo;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JLabel getLbl_anio() {
        return lbl_anio;
    }

    public JLabel getLbl_categoria() {
        return lbl_categoria;
    }

    public JLabel getLbl_descripcion() {
        return lbl_descripcion;
    }

    public JLabel getLbl_nombre() {
        return lbl_nombre;
    }

    public JLabel getLbl_tipo() {
        return lbl_tipo;
    }

    public JTextField getTxt_anio() {
        return txt_anio;
    }

    public JTextArea getTxt_descripcion() {
        return txt_descripcion;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_nombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        txt_anio = new javax.swing.JTextField();
        cbx_tipo = new javax.swing.JComboBox<>();
        cbx_categoria = new javax.swing.JComboBox<>();
        btn_guardarContenido = new javax.swing.JButton();
        lbl_nombre = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_anio = new javax.swing.JLabel();
        lbl_tipo = new javax.swing.JLabel();
        lbl_categoria = new javax.swing.JLabel();

        txt_nombre.setText(" ");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        txt_anio.setText(" ");

        cbx_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pelicula", "Serie" }));

        cbx_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accion", "Comedia", "Terror", "Ciencia Ficcion" }));

        btn_guardarContenido.setText("Guardar");
        btn_guardarContenido.addActionListener(this::btn_guardarContenidoActionPerformed);

        lbl_nombre.setText("Nombre: ");

        lbl_descripcion.setText("Descripción:");

        lbl_anio.setText("Año: ");

        lbl_tipo.setText("Tipo: ");

        lbl_categoria.setText("Categoría: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_tipo)
                            .addComponent(lbl_categoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_anio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_anio, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_descripcion)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_nombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_nombre)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btn_guardarContenido)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_descripcion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_anio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_categoria))
                .addGap(32, 32, 32)
                .addComponent(btn_guardarContenido)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarContenidoActionPerformed
        CatalogoController controlador = new CatalogoController(this);
        controlador.guardarContenido();
    }//GEN-LAST:event_btn_guardarContenidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardarContenido;
    private javax.swing.JComboBox<String> cbx_categoria;
    private javax.swing.JComboBox<String> cbx_tipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_anio;
    private javax.swing.JLabel lbl_categoria;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_tipo;
    private javax.swing.JTextField txt_anio;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
