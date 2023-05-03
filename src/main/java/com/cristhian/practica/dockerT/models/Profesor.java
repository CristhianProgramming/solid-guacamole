package com.cristhian.practica.dockerT.models;

import com.cristhian.practica.dockerT.models.enums.Materia;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private Materia materia;
    private Long identificacion;

    public Profesor() {
    }

    public Profesor(Integer id, String nombre, Materia materia, Long identificacion) {
        this.id = id;
        this.nombre = nombre;
        this.materia = materia;
        this.identificacion = identificacion;
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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }
}

