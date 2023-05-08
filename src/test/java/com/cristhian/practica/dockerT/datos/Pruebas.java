package com.cristhian.practica.dockerT.datos;

import com.cristhian.practica.dockerT.models.Curso;
import com.cristhian.practica.dockerT.models.Estudiante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pruebas {

    public static final ArrayList<Estudiante> ESTUDIANTES_LIST = new ArrayList<>(Arrays.asList(
            new Estudiante(1, "Juan carlos Borrego", 10300499),
            new Estudiante(2, "Felipe Juan Miguel", 498801011))
    );


    public static final List<Curso> CURSOS_LIST =List.of(
            new Curso(1,"CURS1",ESTUDIANTES_LIST,null),
            new Curso(2,"CURS2",ESTUDIANTES_LIST,null)
    );
}
