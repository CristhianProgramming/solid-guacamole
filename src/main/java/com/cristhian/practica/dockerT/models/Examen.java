package com.cristhian.practica.dockerT.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="examenes")
public class Examen {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombreExamen;
    @OneToOne
    private Profesor creador;
    @OneToMany
    private List<Curso> asignacion;
    @OneToMany
    private List<Pregunta> preguntas;

    public Examen() {
    }

    public Examen(Integer id, String nombreExamen, Profesor creador, List<Curso> asignacion, List<Pregunta> preguntas) {
        this.id = id;
        this.nombreExamen = nombreExamen;
        this.creador = creador;
        this.asignacion = asignacion;
        this.preguntas = preguntas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public Profesor getCreador() {
        return creador;
    }

    public void setCreador(Profesor creador) {
        this.creador = creador;
    }

    public List<Curso> getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(List<Curso> asignacion) {
        this.asignacion = asignacion;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
