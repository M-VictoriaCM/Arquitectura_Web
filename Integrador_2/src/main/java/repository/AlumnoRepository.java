package repository;


import entity.Alumno;

public interface AlumnoRepository extends BaseRepository<Alumno, Integer> {
    Alumno save(Alumno alumno);
}
