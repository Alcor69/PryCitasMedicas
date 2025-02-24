/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.PacienteModelo;

/**
 *
 * @author rb940
 */
public class PacienteControlador {
    public ArrayList<PacienteModelo> pacienteModelosLista;
    private static PacienteControlador instancia;
    
    
    public PacienteControlador() {
        this.pacienteModelosLista = new ArrayList<>();
    }
    
    
    public static PacienteControlador getInstancia(){
        if(instancia== null){
            instancia=new PacienteControlador();
        }
        return instancia;
    
    }

    
    public PacienteModelo guardarDatos(String cedula, String nombre, int edad, boolean sexo){
        PacienteModelo modeloPaciente = new PacienteModelo(cedula, nombre, edad, sexo);
        pacienteModelosLista.add(modeloPaciente);
        return modeloPaciente;
        
    }
    
    public ArrayList<PacienteModelo>listadoCompleto(){
    return pacienteModelosLista;
    }
    
    public ArrayList<PacienteModelo>listadoCompletoporCedula(String cedula){
    ArrayList <PacienteModelo> nuevoListado =new ArrayList<>();
        for (PacienteModelo pacienteModelo : pacienteModelosLista) {
            if(pacienteModelo.getCedula().contains(cedula)){
                nuevoListado.add(pacienteModelo);
                
            }
        }
        return nuevoListado;
    }
     public void agregarPaciente(String cedula, String nombres, int edad, boolean sexo) {
        PacienteModelo paciente = new PacienteModelo(cedula, nombres, edad, sexo);
        pacienteModelosLista.add(paciente);
    }

    // Método para buscar un paciente por cédula
    public PacienteModelo buscarPacientePorCedula(String cedula) {
        for (PacienteModelo paciente : pacienteModelosLista) {
            if (paciente.getCedula().equals(cedula)) {
                return paciente;
            }
        }
        return null; // Si no se encuentra el paciente
    }

    // Método para obtener todos los pacientes
    public List<PacienteModelo> obtenerTodosLosPacientes() {
        return pacienteModelosLista;
    }

    // Método para eliminar un paciente por cédula
    public boolean eliminarPacientePorCedula(String cedula) {
        PacienteModelo paciente = buscarPacientePorCedula(cedula);
        if (paciente != null) {
            pacienteModelosLista.remove(paciente);
            return true; // Paciente eliminado
        }
        return false; // Paciente no encontrado
    }       
}
