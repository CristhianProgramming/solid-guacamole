package com.cristhian.practica.dockerT.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue
    private Integer id;

    private String ficha;

    @OneToMany
    private List<Estudiante> estudiantesList;

    @OneToOne
    private Profesor director;



    public Curso() {
    }

    public Curso(Integer id, String ficha, List<Estudiante> estudiantesList, Profesor director) {
        this.id = id;
        this.ficha = ficha;
        this.estudiantesList = estudiantesList;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public List<Estudiante> getEstudiantesList() {
        return estudiantesList;
    }

    public void setEstudiantesList(List<Estudiante> estudiantesList) {
        this.estudiantesList = estudiantesList;
    }

    public Profesor getDirector() {
        return director;
    }

    public void setDirector(Profesor director) {
        this.director = director;
    }



}
