package main;


import entity.Alumno;
<<<<<<< HEAD
import repository.AlumnoRepository;
import repository.AlumnoRepositoryImpl;
=======
import entity.Carrera;
import entity.Carrera_inscripta;
import repository.AlumnoRepositoryImpl;
import repository.CarreraInscriptaRepositoryImpl;
import repository.CarreraRepositoryImpl;
>>>>>>> 5b9cd71635653a03d46f8a1b35ec7c3beb8691f5
import repository.RepositoryFactory;

import java.util.List;

public class app {
    public static void main(String[] args) {
        RepositoryFactory.getInstance(RepositoryFactory.MYSQL);
        
        
        /******PRUEBAS**********/
        /**creo un alumno**/
        Alumno a= new Alumno("ff","agga",21,'m',25502633,"Tres Arroyos",2553154,null);
        /**creo una carrera**/
        Carrera carrera = new Carrera("Abogacia",null);
        CarreraRepositoryImpl carreraRepository = new CarreraRepositoryImpl();
        carreraRepository.insert(carrera);
        /**busco una carrera por la id**/
        Carrera carrera1;
        carrera1=carreraRepository.findById(1);
        /**inserto el alumno nuevo a la db**/
        AlumnoRepositoryImpl alumno= new AlumnoRepositoryImpl();
        alumno.insert(a);
        /**busco el alumno**/
        Alumno encontrado;
        encontrado=alumno.findById(1);
        /**creo una carrera inscripta para el alumno que busque y con la carrera buscada**/
        Carrera_inscripta ca = new Carrera_inscripta(0,false,carrera1,encontrado);
        CarreraInscriptaRepositoryImpl carreraInscripta = new CarreraInscriptaRepositoryImpl();
        /**inserto la carrera inscripta en la db**/
        carreraInscripta.insert(ca);

        System.out.println(encontrado.toString());

        //e) recuperar todos los estudiantes, en base a su género
        AlumnoRepository a = AlumnoRepositoryImpl.getInstance();
        List<Alumno> busquedaPorGenero = a.findAllByGender("F");
        for(Alumno alumno: busquedaPorGenero){
            System.out.println(alumno.getNombre()+" "+alumno.getApellido()+" "+alumno.getGenero());
        }

    }
}

