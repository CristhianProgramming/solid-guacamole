package com.cristhian.practica.dockerT.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("hello")
    String prueba(){
        return "Hello World";
    }



}
