package Main.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCarrera")
    private int id;
    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<Carrera_inscripta> carrera_inscripta;

    public Carrera() {
        super();
    }

    public Carrera(String nombre) {
        super();
        this.nombre = nombre;
        this.carrera_inscripta = new ArrayList<>();
    }

    public void addCarrera(Carrera_inscripta c){
        if (!carrera_inscripta.contains(c)){
            carrera_inscripta.add(c);
        }
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


    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
