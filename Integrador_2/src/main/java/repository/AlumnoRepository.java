package repository;


import entity.Alumno;

import java.util.List;

public interface AlumnoRepository extends BaseRepository<Alumno, Integer> {
    //e) recuperar todos los estudiantes, en base a su género
    List<Alumno> findAllByGender(String genero);
}
