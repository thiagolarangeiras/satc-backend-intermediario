package com.backend.api.controllers;

import java.util.ArrayList;

import com.backend.api.models.ErrorMessage;
import com.backend.api.models.exceptions.TmdbServerOffException;
import com.backend.api.models.tmdb.*;
import com.backend.api.services.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/searchMovie")
    public ResponseEntity<Object> getMovie(MovieSearch movieSearch){
        try{
            ArrayList<MovieResult> movies = tmdbService.searchMovie(movieSearch);
            return ResponseEntity.status(200).body(movies);
        } catch (TmdbServerOffException e){
            return ResponseEntity.status(503).body(new ErrorMessage(e.message));
        }
    }

    @GetMapping("/searchPerson")
    public ResponseEntity<Object> getPerson(PersonSearch personSearch) {
        try{
            ArrayList<PersonResult> persons = tmdbService.searchPerson(personSearch);
            return ResponseEntity.status(200).body(persons);
        } catch (TmdbServerOffException e){
            return ResponseEntity.status(503).body(new ErrorMessage(e.message));
        }
    }

    @GetMapping("/getMovie")
    public ResponseEntity<Object> getMovie(MovieDetailsSearch movieDetailsSearch) {
        try{
            MovieDetailsResult moviesDetails = tmdbService.getMovie(movieDetailsSearch);
            return ResponseEntity.status(200).body(moviesDetails);
        } catch (TmdbServerOffException e){
            return ResponseEntity.status(503).body(new ErrorMessage(e.message));
        }
    }
}
