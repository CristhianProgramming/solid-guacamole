package com.cristhian.practica.dockerT.controllers;


import com.cristhian.practica.dockerT.models.Curso;
import com.cristhian.practica.dockerT.services.ICursoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CursoController {

    private final ICursoService cursoService;
    @Autowired
    public CursoController(ICursoService cursoService) {
        this.cursoService = cursoService;
    }


    @GetMapping("cursos")
    ResponseEntity<List<Curso>> obtenerTodosCursos(){
        return ResponseEntity.ok(cursoService.listTotalCourses());
    }

    @GetMapping("curso/{id}")
    ResponseEntity<?> buscarCurso(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(cursoService.findCourse(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("curso/{id}")
    ResponseEntity<?> addNuevoEstudiante(@PathVariable Integer id,@PathParam("idStudent") Integer idStudent){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.addStudent(idStudent,id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("curso")
    ResponseEntity<?> crearNuevoCurso(@RequestBody Curso payload){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.createCourse(payload));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("curso/{id}")
    ResponseEntity<?> actualizarCurso(@RequestBody Curso payload , @PathVariable Integer id){
        try {
            cursoService.updateCourse(payload,id);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("curso/{id}")
    ResponseEntity<?> eliminarCurso(@PathVariable Integer id){
        try {
            cursoService.deleteCourse(id);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
