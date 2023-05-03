package com.cristhian.practica.dockerT.repositories;

import com.cristhian.practica.dockerT.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {
}
