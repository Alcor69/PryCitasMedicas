/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.Especialidades;

import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import javax.swing.table.DefaultTableModel;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;

/**
 *
 * @author rb940
 */
public class ListadoEspecialidades extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListadoEspecialidades
     */
   private DefaultTableModel tableModel;

    public ListadoEspecialidades() {
        initComponents();
        initTable();
        cargarEspecialidades();
    }

    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Especialidad");
        tableModel.addColumn("Nombre");
        tbl_especialidades.setModel(tableModel);
    }

    private void cargarEspecialidades() {
        EspecialidadControlador controlador = EspecialidadControlador.getInstancia();

        for (EspecialidadModelo especialidad : controlador.listarEspecialidades()) {
            Object[] fila = {
                especialidad.getId(),
                especialidad.getNombre()
            };
            tableModel.addRow(fila);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_medicos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_especialidades = new javax.swing.JTable();

        jLabel1.setText("Listado de Especialistas");

        tbl_medicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_medicos);

        tbl_especialidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_especialidades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_especialidades;
    private javax.swing.JTable tbl_medicos;
    // End of variables declaration//GEN-END:variables
}
