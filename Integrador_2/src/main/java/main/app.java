package main;

import entity.Alumno;
import entity.Carrera;
import entity.Carrera_inscripta;
import repository.*;
import service.CarreraService;
public class app {
    public static void main(String[] args) {
        RepositoryFactory.getInstance(RepositoryFactory.MYSQL);
        AppImpl appImpl = new AppImpl();
        /******PRUEBAS**********/
        /** Creo un alumno **/
        Alumno a= new Alumno("Franco","Aranzaga",21,'m',25502633,"Tres Arroyos",2553154);
        /** Inserto el alumno nuevo a la db **/
        appImpl.insertarAlumno(a);

        /** Creo una carrera**/
        Carrera carrera = new Carrera("Contador Publico");
        /** Inserto la carrera nueva a la db **/
        appImpl.insertarCarrera(carrera);

        /** Busco una carrera por la id **/
        Carrera carreraId1;
        carreraId1= appImpl.buscarCarreraPorID(1);

        /** Busco el alumno **/
        Alumno alumnoId1;
        alumnoId1 = appImpl.buscarAlumnoPorID(1);

        /** Inscribo al alumno buscado por ID a la carrera buscada por ID **/
        Carrera_inscripta ci = new Carrera_inscripta(0,false,carreraId1,alumnoId1);
        appImpl.insertarCarreraInscripta(ci);

        /** Imprimo por consola los datos del alumno buscado **/
        System.out.println(alumnoId1.toString());

        /** Recupero todos los estudiantes, en base a su género **/
        appImpl.buscarAlumnoPorGenero('m');

        CarreraService carreraService = new CarreraService(RepositoryFactory.getEntity_manager());
       /** Recupero las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos **/
       appImpl.carrerasOrdenadasPorCantInscriptos();

        /** Recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia **/
       appImpl.buscarEstudiantesPorCarreraResidencia("Abogacia", "Tres Arroyos");

        /** Ejercicio 3:
        * Generar un reporte de las carreras, que para cada carrera incluya información de los
        * inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        * los años de manera cronológica
        **/
        appImpl.reporte();

    }
}


