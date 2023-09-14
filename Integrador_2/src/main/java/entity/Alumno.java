package entity;
import javax.persistence.*;


@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private int edad;
    @Column(nullable = false)
    private char genero;
    @Column(nullable = false)
    private int dni;
    @Column(nullable = false)
    private String residencia;
    @Column(nullable = false)
    private int num_libreta_un;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "carreras_inscriptas")
    private Carrera carreras_inscriptas;

    public Alumno() {
        super();
    }

    public Alumno(int id, String nombre, String apellido, int edad, char genero, int dni, String residencia, int num_libreta_un, Carrera carreras_inscriptas) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.residencia = residencia;
        this.num_libreta_un = num_libreta_un;
        this.carreras_inscriptas = carreras_inscriptas;
    }

    public int getId() {
        return id;
    }

    public Carrera getCarreras_inscriptas() {
        return carreras_inscriptas;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public int getNum_libreta_un() {
        return num_libreta_un;
    }

    public void setNum_libreta_un(int num_libreta_un) {
        this.num_libreta_un = num_libreta_un;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                ", dni=" + dni +
                ", residencia='" + residencia + '\'' +
                ", num_libreta_un=" + num_libreta_un +
                ", carreras_inscriptas=" + carreras_inscriptas +
                '}';
    }
}
