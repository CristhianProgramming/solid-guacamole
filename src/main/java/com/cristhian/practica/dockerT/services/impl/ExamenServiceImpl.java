package com.cristhian.practica.dockerT.services.impl;

import com.cristhian.practica.dockerT.models.Examen;
import com.cristhian.practica.dockerT.repositories.ExamenRepository;
import com.cristhian.practica.dockerT.services.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamenServiceImpl implements IExamenService {

    private final ExamenRepository repository;

    @Autowired
    public ExamenServiceImpl(ExamenRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Examen> listTotalTests() {
        return repository.findAll();
    }

    @Override
    public Examen findTest(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Examen createTest(Examen examen) {
        return repository.save(examen);
    }

    @Override
    public void updateTest(Examen examen) {
        repository.save(examen);
    }

    @Override
    public void deleteTest(Integer id) {
        repository.deleteById(id);
    }
}
