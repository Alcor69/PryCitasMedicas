/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author rb940
 */
public class MedicoModelo extends PacienteModelo {
    public EspecialidadModelo especialidadModelo;

    public MedicoModelo(EspecialidadModelo especialidadModelo, String cedula, String nombres, int edad, boolean sexo) {
        super(cedula, nombres, edad, sexo);
        this.especialidadModelo = especialidadModelo;
    }

    public EspecialidadModelo getEspecialidadModelo() {
        return especialidadModelo;
    }

    public void setEspecialidadModelo(EspecialidadModelo especialidadModelo) {
        this.especialidadModelo = especialidadModelo;
    }
    
    public String GetEspecialidadmodelo(){
            return this.especialidadModelo.getNombre();
    }

    

    
   

}