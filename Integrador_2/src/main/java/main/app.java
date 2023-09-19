package main;


import entity.Alumno;
import repository.AlumnoRepository;
import repository.AlumnoRepositoryImpl;
import repository.RepositoryFactory;

import java.util.List;

public class app {
    public static void main(String[] args) {
        RepositoryFactory.getInstance(RepositoryFactory.MYSQL);
        
        //e) recuperar todos los estudiantes, en base a su género
        AlumnoRepository a = AlumnoRepositoryImpl.getInstance();
        List<Alumno> busquedaPorGenero = a.findAllByGender("F");
        for(Alumno alumno: busquedaPorGenero){
            System.out.println(alumno.getNombre()+" "+alumno.getApellido()+" "+alumno.getGenero());
        }
    }
}

