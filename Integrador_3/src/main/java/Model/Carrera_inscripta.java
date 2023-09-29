package Model;

import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
public class Carrera_inscripta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCarreraInscripta")
    private int id;

    @Column(nullable = false)
    private Timestamp anio_de_inscripcion;

    @Column(nullable = false)
    private int antiguedad;

    @Column(nullable = false)
    private boolean graduado;

    @Column
    private Timestamp anio_graduacion;

    @ManyToOne
    @JoinColumn(name = "Carrera_idCarrera")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "Alumno_idAlumno")
    private Alumno alumno;

    public Carrera_inscripta(){
        super();
    }

    public Carrera_inscripta(int antiguedad, boolean graduado, Carrera carrera, Alumno alumno) {
        super();
        this.anio_de_inscripcion = new Timestamp(System.currentTimeMillis());
        this.antiguedad = antiguedad;
        this.graduado = graduado;
        this.carrera = carrera;
        this.alumno = alumno;
        this.anio_graduacion=null;
    }

    public Timestamp getAnio_de_inscripcion() {
        return anio_de_inscripcion;
    }

    public Timestamp getAnio_graduacion() {
        return anio_graduacion;
    }

    public void setAnio_graduacion(Timestamp anio_graduacion) {
        this.anio_graduacion = anio_graduacion;
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
                "id=" + id +
                ", antiguedad=" + antiguedad +
                ", graduado=" + graduado +
                ", anio_graduacion=" + anio_graduacion +
                '}';
    }
}
