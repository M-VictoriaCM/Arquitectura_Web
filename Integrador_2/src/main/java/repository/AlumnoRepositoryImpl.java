package repository;


import entity.Alumno;

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
}
