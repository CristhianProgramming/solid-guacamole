package com.cristhian.practica.dockerT.services.impl;

import com.cristhian.practica.dockerT.Exceptions.StudentNotFoundException;
import com.cristhian.practica.dockerT.models.Curso;
import com.cristhian.practica.dockerT.models.Estudiante;
import com.cristhian.practica.dockerT.repositories.CursoRepository;
import com.cristhian.practica.dockerT.services.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CursoServiceImpl implements ICursoService {

    private final CursoRepository repository;

    @Autowired
    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Curso> listTotalCourses() {
        return repository.findAll();
    }

    @Override
    public Curso addStudent(Estudiante estudiante, Integer id)  throws StudentNotFoundException {
      Curso curso =  findCourse(id);
      curso.agregarEstudianteList(estudiante);
      updateCourse(curso,id);
      return curso;
    }

    @Override
    public Curso findCourse(Integer id) {
        return repository.findById(id).orElseThrow();
    }


    @Override
    public Curso createCourse(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public void updateCourse(Curso curso,Integer id) {
       Curso cursoActual = findCourse(id);
       if (cursoActual == null){
       }else{
           repository.save(curso);
       }

    }

    @Override
    public void deleteCourse(Integer id) {
        repository.deleteById(id);
    }
}
