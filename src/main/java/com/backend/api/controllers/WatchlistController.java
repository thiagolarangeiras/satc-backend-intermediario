package com.backend.api.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.api.models.Movie;
import com.backend.api.models.TmdbMovie;
import com.backend.api.models.WatchlistMovie;
import com.backend.api.services.TmdbInfra;

import io.micrometer.common.lang.Nullable;

//retorna dados da lista de filmes e adiciona edita e deleta filmes dela
@RestController
public class WatchlistController {
    @Autowired
    private TmdbInfra tmdbInfra;
    private ArrayList<WatchlistMovie> watchListMovies = new ArrayList<WatchlistMovie>();

    // pegar toda lista
    @GetMapping("/getlist")
    public ResponseEntity<Object> getList(){
        return ResponseEntity.status(200).body(watchListMovies);
    }

    // pegar toda lista filtrada: nome, autor, tipo, status, data concluido/assistido, avaliacao, titulo original
    @GetMapping("/getlistfilter")
    public ResponseEntity<Object> getListFilter(@RequestParam Movie movie) {
        return ResponseEntity.status(200).body(watchListMovies);
    }

    // colocar filme
    @PostMapping("/addmovie")
    public ResponseEntity<Object> addMovie(@RequestParam("tmdb-movie-id")@Nullable Integer tmdbMovieId, @RequestBody Movie movie) {
        System.out.print(tmdbMovieId);
        WatchlistMovie newMovie = new WatchlistMovie();
        newMovie.id = movie.getId();
        newMovie.movie = movie;
        if (tmdbMovieId != null && tmdbMovieId != 0){
            TmdbMovie tmdbMovie = tmdbInfra.getMovie(tmdbMovieId);
            newMovie.tmdbId = tmdbMovie.getId();
            newMovie.tmdbMovie = tmdbMovie;
        }

        watchListMovies.add(newMovie);
        return ResponseEntity.status(200).build();
    }

    // editar filme
    @PutMapping("/editmovie")
    public ResponseEntity<Object> editMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(200).body(null);
    }


    // pegar filme unico da lista
    @GetMapping("{movie-id}")
    public ResponseEntity<Object> GetMovie(@PathVariable("movie-id") int movieId) {
        return ResponseEntity.status(200).body(movieId);
    }

    // remover filme
    @DeleteMapping("{movie-id}/remove")
    public ResponseEntity<Object> RemoveMovie(@PathVariable("movie-id") int movieId) {
        return ResponseEntity.status(200).body(movieId);
    }
}