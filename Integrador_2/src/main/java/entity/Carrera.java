package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "idCarrera")
=======
    @Column(name="idCarrera")
>>>>>>> 8f8589fc80c8c448015d5eb2258d1bf7c34a5e93
    private int id;
    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<Carrera_inscripta> carrera_inscripta;

    public Carrera() {
        super();
    }

    public Carrera(int id, String nombre, List<Carrera_inscripta> carrera_inscripta) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.carrera_inscripta = carrera_inscripta;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Carrera_inscripta> getCarrera_inscripta() {
        return carrera_inscripta;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", carrera_inscripta=" + carrera_inscripta +
                '}';
    }
}
