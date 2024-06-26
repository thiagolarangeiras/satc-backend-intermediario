package com.backend.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

class Estudante {
    public final String estudante = "Thiago Larangeira de Souza";
    public final String projeto = "Lista de Filmes para assistir";
}

@RestController
public class AjudaController {

    @GetMapping("/teste")
    public ResponseEntity<Object> teste(){
        //ArrayList<TmdbMovie> movies = imdbService.getMovie("star wars");
        return ResponseEntity.status(200).body(new Object());
    }

    @GetMapping("/ajuda")
    public ResponseEntity<Estudante> ajuda(){
        return ResponseEntity.status(200).body(new Estudante());
    }
}