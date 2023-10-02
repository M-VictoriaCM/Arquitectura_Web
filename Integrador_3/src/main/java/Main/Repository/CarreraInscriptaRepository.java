package Main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Main.DTO.AlumnoDTO;
import Main.DTO.ReporteCarreraDTO;
import Main.Model.Carrera_inscripta;

@Repository
public interface CarreraInscriptaRepository extends JpaRepository<Carrera_inscripta, Integer>{
	
	//g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
	@Query("SELECT NEW Main.DTO.AlumnoDTO(a.nombre, a.apellido, c.nombre, a.residencia) " +
	           "FROM Carrera_inscripta ci " +
	           "JOIN ci.alumno a " + 
	           "JOIN ci.carrera c " + 
	           "WHERE c.nombre = :nombreCarrera "  +
	           "AND a.residencia = :ciudadResidencia")
	    List<AlumnoDTO> obtenerEstudiantePorCarreraYCiudad(String nombreCarrera, String ciudadResidencia);
	
	/*Ejercicio 3:
	    * Generar un reporte de las carreras, que para cada carrera incluya información de los
	    * inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
	    * los años de manera cronológica
	    */
	@Query("SELECT NEW Main.DTO.ReporteCarreraDTO(ci.anio_de_inscripcion AS año_de_inscripcion, " +
	           "a.num_libreta_un AS libreta, " +
	           "a.apellido AS apellidoAlumno, " +
	           "a.nombre AS nombreAlumno, " +
	           "c.nombre AS nombreCarrera, " +
	           "ci.anio_graduacion AS añoGraduado, " +
	           "COUNT(ci) AS inscriptos, " +
	           "SUM(CASE WHEN ci.graduado = true THEN 1 ELSE 0 END) AS egresados) " +
	           "FROM Carrera_inscripta ci " +
	           "JOIN ci.alumno a " +
	           "JOIN ci.carrera c " +
	           "WHERE c.nombre IN (" +
	           "    SELECT DISTINCT c2.nombre " +
	           "    FROM Carrera_inscripta ci2 JOIN ci2.carrera c2) " +
	           "GROUP BY c.nombre, ci.anio_graduacion " +
	           "ORDER BY c.nombre ASC, ci.anio_de_inscripcion ASC")
	    List<ReporteCarreraDTO> obtenerReporteDeCarreras();
}
