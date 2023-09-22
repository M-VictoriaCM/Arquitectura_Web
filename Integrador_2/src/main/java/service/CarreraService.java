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
                "WHERE c.nombre = :nombreCarrera " +
                "AND a.residencia = :ciudadResidencia", Object[].class);
        query.setParameter("nombreCarrera",nombreCarrera);
        query.setParameter("ciudadResidencia", ciudadResidencia);

        return query.getResultList();
    }
}

