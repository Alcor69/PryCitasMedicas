/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.EspecialidadModelo;

/**
 *
 * @author rb940
 */
public class EspecialidadControlador {
    private List<EspecialidadModelo> especialidades;
    private static EspecialidadControlador instancia;

    private EspecialidadControlador() {
        especialidades = new ArrayList<>();
    }

    public static EspecialidadControlador getInstancia() {
        if (instancia == null) {
            instancia = new EspecialidadControlador();
        }
        return instancia;
    }

    public void agregarEspecialidad(String id, String nombre) {
        EspecialidadModelo especialidad = new EspecialidadModelo(id, nombre);
        especialidades.add(especialidad);
    }

    public List<EspecialidadModelo> listarEspecialidades() {
        return especialidades;
    }

    public EspecialidadModelo buscarEspecialidadPorId(String id) {
        for (EspecialidadModelo especialidad : especialidades) {
            if (especialidad.getId().equals(id)) {
                return especialidad;
            }
        }
        return null;
    }
}
