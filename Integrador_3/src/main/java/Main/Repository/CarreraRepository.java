package Main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Main.DTO.CarreraDTO;
import Main.Model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer>{
	//Recupero una carrera por su nombre
	@Query("SELECT c FROM  Carrera c WHERE c.nombre = :nombre")
	public Carrera findByName(String nombre);
	
	//f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
	@Query("SELECT NEW Main.DTO.CarreraDTO(c.nombre, COUNT(ci)) " +
	           "FROM Carrera c " +
	           "LEFT JOIN c.carrera_inscripta ci " +
	           "GROUP BY c.nombre " +
	           "ORDER BY COUNT(ci) DESC")
	    List<CarreraDTO> obtenerCantidadInscriptoPorCarrera();
	
	
}
