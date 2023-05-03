package com.cristhian.practica.dockerT.services;

import com.cristhian.practica.dockerT.models.Profesor;

import java.util.List;

public interface IProfesorService {

    List<Profesor> listTotalTeachers();

    Profesor findTeacher(Integer id);

    Profesor createTeacher(Profesor estudiante);

    void updateTeacher(Profesor estudiante);

    void deleteTeacher(Integer id);



}
