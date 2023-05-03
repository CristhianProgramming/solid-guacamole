package com.cristhian.practica.dockerT.services;

import com.cristhian.practica.dockerT.models.Curso;
import com.cristhian.practica.dockerT.models.Estudiante;

import java.util.List;

public interface IEstudianteService {

    List<Estudiante> listTotalStudents();

    Estudiante findStudent(Integer id);

    Estudiante createStudent(Estudiante estudiante);

    void updateStudent(Estudiante estudiante);

    void deleteStudent(Integer id);

}
