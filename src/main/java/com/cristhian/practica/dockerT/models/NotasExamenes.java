package com.cristhian.practica.dockerT.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class NotasExamenes {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private Examen examen;
    private BigDecimal nota;

    public NotasExamenes() {
    }

    public NotasExamenes(Integer id, Estudiante estudiante, Examen examen, BigDecimal nota) {
        this.id = id;
        this.estudiante = estudiante;
        this.examen = examen;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }
}
