package com.cristhian.practica.dockerT.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue
    private Integer id;

    private String ficha;

    @OneToMany
    private ArrayList<Estudiante> estudiantesList;

    @OneToOne
    private Profesor director;


    public Curso() {
    }

    public Curso(Integer id, String ficha, ArrayList<Estudiante> estudiantesList, Profesor director) {
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

    public void setEstudiantesList(ArrayList<Estudiante> estudiantesList) {
        this.estudiantesList = estudiantesList;
    }
    public void agregarEstudianteList(Estudiante e){
        this.estudiantesList.add(e);
    }
    public void elimnarEstudianteList(Estudiante e){
        this.estudiantesList.removeIf(p-> Objects.equals(p.getIdentificacion(),e.getIdentificacion()));
    }

    public  void transferirEstudiante(Estudiante e, @org.jetbrains.annotations.NotNull Curso c){
        this.elimnarEstudianteList(e);
        c.agregarEstudianteList(e);
    }

    public Profesor getDirector() {
        return director;
    }

    public void setDirector(Profesor director) {
        this.director = director;
    }


    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", ficha='" + ficha + '\'' +
                ", estudiantesList=" + estudiantesList +
                ", director=" + director +
                '}';
    }
}
