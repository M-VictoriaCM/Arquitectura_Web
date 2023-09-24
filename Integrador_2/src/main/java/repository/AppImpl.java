package repository;


import DTO.AlumnoDTO;
import DTO.CarreraDTO;
import DTO.ReporteCarreraDTO;
import entity.Alumno;
import entity.Carrera;
import entity.Carrera_inscripta;
import service.CarreraService;

import java.util.List;

/** Aquí realizamos las implementaciones de pruebas para el programa, una forma de testeo **/

public class AppImpl {

    public AppImpl() {
    }
    /** INSERT **/
    public void insertarAlumno(Alumno a){
        AlumnoRepositoryImpl alumno= new AlumnoRepositoryImpl();
        alumno.insert(a);
    }

    public void insertarCarrera(Carrera c){
        CarreraRepositoryImpl carreraRepository = new CarreraRepositoryImpl();
        carreraRepository.insert(c);
    }

    public void insertarCarreraInscripta(Carrera_inscripta ci){
        CarreraInscriptaRepositoryImpl carreraInscriptaRepository = new CarreraInscriptaRepositoryImpl();
        carreraInscriptaRepository.insert(ci);
    }
    /** BUSQUEDAS POR ID **/
    public Alumno buscarAlumnoPorID(int id){
        AlumnoRepositoryImpl alumnoRepository = new AlumnoRepositoryImpl();
        Alumno a = alumnoRepository.findById(id);
        return a;
    }

    public Carrera buscarCarreraPorID(int id){
        CarreraRepositoryImpl carreraRepository = new CarreraRepositoryImpl();
        Carrera c = carreraRepository.findById(id);
        return c;
    }

    /** BUSQUEDA DE ALUMNOS POR GENERO **/
    public void buscarAlumnoPorGenero (char g) {
        AlumnoRepository alumnoRepository = RepositoryFactory.get_repositorio_alumno();
        List<Alumno> busquedaPorGenero = alumnoRepository.findAllByGender('M');
        for (Alumno alu : busquedaPorGenero) {
            System.out.println(alu.getId() + " | " + alu.getNombre() + " | " + alu.getApellido() + " | " + alu.getGenero());
        }
    }

    /** BUSQUEDA DE CARRERAS Y ORDENADAS POR CANTIDAD DE INSCRIPTOS **/

    public void carrerasOrdenadasPorCantInscriptos(){
        CarreraService carreraService = new CarreraService(RepositoryFactory.getEntity_manager());
        List<CarreraDTO> carreraDTO = carreraService.obtenerCantidadInscriptoPorCarrera();
        System.out.println("Carreras con estudiantes inscriptos ordenados por cantidad de inscriptos");
        for (CarreraDTO carreras : carreraDTO) {
            System.out.println("Carrera: " + carreras.getNombreCarrera());
            System.out.println("Inscriptos: " + carreras.getCantidadInscriptos());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    /** BUSQUEDA DE ESTUDIANTES POR CARRERA Y FILTRADO POR CIUDAD DE RESIDENCIA **/

    public void buscarEstudiantesPorCarreraResidencia(String carrera, String residencia){
        CarreraService carreraService = new CarreraService(RepositoryFactory.getEntity_manager());
        List<AlumnoDTO>alumnos = carreraService.obtenerEstudiantePorCarreraYCiudad(carrera, residencia);
        System.out.println("Listado de estudiantes filtrado por carrera y residencia");
        for(AlumnoDTO alumno : alumnos){
            System.out.println("Nombre: "+alumno.getNombre());
            System.out.println("Apellido: "+alumno.getApellido());
            System.out.println("Carrera: "+alumno.getNombreCarrera());
            System.out.println("Ciudad: "+alumno.getResidencia());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    /** REPORTE DE LAS CARRERAS **/

    public void reporte(){
        CarreraService carreraService = new CarreraService(RepositoryFactory.getEntity_manager());
        List<ReporteCarreraDTO>reporte = carreraService.obtenerReporteDeCarreras();
        for(ReporteCarreraDTO data: reporte){
            System.out.println("Inscripción: "+data.getAnio_de_inscripcion());
            System.out.println("N° libreta: "+data.getLibreta());
            System.out.println("Apellido : "+data.getApellidoAlumno());
            System.out.println("Nombre : "+data.getNombreAlumno());
            System.out.println("Carrera: "+data.getNombreCarrera());
            System.out.println("Año de graduado: "+data.getAnioGraduado());
            System.out.println("Inscripto: "+data.getInscripto());
            System.out.println("Egresado: "+data.getEgresado());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

}
