package repository;


import entity.Alumno;

import java.util.List;

public interface AlumnoRepository extends BaseRepository<Alumno, Integer> {
        Alumno findByLibretaUniversitaria(int numeroLibreta);
        //e) recuperar todos los estudiantes, en base a su género
    L   ist<Alumno> findAllByGender(String genero);
}
