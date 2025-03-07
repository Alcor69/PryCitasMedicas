/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.turnos;

import controlador.TurnoControlador;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import modelo.TurnoModelo;

/**
 *
 * @author rb940
 */
public class NewJInternalFrame extends javax.swing.JInternalFrame {
     private DefaultTableModel tableModel;

    /**
     * Creates new form NewJInternalFrame
     */
    public NewJInternalFrame() {
        initComponents();
        initTable();
        cargarTurnos();
    }
    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Turno");
        tableModel.addColumn("Cédula Paciente");
        tableModel.addColumn("Nombres Paciente");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Hora");
        tbl_turnos.setModel(tableModel);
    }

    private void cargarTurnos() {
        TurnoControlador controlador = TurnoControlador.getInstancia();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (TurnoModelo turno : controlador.listarTurnos()) {
            Object[] fila = {
                turno.getId(),
                turno.getPaciente().getCedula(),
                turno.getPaciente().getNombres(),
                dateFormat.format(turno.getFecha()),
                turno.getHora()
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
        tbl_turnos = new javax.swing.JTable();

        jLabel1.setText("Listado de Turnos");

        tbl_turnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_turnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_turnos;
    // End of variables declaration//GEN-END:variables
}
