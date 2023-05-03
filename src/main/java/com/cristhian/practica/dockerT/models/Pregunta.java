package com.cristhian.practica.dockerT.models;

import com.cristhian.practica.dockerT.models.enums.Materia;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "preguntas")
public class Pregunta {
    @Id
    @GeneratedValue
    private Integer id;

    private String pregunta;

    private String respuesta;

    private List<String> opcionesErroneas;

    private Materia materia;

    public Pregunta() {
    }

    public Pregunta(Integer id, String pregunta, String respuesta, List<String> opcionesErroneas, Materia materia) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.opcionesErroneas = opcionesErroneas;
        this.materia = materia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public List<String> getOpcionesErroneas() {
        return opcionesErroneas;
    }

    public void setOpcionesErroneas(List<String> opcionesErroneas) {
        this.opcionesErroneas = opcionesErroneas;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
