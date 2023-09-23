package main;


import entity.Alumno;
import entity.Carrera;
import entity.Carrera_inscripta;
import repository.AlumnoRepositoryImpl;
import repository.CarreraInscriptaRepositoryImpl;
import repository.CarreraRepositoryImpl;
import repository.RepositoryFactory;

public class app {
    public static void main(String[] args) {
        RepositoryFactory.getInstance(RepositoryFactory.MYSQL);
        /******PRUEBAS**********/
        /**creo un alumno**/
        Alumno a= new Alumno("franco","garcia",28,'m',392502633,"Tres Arroyos",356501);
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
    }
}

