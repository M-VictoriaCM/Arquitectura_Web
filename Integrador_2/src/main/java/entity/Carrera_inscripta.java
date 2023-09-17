package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrera_inscripta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int antiguedad;

    @Column(nullable = false)
    private boolean graduado;

    @ManyToOne
    @JoinColumn(name = "Carrera_idCarrera")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "Alumno_idAlumno")
    private Alumno alumno;

    public Carrera_inscripta(){
        super();
    }

    public Carrera_inscripta(int id, int antiguedad, boolean graduado, Carrera carrera, Alumno alumno) {
        super();
        this.id =id;
        this.antiguedad = antiguedad;
        this.graduado = graduado;
        this.carrera = carrera;
        this.alumno = alumno;
    }

    public int getId() {
        return id;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    @Override
    public String toString() {
        return "Carrera_inscripta{" +
                "antiguedad=" + antiguedad +
                ", graduado=" + graduado +
                ", carrera=" + carrera +
                ", alumno=" + alumno +
                '}';
    }
}
