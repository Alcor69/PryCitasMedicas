/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author rb940
 */
public class PacienteModelo {
    public String cedula;
    public String nombres;
    public int edad;
    public boolean sexo;

    public PacienteModelo(String cedula, String nombres, int edad, boolean sexo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
    
    public String getSexo() {
        return sexo?"Hombre":"Mujer";
    }
    
}
