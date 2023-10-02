package Main.DTO;


import java.util.Date;

public class ReporteCarreraDTO{
    private Date anio_de_inscripcion;
    private int libreta;
    private String apellidoAlumno;
    private String nombreAlumno;
    private String nombreCarrera;
    private Date anioGraduado;
    private Long inscripto;
    private Long egresado;

    public ReporteCarreraDTO() {
    }

    public ReporteCarreraDTO(Date anio_de_inscripcion, int libreta, String apellidoAlumno, String nombreAlumno, String nombreCarrera, Date anioGraduado, Long inscripto, Long egresado) {
        this.anio_de_inscripcion = anio_de_inscripcion;
        this.libreta = libreta;
        this.apellidoAlumno = apellidoAlumno;
        this.nombreAlumno = nombreAlumno;
        this.nombreCarrera = nombreCarrera;
        this.anioGraduado = anioGraduado;
        this.inscripto = inscripto;
        this.egresado = egresado;
    }

    public Date getAnio_de_inscripcion() {
        return anio_de_inscripcion;
    }

    public void setAnio_de_inscripcion(Date anio_de_inscripcion) {
        this.anio_de_inscripcion = anio_de_inscripcion;
    }

    public int getLibreta() {
        return libreta;
    }

    public void setLibreta(int libreta) {
        this.libreta = libreta;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Date getAnioGraduado() {
        return anioGraduado;
    }

    public void setAnioGraduado(Date anioGraduado) {
        this.anioGraduado = anioGraduado;
    }

    public Long getInscripto() {
        return inscripto;
    }

    public void setInscripto(Long inscripto) {
        this.inscripto = inscripto;
    }

    public Long getEgresado() {
        return egresado;
    }

    public void setEgresado(Long egresado) {
        this.egresado = egresado;
    }
}
