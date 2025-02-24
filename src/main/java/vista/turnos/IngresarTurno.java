/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.turnos;

import controlador.PacienteControlador;
import controlador.TurnoControlador;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.PacienteModelo;

/**
 *
 * @author rb940
 */
public class IngresarTurno extends javax.swing.JInternalFrame {

    /**
     * Creates new form IngresarTurno
     */
    public IngresarTurno() {
        initComponents();
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
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_cedulaPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txt_hora = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();

        jLabel1.setText("ID del turno");

        jLabel2.setText("Cedula del Paciente");

        jLabel3.setText("Fecha del turno");

        jLabel4.setText("Hora (HH:mm) :");

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txt_cedulaPaciente)
                            .addComponent(txt_hora)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btn_guardar)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_guardar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
    String id = txt_id.getText();
        String cedulaPaciente = txt_cedulaPaciente.getText();
        Date fecha = dateChooser.getDate();
        String hora = txt_hora.getText();

        // Validar que todos los campos estén llenos
        if (id.isEmpty() || cedulaPaciente.isEmpty() || fecha == null || hora.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar formato de hora (HH:mm)
        if (!hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            JOptionPane.showMessageDialog(this, "Formato de hora inválido. Use HH:mm", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar paciente por cédula
        PacienteControlador pacienteControlador = PacienteControlador.getInstancia();
        PacienteModelo paciente = pacienteControlador.buscarPacientePorCedula(cedulaPaciente);

        if (paciente == null) {
            JOptionPane.showMessageDialog(this, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si el paciente ya tiene un turno en la misma fecha
        TurnoControlador turnoControlador = TurnoControlador.getInstancia();
        if (turnoControlador.existeTurnoParaPacienteEnFecha(paciente, fecha)) {
            JOptionPane.showMessageDialog(this, "El paciente ya tiene un turno en esta fecha", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Guardar el turno
        turnoControlador.agregarTurno(id, paciente, fecha, hora);
        JOptionPane.showMessageDialog(this, "Turno guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar campos después de guardar
        txt_id.setText("");
        txt_cedulaPaciente.setText("");
        dateChooser.setDate(null);
        txt_hora.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_guardarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_cedulaPaciente;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
