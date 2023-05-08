package com.cristhian.practica.dockerT.services.impl;

import com.cristhian.practica.dockerT.models.Profesor;
import com.cristhian.practica.dockerT.repositories.ExamenRepository;
import com.cristhian.practica.dockerT.repositories.ProfesorRepository;
import com.cristhian.practica.dockerT.services.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfesorServiceImpl implements IProfesorService {

    private final ProfesorRepository repository;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Profesor> listTotalTeachers() {
        return repository.findAll();
    }

    @Override
    public Profesor findTeacher(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Profesor createTeacher(Profesor estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public void updateTeacher(Profesor estudiante) {
        repository.save(estudiante);
    }

    @Override
    public void deleteTeacher(Integer id) {
        repository.deleteById(id);
    }
}
