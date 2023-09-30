package Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Main.Model.Alumno;
import Main.Repository.AlumnoRepository;


@RestController
@RequestMapping("/integrador_2")

 
public class AlumnoController {
	@Autowired 
	private AlumnoRepository alumnoRepository; 
	
	//recupero un alumno por su numero de libreta
    @GetMapping("/libreta/{num_libreta_un}")
    public Alumno findByLibretaUniversitari(@PathVariable int num_libreta_un) {
    	return alumnoRepository.findByLibretaUniversitaria(num_libreta_un);
    }
    
    //recupero todos los alumnos de un determinado genero
    @GetMapping("/genero/{genero}")
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