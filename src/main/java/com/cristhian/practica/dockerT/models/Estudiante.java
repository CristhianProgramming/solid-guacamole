package com.cristhian.practica.dockerT.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;

    private Integer identificacion;

    @ManyToOne
    private Curso curso;

    public Estudiante() {
    }

    public Estudiante(Integer id, String nombre, Integer identificacion, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
