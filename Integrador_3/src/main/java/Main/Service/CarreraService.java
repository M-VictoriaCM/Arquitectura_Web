package Main.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import Main.DTO.AlumnoDTO;
import Main.DTO.CarreraDTO;
import Main.DTO.ReporteCarreraDTO;

import Main.Repository.CarreraInscriptaRepository;
import Main.Repository.CarreraRepository;

@Service
public class CarreraService {
	
	private final CarreraRepository carreraRepository;
	private final CarreraInscriptaRepository carreraInscriptaRepository;
	
	
	public CarreraService(CarreraRepository carreraRepository, CarreraInscriptaRepository carreraInscriptaRepository) {
		this.carreraRepository= carreraRepository;
		this.carreraInscriptaRepository= carreraInscriptaRepository;
	}
	
	public List<CarreraDTO>obtenerCantidadIncriptosPorCarrera(){
		return carreraRepository.obtenerCantidadInscriptoPorCarrera();
	}
	
	public List<AlumnoDTO>obtenerEstudiantePorCarreraYCiudad(String nombreCarrera, String ciudadResidencia){
		return carreraInscriptaRepository.obtenerEstudiantePorCarreraYCiudad(nombreCarrera, ciudadResidencia);
	}
	public List<ReporteCarreraDTO>obtenerReporteDeCarreras(){
		return carreraInscriptaRepository.obtenerReporteDeCarreras();
	}

}
