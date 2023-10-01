package Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Main.Model.Carrera_inscripta;

@Repository
public interface CarreraInscriptaRepository extends JpaRepository<Carrera_inscripta, Integer>{
	//Consultas personalizadas
}
