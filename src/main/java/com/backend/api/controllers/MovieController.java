package com.backend.api.controllers;

import java.util.ArrayList;

import com.backend.api.models.tmdb.*;
import com.backend.api.services.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Retorna dados de filmes para utilizar o Id ao adicionar eles a uma watchlist
@RestController
public class MovieController {
    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/searchMovie")
    public ResponseEntity<Object> getMovie(MovieSearch movieSearch) {
        ArrayList<MovieResult> movies = tmdbService.searchMovie(movieSearch);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/searchPerson")
    public ResponseEntity<Object> getPerson(PersonSearch personSearch) {
        ArrayList<PersonResult> persons = tmdbService.searchPerson(personSearch);
        return ResponseEntity.status(200).body(persons);
    }

    @GetMapping("/getMovie")
    public ResponseEntity<Object> getMovie(MovieDetailsSearch movieDetailsSearch) {
        MovieDetailsResult moviesDetails = tmdbService.getMovie(movieDetailsSearch);
        return ResponseEntity.status(200).body(moviesDetails);
    }
}
