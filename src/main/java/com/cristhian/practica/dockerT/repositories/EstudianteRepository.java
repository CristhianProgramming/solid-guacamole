package com.cristhian.practica.dockerT.repositories;

import com.cristhian.practica.dockerT.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {
}
