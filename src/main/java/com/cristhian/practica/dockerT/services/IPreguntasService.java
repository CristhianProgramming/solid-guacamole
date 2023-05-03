package com.cristhian.practica.dockerT.services;


import com.cristhian.practica.dockerT.models.Pregunta;

import java.util.List;

public interface IPreguntasService {

    List<Pregunta> listTotalQuestions();

    Pregunta findQuestion(Integer id);

    Pregunta createQuestion(Pregunta pregunta);

    void updateQuestion(Pregunta pregunta);

    void deleteQuestion(Integer id);

}
