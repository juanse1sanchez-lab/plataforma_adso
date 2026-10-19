
package com.mycompany.programa_de_plataforma_adso.vistas;

import com.mycompany.programa_de_plataforma_adso.controladores.PanelSolicitudesController;
import javax.swing.JTable;

/**
 *
 * @author juans
 */
public class PanelSolicitudes extends javax.swing.JPanel {

    /**
     * Creates new form PanelSolicitudes
     */
    public PanelSolicitudes() {
        initComponents();
        inicializarDatos();
    }

    
    public JTable getTbSolicitudes() {
        return tb_solicitudes;
    }
    
    private void inicializarDatos() {
        PanelSolicitudesController controlador = new PanelSolicitudesController(this);
        controlador.cargarSolicitudes();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_solicitudes = new javax.swing.JTable();
        btn_aprobar = new javax.swing.JButton();

        jLabel1.setText("Gestión de Solicitudes");

        tb_solicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Documento", "Nombre del Usuario", "Tipo de Solicitud", "Fecha", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tb_solicitudes);

        btn_aprobar.setText("Aprobar Solicitud");
        btn_aprobar.addActionListener(this::btn_aprobarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_aprobar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btn_aprobar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aprobarActionPerformed
        PanelSolicitudesController controlador = new PanelSolicitudesController(this);
        controlador.aprobarSolicitudSeleccionada();
    }//GEN-LAST:event_btn_aprobarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aprobar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_solicitudes;
    // End of variables declaration//GEN-END:variables
}
