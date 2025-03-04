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
    
        CitaModelo cm = new CitaModelo(pm, mm, em, descripcion, fecha, hora);//estas cagadas son argumentos
        
        citasModelo.add(cm);
        return cm;
    }
}
