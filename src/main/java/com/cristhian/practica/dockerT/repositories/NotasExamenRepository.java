package com.cristhian.practica.dockerT.repositories;

import com.cristhian.practica.dockerT.models.NotasExamenes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotasExamenRepository extends JpaRepository<NotasExamenes,Integer> {
}
