/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.citas;

import controlador.CitaControlador;
import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteControlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

/**
 *
 * @author rb940
 */
public class Listado extends javax.swing.JInternalFrame {
    
    

    /**
     * Creates new form Listado
     */
    
    public Listado() {
        initComponents();
        configurarTabla(); // Configurar las columnas de la tabla
        cargarPacientes();
        cargarEspecialidades();
        cargarMedicos();
        cargarFechas();
        cargarEstados();
        agregarListeners(); // Agregar listeners a los ComboBox
        aplicarFiltros(); // Cargar todas las citas al iniciar
    }

    private void configurarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cédula Paciente");     // Columna 0
        model.addColumn("Nombre Paciente");     // Columna 1
        model.addColumn("Especialidad");        // Columna 2
        model.addColumn("Médico");              // Columna 3
        model.addColumn("Fecha");               // Columna 4
        model.addColumn("Hora");                // Columna 5
        model.addColumn("Estado");              // Columna 6
        tbl_listado.setModel(model);
    }

    private void aplicarFiltros() {
        String estado = cbx_estado.getSelectedItem().toString();
        String paciente = cbx_paciente.getSelectedItem().toString();
        String especialidad = cbx_especialidad.getSelectedItem().toString();
        String medico = cbx_medico.getSelectedItem().toString();
        String fecha = cbx_fecha.getSelectedItem().toString();

        ArrayList<CitaModelo> citasFiltradas = CitaControlador.getInstancia().filtrarCitas(estado, paciente, especialidad, medico, fecha);
        actualizarTabla(citasFiltradas);
        
        if (!paciente.equals("Todos") && citasFiltradas.stream().noneMatch(c -> c.getPm().getCedula().equals(paciente.split(" ")[0]))) {
        JOptionPane.showMessageDialog(this, "No existen citas con estos datos ", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
        if (!medico.equals("Todos") && citasFiltradas.stream().noneMatch(c -> c.getMm().getCedula().equals(medico.split(" ")[0]))) {
        JOptionPane.showMessageDialog(this, "No existen citas con estos datos", "Información", JOptionPane.INFORMATION_MESSAGE);
    }


    actualizarTabla(citasFiltradas);
    }

    private void actualizarTabla(ArrayList<CitaModelo> citas) {
        DefaultTableModel model = (DefaultTableModel) tbl_listado.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

        for (CitaModelo cita : citas) {
            // Obtener el estado de la cita
            String estado = cita.getEstado();

            // Si el estado es nulo o vacío, mostrar "No Atendido"
            if (estado == cita.getHora() || estado.isEmpty()) {
                estado = "No Atendido";
            }

            // Crear la fila con los datos de la cita
            Object[] fila = {
                cita.getPm().getCedula(),       // Cédula del paciente (columna 0)
                cita.getPm().getNombres(),      // Nombre del paciente (columna 1)
                cita.getEm().getNombre(),       // Especialidad (columna 2)
                cita.getMm().getNombres(),      // Nombre del médico (columna 3)
                cita.getFecha(),                // Fecha (columna 4)
                cita.getHora(),                 // Hora (columna 5)
                estado                          // Estado (columna 6)
            };

            // Agregar la fila a la tabla
            model.addRow(fila);
        }
    }


    private void cargarPacientes() {
        cbx_paciente.removeAllItems(); // Limpiar ComboBox antes de cargar
        cbx_paciente.addItem("Todos");
        for (PacienteModelo paciente : PacienteControlador.getInstancia().listadoCompleto()) {
            cbx_paciente.addItem(paciente.getCedula() + " " + paciente.getNombres());
        }
    }

    private void cargarEspecialidades() {
        cbx_especialidad.removeAllItems(); // Limpiar ComboBox antes de cargar
        cbx_especialidad.addItem("Todas");
        for (EspecialidadModelo especialidad : EspecialidadControlador.getInstancia().listado()) {
            cbx_especialidad.addItem(especialidad.getNombre());
        }
    }

    private void cargarMedicos() {
        cbx_medico.removeAllItems(); // Limpiar ComboBox antes de cargar
        cbx_medico.addItem("Todos");
        for (MedicoModelo medico : MedicoControlador.getInstancia().listadoCompleto()) {
            cbx_medico.addItem(medico.getCedula() + " " + medico.getNombres());
        }
    }

    private void cargarFechas() {
        cbx_fecha.removeAllItems(); // Limpiar ComboBox antes de cargar
        cbx_fecha.addItem("Todas");
        for (CitaModelo cita : CitaControlador.getInstancia().listadoCompleto()) {
            if (!cbx_fecha.getItemAt(0).equals(cita.getFecha())) { // Evitar duplicados
                cbx_fecha.addItem(cita.getFecha());
            }
        }
    }

    private void cargarEstados() {
        cbx_estado.removeAllItems(); // Limpiar ComboBox antes de cargar
        cbx_estado.addItem("Todos");
        cbx_estado.addItem("Atendido");
        cbx_estado.addItem("No Atendido");
    }

    private void agregarListeners() {
        cbx_estado.addActionListener(e -> aplicarFiltros());
        cbx_paciente.addActionListener(e -> aplicarFiltros());
        cbx_especialidad.addActionListener(e -> aplicarFiltros());
        cbx_medico.addActionListener(e -> aplicarFiltros());
        cbx_fecha.addActionListener(e -> aplicarFiltros());
        txt_buscadorGlobal.addActionListener(e -> buscarGlobalmente());
    }

     private void buscarGlobalmente() {
        String textoBusqueda = txt_buscadorGlobal.getText().trim().toLowerCase();
        ArrayList<CitaModelo> citasFiltradas = CitaControlador.getInstancia().buscarGlobalmente(textoBusqueda);

        if (citasFiltradas.isEmpty()) {
            // Mostrar un mensaje en un JOptionPane si no se encontraron resultados
            JOptionPane.showMessageDialog(this, "No se encontraron resultados con el texto: " + textoBusqueda, "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Mostrar los resultados en la tabla
            actualizarTabla(citasFiltradas);
        }
    }

    private void actualizarEstadoCita() {
        int filaSeleccionada = tbl_listado.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener los datos de la cita seleccionada
            String cedulaPaciente = tbl_listado.getValueAt(filaSeleccionada, 0).toString();
            String fecha = tbl_listado.getValueAt(filaSeleccionada, 4).toString();
            String hora = tbl_listado.getValueAt(filaSeleccionada, 5).toString();

            // Obtener la cita seleccionada
            CitaModelo cita = CitaControlador.getInstancia().obtenerCita(cedulaPaciente, fecha, hora);
            
            if (cita != null) {
                String nuevoEstado = cita.getEstado().equals("Atendido") ? "No Atendido" : "Atendido";
                cita.setEstado(nuevoEstado);

                // Actualizar la tabla
                aplicarFiltros();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una cita para actualizar su estado.");
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbx_estado = new javax.swing.JComboBox<>();
        cbx_paciente = new javax.swing.JComboBox<>();
        cbx_especialidad = new javax.swing.JComboBox<>();
        cbx_medico = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbx_fecha = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_listado = new javax.swing.JTable();
        btn_actualizarEstado = new javax.swing.JButton();
        txt_buscadorGlobal = new javax.swing.JTextField();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Listado de Citas");

        jLabel2.setText("Filtrar ´por Estado:");

        jLabel3.setText("Filtrar por Paciente:");

        jLabel4.setText("Filtrar por Especialidades:");

        jLabel5.setText("Filtrar por Medico:");

        jLabel6.setText("Filtrar por fecha especifica:");

        jLabel7.setText("Buscador Global:");

        tbl_listado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbl_listado);

        btn_actualizarEstado.setText("Actualizar");
        btn_actualizarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(100, 100, 100)
                                        .addComponent(cbx_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel3))
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbx_paciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbx_medico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbx_fecha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbx_especialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_buscadorGlobal)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_actualizarEstado)
                        .addGap(20, 20, 20))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbx_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualizarEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbx_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbx_medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbx_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_buscadorGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarEstadoActionPerformed
     actualizarEstadoCita();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizarEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizarEstado;
    private javax.swing.JComboBox<String> cbx_especialidad;
    private javax.swing.JComboBox<String> cbx_estado;
    private javax.swing.JComboBox<String> cbx_fecha;
    private javax.swing.JComboBox<String> cbx_medico;
    private javax.swing.JComboBox<String> cbx_paciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tbl_listado;
    private javax.swing.JTextField txt_buscadorGlobal;
    // End of variables declaration//GEN-END:variables
}
