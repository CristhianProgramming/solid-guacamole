package com.cristhian.practica.dockerT.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.DisplayName.class)
class EstudianteControllerTest {

    private static final String URL = "http://localhost:8080/api/v1";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Disabled
    @DisplayName("Test 5 - Problemas con archivo import.sql")
    void crearNuevoEstudiante() throws  Exception{
        mockMvc.perform(post(URL.concat("/estudiante"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new JSONObject("{'nombre':'Juan Carlos','identificacion':1017654}").toString())
        ).andExpectAll(
           status().is(201)
        );
    }

    @Test
    @DisplayName("Test 1")
    void obtenerEstudiantes() throws Exception {
        mockMvc.perform(get(URL.concat("/estudiantes"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.length()").value(3)
                );
    }

    @Test
    @DisplayName("Test 2")
    void obtenerEstudiante() throws Exception {
        mockMvc.perform(get(URL.concat("/estudiante/1"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.identificacion").value(10300499),
                        jsonPath("$.nombre").value("Juan carlos Borrego")

                );
    }

    @Test
    @DisplayName("Test 3")
    void actualizarEstidiante() throws Exception {
        mockMvc.perform(put(URL.concat("/estudiante/1"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new JSONObject("{'nombre':'Felipo'}").toString())
        ).andExpectAll(
                status().is(201)
        );

        mockMvc.perform(get(URL.concat("/estudiante/1"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.nombre").value("Felipo")

                );
    }

    @Test
    @DisplayName("Test 4")
    void eliminarEstudiante() throws  Exception{
        mockMvc.perform(delete(URL.concat("/estudiante/1"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                status().is(202)
                )
        ;
    }
}