/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModelo;

/**
 *
 * @author rb940
 */
public class EspecialidadControlador {
    ArrayList<EspecialidadModelo> especialidadModelos;
    public static EspecialidadControlador instancia;
    
    private EspecialidadControlador(){
        this.especialidadModelos = new ArrayList<>();
    }
    
    public static EspecialidadControlador getInstancia(){
        if (instancia == null) {
            instancia=new EspecialidadControlador();        
        }
        return instancia;
    }
    
    public EspecialidadModelo guardar(String nombre){
        EspecialidadModelo modelo = new EspecialidadModelo(nombre);
        especialidadModelos.add(modelo);
        return modelo;
        
    
    }

    public ArrayList<EspecialidadModelo> listado() {
       return especialidadModelos;
    }
    
    public EspecialidadModelo obtenerPorNombre(String nombre){
        for (EspecialidadModelo em : especialidadModelos) {
            if (em.getNombre().equals(nombre)) {
                return em;
                
            }
            
        }return null;
    }
     public boolean existeEspecialidad(String nombre) {
        for (EspecialidadModelo em : especialidadModelos) {
            if (em.getNombre().equalsIgnoreCase(nombre)) {
                return true; // Ya existe una especialidad con ese nombre
            }
        }
        return false; // No existe
    }
     public boolean eliminarEspecialidad(String nombre) {
    EspecialidadModelo especialidadAEliminar = null;
    
    // Buscar la especialidad en la lista
    for (EspecialidadModelo em : especialidadModelos) {
        if (em.getNombre().equalsIgnoreCase(nombre)) {
            especialidadAEliminar = em;
            break;
        }
    }
    
    // Si encontramos la especialidad, la eliminamos
    if (especialidadAEliminar != null) {
        especialidadModelos.remove(especialidadAEliminar);
        return true;
    }
    
    return false; // No se encontró la especialidad
}

}
