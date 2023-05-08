package com.cristhian.practica.dockerT.services;


import com.cristhian.practica.dockerT.datos.Pruebas;
import com.cristhian.practica.dockerT.models.Curso;
import com.cristhian.practica.dockerT.models.Estudiante;
import com.cristhian.practica.dockerT.services.impl.CursoServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TestingService {




    @Mock
    private ICursoService cursoService;


    @BeforeEach
    void setUp() {
        cursoService = mock(CursoServiceImpl.class);
    }

    @Nested
    class pruebaIntegracionService{

            @Test
            @Order(1)
            void getAllCourses(){
                when(cursoService.listTotalCourses()).thenReturn(Pruebas.CURSOS_LIST);
                List<Curso> todosLosCursos = cursoService.listTotalCourses();
                assertEquals(2,todosLosCursos.size());
                assertEquals(2,todosLosCursos.get(1).getEstudiantesList().size());
            }

        @Test
        void addStudentAtCourse(){
            Curso curso = new Curso(2,"CURST",new ArrayList<>(List.of(   new Estudiante(3, "Powder", 231321))),null);
            assertEquals(1,curso.getEstudiantesList().size());
            var actual = curso.getEstudiantesList();
            curso.agregarEstudianteList(new Estudiante(4,"Pedro carlos Borrego",10300499));
            assertEquals(2,curso.getEstudiantesList().size());
        }



    }




}
