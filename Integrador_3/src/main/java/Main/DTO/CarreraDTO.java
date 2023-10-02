package Main.DTO;


public class CarreraDTO{
    private String nombreCarrera;
    private Long cantidadInscriptos;

    public CarreraDTO() {
    }

    public CarreraDTO(String nombreCarrera, Long cantidadInscriptos) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Long getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(Long cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }
}
