/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

/**
 *
 * @author rb940
 */
public class MedicoControlador {
    ArrayList<MedicoModelo> medicoModelos;
    private static MedicoControlador instancia;
    
    private MedicoControlador(){
        this.medicoModelos = new ArrayList<>();
    }
    public static MedicoControlador getInstancia(){
    if(instancia== null){
    instancia = new MedicoControlador();
    }
    return instancia;
    }
    public MedicoModelo guardar(EspecialidadModelo em , String cedula, String nombres, int edad, boolean sexo){
        MedicoModelo mm = new MedicoModelo(em, cedula, nombres, edad, sexo);
        medicoModelos.add(mm);
        return mm;
    }
    public ArrayList<MedicoModelo> listadoCompleto(){
       return medicoModelos;   
    }
    
    public ArrayList<MedicoModelo> listadoPorEspecialidad(String n_e){
        ArrayList<MedicoModelo> medicosPorEspecialidad = new ArrayList<>();
        for (MedicoModelo medico : medicoModelos) {
            if (medico.getEspecialidadModelo().getNombre().contains(n_e)) {
                medicosPorEspecialidad.add(medico);
            }
        }
        return medicosPorEspecialidad;
    }
    
    public MedicoModelo obtenerCedula(String cedula){
        for (MedicoModelo mm : medicoModelos) {
            if(mm.getCedula().equals(cedula)){
            return mm;
            }
        }
        return null;
    }
    public void editarMedico(MedicoModelo medico) {
        for (int i = 0; i < medicoModelos.size(); i++) {
            MedicoModelo m = medicoModelos.get(i);
            if (m.getCedula().equals(medico.getCedula())) {
                medicoModelos.set(i, medico); // Actualiza el médico en la lista
                break;
            }
        }
    }

    // Método para eliminar un médico
    public void eliminarMedico(MedicoModelo medico) {
        medicoModelos.remove(medico); // Elimina el médico de la lista
    }

    
}
