package main;


import entity.Alumno;
import repository.*;
import entity.Carrera;
import entity.Carrera_inscripta;
import repository.AlumnoRepositoryImpl;
import service.CarreraService;

import java.util.List;

public class app {
    public static void main(String[] args) {
        RepositoryFactory.getInstance(RepositoryFactory.MYSQL);

        /******PRUEBAS**********/
        /**creo un alumno**
       // Alumno a= new Alumno("ff","agga",21,'m',25502633,"Tres Arroyos",2553154,null);
        /**creo una carrera**
        Carrera carrera = new Carrera("Abogacia",null);
        CarreraRepositoryImpl carreraRepository = new CarreraRepositoryImpl();
        carreraRepository.insert(carrera);
        /**busco una carrera por la id**
        Carrera carrera1;
        carrera1=carreraRepository.findById(1);
        /**inserto el alumno nuevo a la db**
       AlumnoRepositoryImpl alumno= new AlumnoRepositoryImpl();
        alumno.insert(a);
        /**busco el alumno**
        Alumno encontrado;
        encontrado=alumno.findById(1);
        /**creo una carrera inscripta para el alumno que busque y con la carrera buscada**
        Carrera_inscripta ca = new Carrera_inscripta(0,false,carrera1,encontrado);
        CarreraInscriptaRepositoryImpl carreraInscripta = new CarreraInscriptaRepositoryImpl();
        /**inserto la carrera inscripta en la db**
        carreraInscripta.insert(ca);

        System.out.println(encontrado.toString());*/
        //Obtengo el respositorio
        AlumnoRepository alumnoRepository = RepositoryFactory.get_repositorio_alumno();
        CarreraRepository carreraRepository = RepositoryFactory.get_repositorio_carrera();
        CarreraInscriptaRepository carreraInscriptaRepository = RepositoryFactory.get_repositorio_carreraInscripta();

        CarreraService carreraService = new CarreraService(RepositoryFactory.getEntity_manager());

        //e) recuperar todos los estudiantes, en base a su género

       /*List<Alumno> busquedaPorGenero = alumnoRepository.findAllByGender('M');
       for(Alumno a: busquedaPorGenero){
           System.out.println(a.getId()+ " | "+a.getNombre()+" | "+a.getApellido()+" | "+a.getGenero());
       }*/

       //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        List<Object[]>resultados= carreraService.obtenerCantidadInscriptoPorCarrera();
        for(Object[] resultado : resultados){
            String nombreCarrera = (String) resultado[0];
            Long cantidadInscriptos = (Long) resultado[1];
            System.out.println("Carrera "+ nombreCarrera + "Inscriptos "+cantidadInscriptos);
        }


    }
}

