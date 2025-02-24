/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import modelo.PacienteModelo;
import modelo.TurnoModelo;

/**
 *
 * @author rb940
 */
public class TurnoControlador {
    private ArrayList<TurnoModelo> turnos;
    private static TurnoControlador instancia;

    private TurnoControlador() {
        this.turnos = new ArrayList<>();
    }

    public static TurnoControlador getInstancia() {
        if (instancia == null) {
            instancia = new TurnoControlador();
        }
        return instancia;
    }

    public void agregarTurno(String id, PacienteModelo paciente, Date fecha, String hora) {
        TurnoModelo turno = new TurnoModelo(id, paciente, fecha, hora);
        turnos.add(turno);
    }

    public ArrayList<TurnoModelo> listarTurnos() {
        return turnos;
    }

    public boolean existeTurnoParaPacienteEnFecha(PacienteModelo paciente, Date fecha) {
        for (TurnoModelo turno : turnos) {
            if (turno.getPaciente().equals(paciente) && turno.getFecha().equals(fecha)) {
                return true;
            }
        }
        return false;
    }
}