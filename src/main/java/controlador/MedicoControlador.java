/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.MedicoModelo;

/**
 *
 * @author rb940
 */
public class MedicoControlador {
    private List<MedicoModelo> medicos;
    private static MedicoControlador instancia;

    private MedicoControlador() {
        medicos = new ArrayList<>();
    }

    public static MedicoControlador getInstancia() {
        if (instancia == null) {
            instancia = new MedicoControlador();
        }
        return instancia;
    }

    public void agregarMedico(String id, String nombres, String especialidad) {
        MedicoModelo medico = new MedicoModelo(id, nombres, especialidad);
        medicos.add(medico);
    }

    public List<MedicoModelo> listarMedicos() {
        return medicos;
    }

    public MedicoModelo buscarMedicoPorId(String id) {
        for (MedicoModelo medico : medicos) {
            if (medico.getId().equals(id)) {
                return medico;
            }
        }
        return null;
    }
}
