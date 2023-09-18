package repository;

import entity.Alumno;
import entity.Carrera_inscripta;

import java.util.List;

public class CarreraInscriptaRepositoryImpl implements CarreraInscriptaRepository{
    @Override
    public Carrera_inscripta save(Carrera_inscripta carrera_inscripta) {
        RepositoryFactory.getEntity_manager().getTransaction().begin();
        if(carrera_inscripta.getId() == 0){
            RepositoryFactory.getEntity_manager().persist(carrera_inscripta);
            RepositoryFactory.getEntity_manager().getTransaction().commit();
            RepositoryFactory.cerrar_conexion();
            return carrera_inscripta;
        }
        carrera_inscripta= RepositoryFactory.getEntity_manager().merge(carrera_inscripta);
        RepositoryFactory.getEntity_manager().getTransaction().commit();
        RepositoryFactory.cerrar_conexion();
        return carrera_inscripta;
    }

    @Override
    public void delete(Carrera_inscripta carrera_inscripta) {
        RepositoryFactory.getEntity_manager().remove(carrera_inscripta);
    }

    @Override
    public Carrera_inscripta findById(Integer id) {
        return RepositoryFactory.getEntity_manager().find(Carrera_inscripta.class, id);
    }

    @Override
    public List<Carrera_inscripta> findAll() {
        return RepositoryFactory.getEntity_manager().createQuery("SELECT c FROM Carrera_inscripta c", Carrera_inscripta.class)
                .getResultList();
    }
}
