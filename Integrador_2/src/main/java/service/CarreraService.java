package service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarreraService {
    private EntityManager entityManager;

    public CarreraService(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    public List<Object[]> obtenerCantidadInscriptoPorCarrera(){
        TypedQuery<Object[]> query = entityManager.createQuery("" +
                "SELECT c.nombre AS nombreCarrera, " +
                "       (SELECT COUNT(ci) " +
                "       FROM Carrera_inscripta ci " +
                "        WHERE ci.carrera = c) AS cantidadInscriptos " +
                "FROM Carrera c " +
                "ORDER BY cantidadInscriptos DESC", Object[].class);
        return query.getResultList();
    }
    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    public List<Object[]> obtenerEstudiantePorCarreraYCiudad(String nombreCarrera, String ciudadResidencia) {
        TypedQuery<Object[]>query = entityManager.createQuery(
                "SELECT a.nombre, a.apellido, c.nombre, a.residencia " +
                "FROM Carrera_inscripta ci " +
                "JOIN ci.alumno a " + 
                "JOIN ci.carrera c " + 
                "WHERE c.nombre = :nombreCarrera "  +
                "AND a.residencia = :ciudadResidencia", Object[].class);
        query.setParameter("nombreCarrera",nombreCarrera);
        query.setParameter("ciudadResidencia", ciudadResidencia);

        return query.getResultList();
    }

    /*Ejercicio 3:
    * Generar un reporte de las carreras, que para cada carrera incluya información de los
    * inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
    * los años de manera cronológica
    */
    public List<Object[]> obtenerReporteDeCarreras() {
        TypedQuery<Object[]>query = entityManager.createQuery(
                "SELECT a.num_libreta_un AS libreta," +
                    "a.nombre AS nombreAlumno," +
                    "a.apellido AS apellidoAlumno," +
                    "c.nombre AS nombreCarrera," +
                    "ci.anio_graduacion AS añoGraduado," +
                    "COUNT(DISTINCT ci) AS inscriptos," +
                    "SUM(CASE WHEN ci.graduado = true THEN 1 ELSE 0 END) AS egresados " +
                    "FROM Carrera_inscripta ci " +
                    "LEFT JOIN ci.alumno a " +
                    "LEFT JOIN ci.carrera c " +
                    "GROUP BY c.nombre, ci.anio_graduacion, a.nombre, a.apellido " +
                    "ORDER BY c.nombre ASC, ci.anio_graduacion ASC",Object[].class);
        return query.getResultList();
    }
}

