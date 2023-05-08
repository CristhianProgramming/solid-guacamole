package com.cristhian.practica.dockerT.services;




import com.cristhian.practica.dockerT.models.Curso;
import com.cristhian.practica.dockerT.models.Estudiante;

import java.util.List;

public interface ICursoService {
    List<Curso> listTotalCourses();

    Curso addStudent(Estudiante estudiante,Integer id);

    Curso findCourse(Integer id);

    Curso createCourse(Curso curso);

    void updateCourse(Curso curso);

    void deleteCourse(Integer id);
}
