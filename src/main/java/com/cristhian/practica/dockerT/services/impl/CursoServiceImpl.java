package com.cristhian.practica.dockerT.services.impl;

import com.cristhian.practica.dockerT.Exceptions.StudentNotFoundException;
import com.cristhian.practica.dockerT.models.Curso;
import com.cristhian.practica.dockerT.models.Estudiante;
import com.cristhian.practica.dockerT.repositories.CursoRepository;
import com.cristhian.practica.dockerT.repositories.EstudianteRepository;
import com.cristhian.practica.dockerT.services.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CursoServiceImpl implements ICursoService {

    private final CursoRepository repository;

    private final EstudianteRepository estudianteRepository;

    public CursoServiceImpl(CursoRepository repository, EstudianteRepository estudianteRepository) {
        this.repository = repository;
        this.estudianteRepository = estudianteRepository;
    }

    @Autowired


    @Override
    public List<Curso> listTotalCourses() {
        return repository.findAll();
    }

    @Override
    public Curso addStudent(Integer estudiante, Integer id)  throws StudentNotFoundException {
      Curso curso =  findCourse(id);
      Estudiante estudiante1 = estudianteRepository.findById(estudiante).get();
      curso.agregarEstudianteList(estudiante1);
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
