package com.backend.api.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.api.models.SearchMovie;
import com.backend.api.models.TmdbMovie;
import com.backend.api.services.TmdbInfra;

//Retorna dados de filmes
@RestController
public class MovieController {
    @Autowired
    private TmdbInfra tmdbInfra;

    @GetMapping("/getMovie")
    public ResponseEntity<Object> getMovie(@RequestParam SearchMovie searchMovie) {
        ArrayList<TmdbMovie> movies = tmdbInfra.getMovie(
            searchMovie.title,
            searchMovie.language,
            searchMovie.page,
            searchMovie.region,
            searchMovie.year
        );

        return ResponseEntity.status(200).body(movies);
    }
}
