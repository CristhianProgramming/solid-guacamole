package com.cristhian.practica.dockerT.services;


import com.cristhian.practica.dockerT.models.NotasExamenes;

import java.util.List;

public interface INotasExamenes {
    List<NotasExamenes> listNotesForTeacher(Integer id);

    List<NotasExamenes> listNotesForStudent(Integer id);

    NotasExamenes findNoteDetails(Integer id);

    NotasExamenes createNote(NotasExamenes notas);

    void updateNotes(NotasExamenes notas);

    void deleteNotes(Integer id);

}
