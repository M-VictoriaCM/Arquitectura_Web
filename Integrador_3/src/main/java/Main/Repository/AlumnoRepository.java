package Main.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Main.Model.Alumno;
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	
	//recupero un alumno por su numero de libreta
	@Query("SELECT a FROM Alumno a where a.num_libreta_un = :num_libreta_un")
    public Alumno findByLibretaUniversitaria(int num_libreta_un);
	
	//recupero todos los alumnos de un determinado genero
	@Query("SELECT a FROM Alumno a where a.genero = :genero")
	public List<Alumno> findAllByGender (char genero);

	
	
}
