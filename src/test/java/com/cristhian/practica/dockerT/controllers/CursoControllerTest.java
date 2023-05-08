package com.cristhian.practica.dockerT.controllers;

import com.cristhian.practica.dockerT.datos.Pruebas;
import com.cristhian.practica.dockerT.repositories.CursoRepository;
import com.cristhian.practica.dockerT.services.ICursoService;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc()
@TestMethodOrder(MethodOrderer.DisplayName.class)
class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CursoRepository repositoryCurso;

    @Test
    @DisplayName("Test 2")
    void obtenerTodosCursos() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/cursos").contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isOk(),
                jsonPath("$.length()").value(1)
        );
    }


    @Test
    @DisplayName("Test 3")
    void zgragarEstudianteACurso () throws Exception {
        mockMvc.perform(post("http://localhost:8080/api/v1/curso/1?idStudent=2")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().is(201)
                ,jsonPath("$.estudiantesList.length()").value(2)
        );

}

    @Test
    @DisplayName("Test 1")
    void crearCurso() throws Exception {
        mockMvc.perform(post("http://localhost:8080/api/v1/curso")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new JSONObject("{'ficha':'CURS1','estudiantesList':[{'id':1}],'director':null}").toString())).andExpectAll(
                status().is(201),
                jsonPath("$.ficha").value("CURS1"),
                jsonPath("$.director").isEmpty()
        );
    }
}