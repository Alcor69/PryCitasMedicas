/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date; //para que de la fecha real de la compu

/**
 *
 * @author rb940
 */
public class TurnoModelo {
    private String id;
    private PacienteModelo paciente;
    private Date fecha;
    private String hora;

    public TurnoModelo(String id, PacienteModelo paciente, Date fecha, String hora) {
        this.id = id;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PacienteModelo getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModelo paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
