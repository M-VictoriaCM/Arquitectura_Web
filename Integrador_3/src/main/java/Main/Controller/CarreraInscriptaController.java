package Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Main.Model.Carrera_inscripta;
import Main.Repository.CarreraInscriptaRepository;

@RestController
@RequestMapping("/integrador_2")
public class CarreraInscriptaController {
	@Autowired 
	private CarreraInscriptaRepository carreraInscriptaRepository;
	
	//Recupero todas las carreras con alumnos inscriptos
	@GetMapping("/carrera_inscripta")
	public Iterable<Carrera_inscripta>getAllCarreraInscripta(){
		return carreraInscriptaRepository.findAll();
	}
	//Mostrar carrerasinscriptas por ID
	@GetMapping("/idCarrera_inscripta/{idCarrera_inscripta}")
	public Carrera_inscripta encontrarPoId(@PathVariable int id) {
		return carreraInscriptaRepository.findById(id).orElse(null);
	}
	//Eliminar una carrera por ID
	@DeleteMapping("/{idCarreraInscripta}")
	public void elimnarCarreraInscripta(@PathVariable int id) {
		carreraInscriptaRepository.deleteById(id);
	}
	
	//crear Carrera_inscripta
	@PostMapping
	public Carrera_inscripta crearCarreraInscripta(@RequestBody Carrera_inscripta carrera) {
		return carreraInscriptaRepository.save(carrera);
	}
	
}
