package Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Main.Model.Alumno;
import Main.Repository.AlumnoRepository;


@RestController
@RequestMapping("/alumno")

 
public class AlumnoController {
	@Autowired 
	private AlumnoRepository alumnoRepository; 
	
	//recupero un alumno por su numero de libreta
    @GetMapping("/numero-libreta/{num}")
    public Alumno findByLibretaUniversitari(int num) {
    	return alumnoRepository.findByLibretaUniversitaria(num);
    }
    
    //recupero todos los alumnos de un determinado genero
    @GetMapping("/Genero/{genero}")
    public List<Alumno> findAllByGender(@PathVariable char genero){
    	return alumnoRepository.findAllByGender(genero);
    }
    
    //recupero todos los alumnos
    @GetMapping("/alumnos")
    public Iterable<Alumno> getAlumnos(){
    	return alumnoRepository.findAll();
    }
    
    //crear alumno
 	@PostMapping
 	public Alumno crearAlumno(@RequestBody Alumno alumno) {
 		return alumnoRepository.save(alumno);
 	}
	
}