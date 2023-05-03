package com.cristhian.practica.dockerT.repositories;

import com.cristhian.practica.dockerT.models.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<Examen,Integer> {
}
