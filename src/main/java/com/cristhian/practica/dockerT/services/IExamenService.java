package com.cristhian.practica.dockerT.services;

import com.cristhian.practica.dockerT.models.Examen;

import java.util.List;

public interface IExamenService {

    List<Examen> listTotalTests();

    Examen findTest(Integer id);

    Examen createTest(Examen examen);

    void updateTest(Examen examen);

    void deleteTest(Integer id);

}
