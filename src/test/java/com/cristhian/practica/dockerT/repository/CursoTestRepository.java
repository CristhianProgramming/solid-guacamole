package com.cristhian.practica.dockerT.repository;

import com.cristhian.practica.dockerT.datos.Pruebas;
import com.cristhian.practica.dockerT.models.Curso;
import com.cristhian.practica.dockerT.models.Estudiante;
import com.cristhian.practica.dockerT.repositories.CursoRepository;
import com.cristhian.practica.dockerT.repositories.EstudianteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
public class CursoTestRepository {

    @Autowired
    private CursoRepository repositoryCurso;

    @Autowired
    private EstudianteRepository repositoryEstudiantes;


    @Test
    @Order(1)
    void pruebaRegistroCurso(){
      Curso respuesta =  repositoryCurso.save(new Curso(3,"CRUSO3",Pruebas.ESTUDIANTES_LIST,null));
      assertEquals("CRUSO3",respuesta.getFicha());
    }

    @Test
    @Order(2)
    void agregarStudiante(){
        Curso respuesta =  repositoryCurso.save(Pruebas.CURSOS_LIST.get(0));
        Estudiante nuevo = repositoryEstudiantes.findById(3).get();
        repositoryEstudiantes.save(nuevo);
        respuesta.agregarEstudianteList(nuevo);
        Curso respuesta_mod = repositoryCurso.save(respuesta);
        assertEquals(3,respuesta_mod.getEstudiantesList().size());
        assertEquals(103001499,respuesta_mod.getEstudiantesList().get(2).getIdentificacion());
    }

    @Test
    @Order(4)
    void EliminarEStudiante(){
        Curso respuesta =  repositoryCurso.save(Pruebas.CURSOS_LIST.get(0));
        assertEquals("CURS1",respuesta.getFicha());
        assertEquals(2,respuesta.getEstudiantesList().size());
        respuesta.elimnarEstudianteList(Pruebas.ESTUDIANTES_LIST.get(1));
        Curso respuesta2 =  repositoryCurso.save(respuesta);
        assertEquals(1,respuesta2.getEstudiantesList().size());
    }

    @Test
    @Order(3)
    void TransferirEstudiante(){
        Curso curso1 =  repositoryCurso.save(new Curso(1,"CURST", new ArrayList<>(Arrays.asList(new Estudiante(3,"Pedro carlos Borrego",103001499))),null));
        Curso curso2 =  repositoryCurso.save(Pruebas.CURSOS_LIST.get(1));
        //        TRANFERIR ESTUDIANTE
        curso2.transferirEstudiante(Pruebas.ESTUDIANTES_LIST.get(1),curso1);
        Curso respuesta1 = repositoryCurso.save(curso1);
        Curso respuesta2 = repositoryCurso.save(curso2);
//        CONFIRMACION
        assertEquals(2,respuesta1.getEstudiantesList().size());
        assertEquals(1,respuesta2.getEstudiantesList().size());

    }

}
