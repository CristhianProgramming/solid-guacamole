package com.cristhian.practica.dockerT.models;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;

    @NotNull
    @Column(unique = true)
    private Integer identificacion;

    public Estudiante() {
    }

    public Estudiante(Integer id, String nombre, Integer identificacion) {
        this.id = id;
        this.nombre = nombre;
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

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", identificacion=" + identificacion +
                '}';
    }
}
