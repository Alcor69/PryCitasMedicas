/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.medicos;

import controlador.MedicoControlador;
import javax.swing.table.DefaultTableModel;
import modelo.MedicoModelo;

/**
 *
 * @author rb940
 */
public class Listado extends javax.swing.JInternalFrame {
    public DefaultTableModel tableModel = new DefaultTableModel();
    public MedicoControlador mc = MedicoControlador.getInstancia();

    /**
     * Creates new form Listado
     */
    public Listado() {
        initComponents();
        
        tbl_listado.setModel(tableModel);
        String columnas[]={"CEDULA", "NOMBRES", "EDAD", "sexo", "ESPECIALIDAD"};
        tableModel.addColumn(columnas[0]);
        tableModel.addColumn(columnas[1]);
        tableModel.addColumn(columnas[2]);
        tableModel.addColumn(columnas[3]);
        tableModel.addColumn(columnas[4]);
        
        cargarListadoMedicos();
    }
    private void cargarListadoMedicos(){
    for (MedicoModelo mm : mc.listadoCompleto()) {
            Object[] fila = {mm.getCedula(), mm.getNombres(), mm.getEdad(), mm.getSexo(), mm.GetEspecialidadmodelo()};
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
        jLabel2 = new javax.swing.JLabel();
        txt_buscarPorCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_listado = new javax.swing.JTable();

        jLabel1.setText("Listado de Personas");

        jLabel2.setText("Buscar por Cedula");

        txt_buscarPorCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarPorCedulaActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tbl_listado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_buscarPorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_buscarPorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarPorCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarPorCedulaActionPerformed
    

        // TODO add your handling code here:
       // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarPorCedulaActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_listado;
    private javax.swing.JTextField txt_buscarPorCedula;
    // End of variables declaration//GEN-END:variables
}
