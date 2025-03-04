/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prycitasmedicas;

import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteControlador;
import modelo.EspecialidadModelo;
import vista.PantallaPrincipal;

/**
 *
 * @author rb940
 */
public class PryCitasMedicas {

    public static void main(String[] args) {
        PacienteControlador pc = PacienteControlador.getInstancia();
        pc.guardarDatos("1754148961", "Dario ", 19, true);
        pc.guardarDatos("1852456256", "Jonathan", 18, true);
        pc.guardarDatos("17547855251", "Elian ", 19, true);
        pc.guardarDatos("18524955456", "Jonathan ", 19, true);
        
        EspecialidadControlador ec = EspecialidadControlador.getInstancia();
        EspecialidadModelo em1 = ec.guardar("Medicina ");
        EspecialidadModelo em2 = ec.guardar("Traumatología");
        EspecialidadModelo em3 = ec.guardar("Pediatria");
        
        MedicoControlador mc = MedicoControlador.getInstancia();
        mc.guardar(em1, "1547798494", "Juan ", 48, true);
        mc.guardar(em2, "94789741616", "Lalo ", 56, true);
        mc.guardar(em3, "14782552558", "Juan ", 48, true);
        
        
        PantallaPrincipal pp = new PantallaPrincipal();
        pp.setVisible(true);
        pp.setLocationRelativeTo(null);
    }
}
