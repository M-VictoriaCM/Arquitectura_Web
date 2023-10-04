package Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Main.DTO.CarreraDTO;

import Main.Model.Carrera;
import Main.Repository.CarreraRepository;
import Main.Service.CarreraService;

@RestController
@RequestMapping("/integrador_2")
public class CarreraController {
	@Autowired
	private CarreraRepository carreraRepository;
	
	//Referencia al servicio
	private final CarreraService carreraService;

    
    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }
		
	//Obtener todas las carreras
	@GetMapping("/carreras")
	public Iterable<Carrera>getAllCarreras(){
		return carreraRepository.findAll();
	}
	//Mostrar Carreras por id
	@GetMapping("/carreras/id/{id}")
	public Carrera encontrarPorId(@PathVariable int id) {
		return carreraRepository.findById(id).orElse(null);
	}
	//Crear una nueva carrera
	@PostMapping("/crearCarreraNueva")
	public Carrera crearCarrera(@RequestBody Carrera carrera) {
		return carreraRepository.save(carrera);
	}
	//Elimina una Carrera por ID
	@DeleteMapping("/eliminarCarrera/{id}")
	public void eliminarCarrera(@PathVariable int id) {
		carreraRepository.deleteById(id);
	}
	//Obtener todas las carreras ordenadas por cantidad de inscriptos
	@GetMapping("/cantidadInscriptosPorCarrera")
	public List<CarreraDTO> obtenerCantidadInscriptoPorCarrera() {
	     return carreraService.obtenerCantidadIncriptosPorCarrera();
	 }
	
}
