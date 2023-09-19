package repository;


import entity.Alumno;

public interface AlumnoRepository extends BaseRepository<Alumno, Integer> {

    Alumno findByLibretaUniversitaria(int numeroLibreta);
}
