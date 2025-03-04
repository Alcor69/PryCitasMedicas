
package vista.citas;

import controlador.CitaControlador;
import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteControlador;
import javax.swing.JOptionPane;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;


public class Ingresar extends javax.swing.JInternalFrame {

    PacienteControlador pc = PacienteControlador.getInstancia();
    EspecialidadControlador ec = EspecialidadControlador.getInstancia();
    MedicoControlador mc = MedicoControlador.getInstancia();
    CitaControlador cc = CitaControlador.getInstancia();
            
    
    public Ingresar() {
        initComponents();
        
        //cargue en el combo box pacientes la carga automatica
        cargarPacienteAutomaticamente();
        CargarEspecialidadeAutomaticamente();
        
       
        
        cbx_especialidades.addActionListener(e -> {
           String nombreEspecialidad  = cbx_especialidades.getSelectedItem().toString();
            System.out.println(nombreEspecialidad);
            if (!nombreEspecialidad.equals("Seleccione Especialidad")) {
                CargarMedicoAutomaticaemetne(nombreEspecialidad);
                
            }
        
        });
    }
    
    private void cargarPacienteAutomaticamente(){
        cbx_pacientes.addItem("Seleccione un Paciente");
        for (PacienteModelo  pacienteModelo : pc.listadoCompleto()) {
            cbx_pacientes.addItem(pacienteModelo.getCedula()+" "+ pacienteModelo.getNombres());
            
        }
    }
    private void CargarEspecialidadeAutomaticamente(){
        cbx_especialidades.addItem("Seleccione Especialidad");
        for (EspecialidadModelo em : ec.listado()) {
            cbx_especialidades.addItem(em.getNombre());
            
        }
    }
    private void CargarMedicoAutomaticaemetne(String n_e){
        
        cbx_medico.addItem("Seleccione un medico");
        cbx_medico.removeAllItems();
        
        for (MedicoModelo mm : mc.listadoPorEspecialidad(n_e)) {
            cbx_medico.addItem(mm.getCedula()+" "+mm.getNombres());
            
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbx_pacientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbx_especialidades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbx_medico = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_hora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();

        jLabel1.setText("Seleccionar Paciente");

        jLabel2.setText("Selecciona Especialidad");

        jLabel3.setText("Seleccionar Medico");

        jLabel4.setText("Motivo para la cita");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        jLabel5.setText("Fecha");

        jLabel6.setText("Hora");

        jLabel7.setText("dd/mm/aa");

        jLabel8.setText("hh/mm");

        btn_guardar.setText("GENERAR TURNO");
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
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbx_especialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbx_medico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(txt_hora))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btn_guardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbx_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbx_especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbx_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(btn_guardar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
    //paciente
    String nombrePaciente = cbx_pacientes.getSelectedItem().toString();
    String pacientePartes[]=nombrePaciente.split(" ");
    String cedula =pacientePartes[0];
    PacienteModelo pm = pc.obtenerCedula(cedula);
    //medico
    String nombreMedico = cbx_medico.getSelectedItem().toString();
    String MedicoPartes[]=nombreMedico.split(" ");
    String cedula_m = MedicoPartes[0];
    MedicoModelo mm = mc.obtenerCedula(cedula_m);
    //especialidad
    EspecialidadModelo em = mm.getEspecialidadModelo();
    CitaModelo cm =cc.guardar(pm, mm, em, txt_descripcion.getText(), txt_fecha.getText(), txt_hora.getText());
    
    JOptionPane.showMessageDialog(this, "Cita ingresada para el día "+ cm.getFecha()+ " para las "+cm.getHora()+ " con el medico "+cm.getMm().getNombres()+ " y la especialidad "+ cm.getEm().getNombre());
            
    
    cbx_pacientes.setSelectedIndex(0);
    cbx_especialidades.setSelectedIndex(0);
    cbx_medico.setSelectedIndex(0);
    txt_descripcion.setText("");
    txt_fecha.setText("");
    txt_hora.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cbx_especialidades;
    private javax.swing.JComboBox<String> cbx_medico;
    private javax.swing.JComboBox<String> cbx_pacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_hora;
    // End of variables declaration//GEN-END:variables
}
