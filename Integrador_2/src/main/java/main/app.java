package main;


import entity.Alumno;
import repository.*;
import entity.Carrera;
import entity.Carrera_inscripta;
import repository.AlumnoRepositoryImpl;
import service.CarreraService;

import java.util.Date;
import java.util.List;

public class app {
    public static void main(String[] args) {
        RepositoryFactory.getInstance(RepositoryFactory.MYSQL);

        /******PRUEBAS**********/
        /**creo un alumno**/
       Alumno a= new Alumno("ff","agga",21,'m',25502633,"Tres Arroyos",2553154,null);
        /**creo una carrera**/
        Carrera carrera = new Carrera("Veterinaria");
        CarreraRepositoryImpl carreraRepository = new CarreraRepositoryImpl();
        carreraRepository.insert(carrera);
        /**busco una carrera por la id**/
        Carrera carrera1;
        carrera1=carreraRepository.findById(2);
        /**inserto el alumno nuevo a la db**/
       AlumnoRepositoryImpl alumno= new AlumnoRepositoryImpl();
        alumno.insert(a);
        /**busco el alumno**/
        Alumno encontrado;
        encontrado=alumno.findById(8);
        /**creo una carrera inscripta para el alumno que busque y con la carrera buscada**/
        Carrera_inscripta ca = new Carrera_inscripta(0,false,carrera1,encontrado);
        CarreraInscriptaRepositoryImpl carreraInscripta = new CarreraInscriptaRepositoryImpl();
        /**inserto la carrera inscripta en la db**/
        carreraInscripta.insert(ca);

        System.out.println(encontrado.toString());

        //Obtengo el respositorio
        AlumnoRepository alumnoRepository = RepositoryFactory.get_repositorio_alumno();
        //servicios
        CarreraService carreraService = new CarreraService(RepositoryFactory.getEntity_manager());

        //e) recuperar todos los estudiantes, en base a su género

       List<Alumno> busquedaPorGenero = alumnoRepository.findAllByGender('M');
       for(Alumno alu: busquedaPorGenero){
           System.out.println(alu.getId()+ " | "+alu.getNombre()+" | "+alu.getApellido()+" | "+alu.getGenero());
       }

       //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        List<Object[]>resultados= carreraService.obtenerCantidadInscriptoPorCarrera();
        System.out.println("Carreras con estudiantes inscriptos ordenados por cantidad de inscriptos");
        for(Object[] resultado : resultados){
            String nombreCarrera = (String) resultado[0];
            Long cantidadInscriptos = (Long) resultado[1];
            System.out.println("Carrera: "+ nombreCarrera);
            System.out.println("Inscriptos: "+cantidadInscriptos);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
       List<Object[]>resultadoBusquedad = carreraService.obtenerEstudiantePorCarreraYCiudad("Abogacia", "Tres Arroyos");
        System.out.println("Listado de estudiantes filtrado por carrera y residencia");
        for(Object[] datoEncontrado : resultadoBusquedad){
            String nombre = (String) datoEncontrado[0];
            String apellido = (String) datoEncontrado[1];
            String nombcarrera = (String) datoEncontrado[2];
            String ciudad = (String) datoEncontrado[3];
            System.out.println("Nombre: "+nombre);
            System.out.println("Apellido: "+apellido);
            System.out.println("Carrera: "+nombcarrera);
            System.out.println("Ciudad: "+ciudad);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        /*Ejercicio 3:
        * Generar un reporte de las carreras, que para cada carrera incluya información de los
        * inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        * los años de manera cronológica
        */
        List<Object[]>reporte = carreraService.obtenerReporteDeCarreras();
        for(Object[] data: reporte){
            int libreta = (int) data[0];
            String nombreAlumno = (String) data[1];
            String apellidoAlumno = (String) data[2];
            String nombreCarrera =(String) data[3];
            Date graduado = (Date) data[4];
            Long inscriptos =(Long) data[5];
            Long egresado =(Long) data[6];

            System.out.println("N° libreta: "+libreta);
            System.out.println("Nombre: "+nombreAlumno);
            System.out.println("Apellido: "+apellidoAlumno);
            System.out.println("Carrera: "+nombreCarrera);
            System.out.println("Año de graduado: "+graduado);
            System.out.println("Inscripto: "+inscriptos);
            System.out.println("Egresado: "+egresado);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }



    }
}


