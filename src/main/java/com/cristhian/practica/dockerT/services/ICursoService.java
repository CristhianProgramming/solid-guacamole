package com.cristhian.practica.dockerT.services;




import com.cristhian.practica.dockerT.Exceptions.StudentNotFoundException;
import com.cristhian.practica.dockerT.models.Curso;
import com.cristhian.practica.dockerT.models.Estudiante;

import java.util.List;

public interface ICursoService {
    List<Curso> listTotalCourses();

    Curso addStudent(Integer estudiante,Integer id) throws StudentNotFoundException;

    Curso findCourse(Integer id);

    Curso createCourse(Curso curso);

    void updateCourse(Curso curso,Integer id);

    void deleteCourse(Integer id);
}
