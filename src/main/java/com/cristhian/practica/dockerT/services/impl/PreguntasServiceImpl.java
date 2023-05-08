package com.cristhian.practica.dockerT.services.impl;

import com.cristhian.practica.dockerT.models.Pregunta;
import com.cristhian.practica.dockerT.repositories.PreguntasRepository;
import com.cristhian.practica.dockerT.services.IPreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PreguntasServiceImpl implements IPreguntasService {

    private final PreguntasRepository repository;

    @Autowired
    public PreguntasServiceImpl(PreguntasRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Pregunta> listTotalQuestions() {
        return repository.findAll();
    }

    @Override
    public Pregunta findQuestion(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Pregunta createQuestion(Pregunta pregunta) {
        return repository.save(pregunta);
    }

    @Override
    public void updateQuestion(Pregunta pregunta) {
        repository.save(pregunta);
    }

    @Override
    public void deleteQuestion(Integer id) {
        repository.deleteById(id);
    }
}
