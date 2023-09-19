package repository;


import entity.Alumno;

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
        return RepositoryFactory.getEntity_manager()
                .createQuery("SELECT a FROM Alumno a", Alumno.class)
                .getResultList();
    }
    //e) recuperar todos los estudiantes, en base a su género
    @Override
    public List<Alumno> findAllByGender(String genero) {
        return RepositoryFactory.getEntity_manager()
                .createQuery("SELECT a FROM Alumno a WHERE a.genero = :genero", Alumno.class)
                .setParameter("genero", genero)
                .getResultList();
    }


}
