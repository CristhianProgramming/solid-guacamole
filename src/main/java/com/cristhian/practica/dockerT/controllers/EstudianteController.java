package com.cristhian.practica.dockerT.controllers;

import com.cristhian.practica.dockerT.models.Estudiante;
import com.cristhian.practica.dockerT.services.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class EstudianteController {

    private final IEstudianteService estudianteService;

    @Autowired
    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }


    @GetMapping("estudiantes")
    ResponseEntity<List<Estudiante>> obtenerEstudiantes(){
        return ResponseEntity.ok().body(estudianteService.listTotalStudents());
    }

    @GetMapping("estudiante/{id}")
    ResponseEntity<?> obtenerEstudiante(@PathVariable Integer id){
        try {
            return ResponseEntity.ok().body(estudianteService.findStudent(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("estudiante")
    ResponseEntity<?> crearNuevoEstudiante(@RequestBody Estudiante payload){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.createStudent(payload));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("estudiante/{id}")
    ResponseEntity<?> actualizarEstidiante(@RequestBody Estudiante payload,@PathVariable Integer id){
        try {
            estudianteService.updateStudent(payload,id);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("estudiante/{id}")
    ResponseEntity<?> eliminarEstudiante(@PathVariable Integer id){
        try {
            estudianteService.deleteStudent(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


}
