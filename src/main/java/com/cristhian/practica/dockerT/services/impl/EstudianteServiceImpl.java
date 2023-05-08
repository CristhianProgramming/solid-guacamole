package com.cristhian.practica.dockerT.services.impl;

import com.cristhian.practica.dockerT.models.Estudiante;
import com.cristhian.practica.dockerT.repositories.EstudianteRepository;
import com.cristhian.practica.dockerT.services.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EstudianteServiceImpl implements IEstudianteService {

    private final EstudianteRepository repository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estudiante> listTotalStudents() {
        return (List<Estudiante>) repository.findAll();
    }

    @Override
    public Estudiante findStudent(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Estudiante createStudent(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public void updateStudent(Estudiante estudiante) {
        repository.save(estudiante);
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }
}
