package DTO;

import java.io.Serializable;

public class AlumnoDTO implements Serializable{
    private String nombre;
    private String apellido;
    private String nombreCarrera;
    private String residencia;

        public AlumnoDTO(String nombre, String apellido, String nombreCarrera, String residencia) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.nombreCarrera = nombreCarrera;
            this.residencia = residencia;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }
}


