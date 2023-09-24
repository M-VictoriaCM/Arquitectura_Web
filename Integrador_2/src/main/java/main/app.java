package main;


import DTO.AlumnoDTO;
import DTO.ReporteCarreraDTO;
import repository.*;
import service.CarreraService;

import java.util.List;

public class app {
    public static void main(String[] args) {
        RepositoryFactory.getInstance(RepositoryFactory.MYSQL);

        /******PRUEBAS**********/
        /**creo un alumno**/
        //Alumno a= new Alumno("ff","agga",21,'m',25502633,"Tres Arroyos",2553154,null);
        /**creo una carrera**/
        //Carrera carrera = new Carrera("Abogacia",null);
        //CarreraRepositoryImpl carreraRepository = new CarreraRepositoryImpl();
        //carreraRepository.insert(carrera);
        /**busco una carrera por la id**/
        //Carrera carrera1;
        //carrera1=carreraRepository.findById(1);
        /**inserto el alumno nuevo a la db**/
        //AlumnoRepositoryImpl alumno= new AlumnoRepositoryImpl();
        // alumno.insert(a);
        /**busco el alumno**/
        //Alumno encontrado;
        //encontrado=alumno.findById(1);
        /**creo una carrera inscripta para el alumno que busque y con la carrera buscada**/
        //Carrera_inscripta ca = new Carrera_inscripta(0,false,carrera1,encontrado);
        //CarreraInscriptaRepositoryImpl carreraInscripta = new CarreraInscriptaRepositoryImpl();
        /**inserto la carrera inscripta en la db**/
        //carreraInscripta.insert(ca);

        //System.out.println(encontrado.toString());

        //Obtengo el respositorio
        //AlumnoRepository alumnoRepository = RepositoryFactory.get_repositorio_alumno();
        //servicios


        //e) recuperar todos los estudiantes, en base a su género

       /*List<Alumno> busquedaPorGenero = alumnoRepository.findAllByGender('M');
       for(Alumno alu: busquedaPorGenero){
           System.out.println(alu.getId()+ " | "+alu.getNombre()+" | "+alu.getApellido()+" | "+alu.getGenero());
       }*/
        CarreraService carreraService = new CarreraService(RepositoryFactory.getEntity_manager());
       //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        /*
        List<CarreraDTO> carreraDTO = carreraService.obtenerCantidadInscriptoPorCarrera();
        System.out.println("Carreras con estudiantes inscriptos ordenados por cantidad de inscriptos");
        for (CarreraDTO carreras : carreraDTO) {
            System.out.println("Carrera: " + carreras.getNombreCarrera());
            System.out.println("Inscriptos: " + carreras.getCantidadInscriptos());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }*/

        //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
       /*List<AlumnoDTO>alumnos = carreraService.obtenerEstudiantePorCarreraYCiudad("Abogacia", "Tres Arroyos");
        System.out.println("Listado de estudiantes filtrado por carrera y residencia");
        for(AlumnoDTO alumno : alumnos){
            System.out.println("Nombre: "+alumno.getNombre());
            System.out.println("Apellido: "+alumno.getApellido());
            System.out.println("Carrera: "+alumno.getNombreCarrera());
            System.out.println("Ciudad: "+alumno.getResidencia());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }*/

        /*Ejercicio 3:
        * Generar un reporte de las carreras, que para cada carrera incluya información de los
        * inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        * los años de manera cronológica
        */
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


