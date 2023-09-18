package repository;

import entity.Alumno;
import entity.Carrera;

import java.util.List;

public class CarreraRepositoryImpl implements CarreraRepository {
    public static CarreraRepositoryImpl instance = new CarreraRepositoryImpl();

    public CarreraRepositoryImpl() {
    }

    public static CarreraRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public Carrera save(Carrera carrera) {
        RepositoryFactory.getEntity_manager().getTransaction().begin();
        if(carrera.getId() == 0){
            RepositoryFactory.getEntity_manager().persist(carrera);
            RepositoryFactory.getEntity_manager().getTransaction().commit();
            RepositoryFactory.cerrar_conexion();
            return carrera;
        }
        carrera= RepositoryFactory.getEntity_manager().merge(carrera);
        RepositoryFactory.getEntity_manager().getTransaction().commit();
        RepositoryFactory.cerrar_conexion();
        return carrera;
    }

    @Override
    public void delete(Carrera carrera) {
        RepositoryFactory.getEntity_manager().remove(carrera);
    }

    @Override
    public Carrera findById(Integer id) {
        return RepositoryFactory.getEntity_manager().find(Carrera.class, id);
    }

    @Override
    public List<Carrera> findAll() {
        return RepositoryFactory.getEntity_manager().createQuery("SELECT c FROM Carrera c", Carrera.class)
                .getResultList();
    }

}
