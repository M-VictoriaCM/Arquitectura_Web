package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Carrera_inscripta {

    @Column(nullable = false)
    private int antiguedad;
    @Column(nullable = false)
    private boolean graduado;

    @ManyToOne
    @JoinColumn(name = "Carrera_idCarrera")
    private List<Carrera> carreras;

    @ManyToOne
    @JoinColumn(name = "Alumno_idAlumno")
    private Alumno alumno;

    public Carrera_inscripta(){
        super();
    }

    public Carrera_inscripta(int antiguedad, boolean graduado, List<Carrera> carreras, Alumno alumno) {
        super();
        this.antiguedad = antiguedad;
        this.graduado = graduado;
        this.carreras = carreras;
        this.alumno = alumno;
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

    public void addCarrera(Carrera c){
        if (!carreras.contains(c)){
            carreras.add(c);
        }
    }
    public List<Carrera> getCarrera() {
        return carreras;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    @Override
    public String toString() {
        return "Carrera_inscripta{" +
                "antiguedad=" + antiguedad +
                ", graduado=" + graduado +
                '}';
    }
}
