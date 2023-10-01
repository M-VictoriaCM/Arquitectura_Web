package Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Main.Model.Carrera;
import Main.Repository.CarreraRepository;

@RestController
@RequestMapping("/integrador_2")
public class CarreraController {
	@Autowired
	private CarreraRepository carreraRepository;
		
	//Obtener todas las carreras
	@GetMapping("/carreras")
	public Iterable<Carrera>getAllCarreras(){
		return carreraRepository.findAll();
	}
	//Mostrar Carreras por id
	@GetMapping("/idCarrera/{idCarrera}")
	public Carrera encontrarPorId(@PathVariable int id) {
		return carreraRepository.findById(id).orElse(null);
	}
	//Crear una nueva carrera
	@PostMapping
	public Carrera crearCarrera(@RequestBody Carrera carrera) {
		return carreraRepository.save(carrera);
	}
	//Elimina una Carrera por ID
	@DeleteMapping("/{idCarrera}")
	public void eliminarCarrera(@PathVariable int id) {
		carreraRepository.deleteById(id);
	}
	

}
