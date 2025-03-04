/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

/**
 *
 * @author rb940
 */
public class CitaControlador {

    public ArrayList<CitaModelo> citasModelo;
    private static CitaControlador instancia;
    
    private CitaControlador(){
        citasModelo = new ArrayList<>();
    }
    
    public static CitaControlador getInstancia(){
        if (instancia == null) {
            instancia = new CitaControlador();
            
        }
        return instancia;
    };
    
    public CitaModelo guardar(
        PacienteModelo pm,
        MedicoModelo mm,
        EspecialidadModelo em,
        String descripcion, 
        String fecha,
        String hora
        ){
    
        CitaModelo cm = new CitaModelo(pm, mm, em, descripcion, fecha, hora, hora);//estas cagadas son argumentos
        
        citasModelo.add(cm);
        return cm;
    }
    public ArrayList<CitaModelo> listadoCompleto() {
        return citasModelo;
    }
    
    public ArrayList<CitaModelo> filtrarCitas(String estado, String paciente, String especialidad, String medico, String fecha) {
    ArrayList<CitaModelo> citasFiltradas = new ArrayList<>(citasModelo);

    if (!estado.equals("Todos")) {
        citasFiltradas.removeIf(cita -> !cita.getEstado().equals(estado));
    }

    if (!paciente.equals("Todos")) {
        citasFiltradas.removeIf(cita -> !cita.getPm().getCedula().equals(paciente.split(" ")[0]));

    }

    if (!especialidad.equals("Todas")) {
        citasFiltradas.removeIf(cita -> !cita.getEm().getNombre().equals(especialidad));
    }

    if (!medico.equals("Todos")) {
        citasFiltradas.removeIf(cita -> !cita.getMm().getCedula().equals(medico.split(" ")[0]));

    }

    if (!fecha.equals("Todas")) {
        citasFiltradas.removeIf(cita -> !cita.getFecha().equals(fecha));
    }

    return citasFiltradas;
}
     public ArrayList<CitaModelo> filtrarPorPaciente(String cedulaPaciente) {
        ArrayList<CitaModelo> citasFiltradas = new ArrayList<>();
        for (CitaModelo cita : citasModelo) {
            if (cita.getPm().getCedula().equals(cedulaPaciente)) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;
    }

    // Método para obtener citas por especialidad
    public ArrayList<CitaModelo> filtrarPorEspecialidad(String nombreEspecialidad) {
        ArrayList<CitaModelo> citasFiltradas = new ArrayList<>();
        for (CitaModelo cita : citasModelo) {
            if (cita.getEm().getNombre().equals(nombreEspecialidad)) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;
    }

    // Método para obtener citas por médico
    public ArrayList<CitaModelo> filtrarPorMedico(String cedulaMedico) {
        ArrayList<CitaModelo> citasFiltradas = new ArrayList<>();
        for (CitaModelo cita : citasModelo) {
            if (cita.getMm().getCedula().equals(cedulaMedico)) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;
    }

    // Método para obtener citas por fecha
    public ArrayList<CitaModelo> filtrarPorFecha(String fecha) {
        ArrayList<CitaModelo> citasFiltradas = new ArrayList<>();
        for (CitaModelo cita : citasModelo) {
            if (cita.getFecha().equals(fecha)) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;
    }

    // Método para obtener citas por estado
    public ArrayList<CitaModelo> filtrarPorEstado(String estado) {
        ArrayList<CitaModelo> citasFiltradas = new ArrayList<>();
        for (CitaModelo cita : citasModelo) {
            if (cita.getEstado().equals(estado)) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;
    }
    public CitaModelo obtenerCita(String cedulaPaciente, String fecha, String hora) {
    for (CitaModelo cita : citasModelo) {
        if (cita.getPm().getCedula().equals(cedulaPaciente) &&
            cita.getFecha().equals(fecha) &&
            cita.getHora().equals(hora)) {
            return cita;
        }
    }
    return null; // Si no se encuentra la cita
}
    public ArrayList<CitaModelo> buscarGlobalmente(String textoBusqueda) {
    ArrayList<CitaModelo> citasFiltradas = new ArrayList<>();
    for (CitaModelo cita : citasModelo) {
        // Buscar en todos los campos relevantes
        if (cita.getPm().getNombres().toLowerCase().contains(textoBusqueda) || // Nombre del paciente
            cita.getPm().getCedula().toLowerCase().contains(textoBusqueda) || // Cédula del paciente
            cita.getMm().getNombres().toLowerCase().contains(textoBusqueda) || // Nombre del médico
            cita.getMm().getCedula().toLowerCase().contains(textoBusqueda) || // Cédula del médico
            cita.getEm().getNombre().toLowerCase().contains(textoBusqueda) ||  // Especialidad
            cita.getFecha().toLowerCase().contains(textoBusqueda) ||          // Fecha
            cita.getHora().toLowerCase().contains(textoBusqueda) ||           // Hora
            cita.getEstado().toLowerCase().contains(textoBusqueda)) {         // Estado
            citasFiltradas.add(cita);
        }
    }
    return citasFiltradas;
}
    
    
}
