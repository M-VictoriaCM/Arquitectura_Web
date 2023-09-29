package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Model.Alumno;
import Repository.AlumnoRepository;


@RestController
@RequestMapping("/alumno")

 
public class AlumnoController {
	@Autowired 
	private AlumnoRepository alumnoRepository; 
	
	//recupero un alumno por su numero de libreta
    @GetMapping("/numero-libreta")
    public Alumno findByLibretaUniversitari(int num) {
    	return alumnoRepository.findByLibretaUniversitaria(num);
    }
    
    //recupero todos los alumnos de un determinado genero
    @GetMapping("/genero")
    public List<Alumno> findAllByGender(char genero){
    	return alumnoRepository.findAllByGender(genero);
    }
	
}