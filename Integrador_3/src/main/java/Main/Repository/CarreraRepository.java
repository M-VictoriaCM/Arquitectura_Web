package Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Main.Model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer>{
	//Recupero una carrera por su nombre
	@Query("SELECT c FROM  Carrera c WHERE c.nombre = :nombre")
	public Carrera findByName(String nombre);
}
