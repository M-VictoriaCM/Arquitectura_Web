package repository;


import entity.Carrera;

public interface CarreraRepository extends BaseRepository<Carrera, Integer> {
    Carrera save(Carrera carrera);
    void delete(Carrera carrera);
}
