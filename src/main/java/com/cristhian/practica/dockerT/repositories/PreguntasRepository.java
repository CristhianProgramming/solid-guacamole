package com.cristhian.practica.dockerT.repositories;

import com.cristhian.practica.dockerT.models.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntasRepository extends JpaRepository<Pregunta,Integer> {
}
