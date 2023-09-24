package service;

import DTO.AlumnoDTO;
import DTO.CarreraDTO;
import DTO.ReporteCarreraDTO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarreraService {
    private EntityManager entityManager;

    public CarreraService(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    public List<CarreraDTO> obtenerCantidadInscriptoPorCarrera(){
        TypedQuery<CarreraDTO> query = entityManager.createQuery(
                "SELECT NEW DTO.CarreraDTO(c.nombre, COUNT(ci)) "+
                "FROM Carrera c " +
                "LEFT JOIN Carrera_inscripta ci ON ci.carrera =c " +
                "GROUP BY c.nombre " +
                "ORDER BY COUNT(ci) DESC ", CarreraDTO.class);

        List<CarreraDTO>carrerasDTO = query.getResultList();
        return carrerasDTO ;
    }
    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    public List<AlumnoDTO> obtenerEstudiantePorCarreraYCiudad(String nombreCarrera, String ciudadResidencia) {
        TypedQuery<AlumnoDTO>query = entityManager.createQuery(
                "SELECT NEW DTO.AlumnoDTO(a.nombre, a.apellido, c.nombre, a.residencia) " +
                "FROM Carrera_inscripta ci " +
                "JOIN ci.alumno a " + 
                "JOIN ci.carrera c " + 
                "WHERE c.nombre = :nombreCarrera "  +
                "AND a.residencia = :ciudadResidencia", AlumnoDTO.class);
        query.setParameter("nombreCarrera",nombreCarrera);
        query.setParameter("ciudadResidencia", ciudadResidencia);

        return query.getResultList();
    }

    /*Ejercicio 3:
    * Generar un reporte de las carreras, que para cada carrera incluya información de los
    * inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
    * los años de manera cronológica
    */
    public List<ReporteCarreraDTO> obtenerReporteDeCarreras() {
        TypedQuery<ReporteCarreraDTO>query = entityManager.createQuery(
            "SELECT NEW DTO.ReporteCarreraDTO(ci.anio_de_inscripcion AS año_de_inscripcion," +
                "a.num_libreta_un AS libreta," +
                "a.apellido AS apellidoAlumno," +
                "a.nombre AS nombreAlumno," +
                "c.nombre AS nombreCarrera," +
                "ci.anio_graduacion AS añoGraduado," +
                "COUNT(ci) AS inscriptos," +
                "SUM(CASE WHEN ci.graduado = true THEN 1 ELSE 0 END) AS egresados)" +
                "FROM Carrera_inscripta ci " +
                "JOIN ci.alumno a " +
                "JOIN ci.carrera c " +
                "WHERE c.nombre IN( " +
                    "SELECT DISTINCT c2.nombre " +
                    "FROM Carrera_inscripta ci2 JOIN ci2.carrera c2) "+
                "GROUP BY c.nombre, ci.anio_graduacion " +
                "ORDER BY c.nombre  ASC,ci.anio_de_inscripcion ASC", ReporteCarreraDTO.class);

        List<ReporteCarreraDTO>reporte = query.getResultList();
        return reporte;
    }
}

