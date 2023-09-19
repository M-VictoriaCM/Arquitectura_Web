package repository;


import entity.Alumno;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlumnoRepositoryImpl implements AlumnoRepository {
    public static AlumnoRepositoryImpl instance = new AlumnoRepositoryImpl();

    public AlumnoRepositoryImpl() {
    }

    public static AlumnoRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public Alumno save(Alumno alumno) {
        RepositoryFactory.getEntity_manager().getTransaction().begin();
        if(alumno.getId() == 0){
            RepositoryFactory.getEntity_manager().persist(alumno);
            RepositoryFactory.getEntity_manager().getTransaction().commit();
            RepositoryFactory.cerrar_conexion();
            return alumno;
        }
        alumno= RepositoryFactory.getEntity_manager().merge(alumno);
        RepositoryFactory.getEntity_manager().getTransaction().commit();
        RepositoryFactory.cerrar_conexion();
        return alumno;
    }

    @Override
    public void delete(Alumno alumno) {
        RepositoryFactory.getEntity_manager().remove(alumno);
    }

    @Override
    public Alumno findById(Integer id) {
        return RepositoryFactory.getEntity_manager().find(Alumno.class, id);
    }

    @Override
    public List<Alumno> findAll() {
        return RepositoryFactory.getEntity_manager().createQuery("SELECT a FROM Alumno a ORDER BY a.apellido ASC", Alumno.class)
                .getResultList();
    }

    @Override
    public void insert(Alumno alumno) {
        RepositoryFactory.getEntity_manager().getTransaction().begin();
        RepositoryFactory.getEntity_manager().createNativeQuery("INSERT INTO alumno (nombre, apellido, edad, genero, dni, residencia, num_libreta_un) VALUES (?,?,?,?,?,?,?)")
                .setParameter(1, alumno.getNombre())
                .setParameter(2,alumno.getApellido())
                .setParameter(3,alumno.getEdad())
                .setParameter(4,alumno.getGenero())
                .setParameter(5,alumno.getDni())
                .setParameter(6,alumno.getResidencia())
                .setParameter(7,alumno.getNum_libreta_un())
                .executeUpdate();
        RepositoryFactory.getEntity_manager().getTransaction().commit();

    }

    @Override
    public Alumno findByLibretaUniversitaria(int num_libreta_un) {
        try {
            TypedQuery<Alumno> query = RepositoryFactory.getEntity_manager().createQuery("SELECT a FROM Alumno a WHERE a.num_libreta_un = :num_libreta_un", Alumno.class)
                    .setParameter("num_libreta_un", num_libreta_un);

            return query.getSingleResult();
        } catch (NoResultException e) {
            // Manejar la excepción o devolver un valor por defecto, por ejemplo, null
            return null;
        }
    }
}
