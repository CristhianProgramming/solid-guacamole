package com.cristhian.practica.dockerT.services.impl;

import com.cristhian.practica.dockerT.models.NotasExamenes;
import com.cristhian.practica.dockerT.repositories.NotasExamenRepository;
import com.cristhian.practica.dockerT.services.INotasExamenes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotasExamenImpl implements INotasExamenes {

    private final NotasExamenRepository repository;

    @Autowired
    public NotasExamenImpl(NotasExamenRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NotasExamenes> listNotesForTeacher(Integer id) {
        return repository.findAll();
    }

    @Override
    public List<NotasExamenes> listNotesForStudent(Integer id) {
        return repository.findAll();
    }

    @Override
    public NotasExamenes findNoteDetails(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public NotasExamenes createNote(NotasExamenes notas) {
        return repository.save(notas);
    }

    @Override
    public void updateNotes(NotasExamenes notas) {
        repository.save(notas);
    }

    @Override
    public void deleteNotes(Integer id) {
        repository.deleteById(id);
    }
}
