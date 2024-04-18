package com.backend.api.controllers;

import com.backend.api.models.InsertMovie;
import com.backend.api.models.MovieCustomDetails;
import com.backend.api.models.ReturnMovie;
import com.backend.api.models.WatchlistData;
import com.backend.api.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//retorna dados da lista de filmes e adiciona edita e deleta filmes dela
@RestController
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;

    // pegar toda lista
    @GetMapping("/movielist")
    public ResponseEntity<Object> getList(){
        ArrayList<WatchlistData> list = watchlistService.getWatchlist();
        return ResponseEntity.status(200).body(list);
    }

    // pegar toda lista filtrada: nome, autor, tipo, status, data concluido/assistido, avaliacao, titulo original
//    @GetMapping("/getlistfilter")
//    public ResponseEntity<Object> getListFilter(@RequestParam Movie movie) {
//        return ResponseEntity.status(200).body(watchListMovies);
//    }

    // pegar filme unico da lista
//    @GetMapping("{movie-id}")
//    public ResponseEntity<Object> GetMovie(@PathVariable("movie-id") int movieId) {
//        return ResponseEntity.status(200).body(movieId);
//    }

    @PostMapping("/movie")
    public ResponseEntity<Object> addMovie(@RequestBody InsertMovie insertMovie) {
        MovieCustomDetails movie = new MovieCustomDetails(
                insertMovie.originalTitle,
                insertMovie.type,
                insertMovie.author,
                insertMovie.status,
                insertMovie.conclusionDate,
                insertMovie.rating,
                insertMovie.originalTitle
        );
        Integer result = watchlistService.addMovie(insertMovie.tmdbId, movie);
        return ResponseEntity.status(201).body(new ReturnMovie(result));
    }

    // editar filme
    @PutMapping("/movie")
    public ResponseEntity<Object> editMovie(@RequestParam("id") Integer id,@RequestBody InsertMovie insertMovie) {
        MovieCustomDetails movie = new MovieCustomDetails(
                insertMovie.originalTitle,
                insertMovie.type,
                insertMovie.author,
                insertMovie.status,
                insertMovie.conclusionDate,
                insertMovie.rating,
                insertMovie.originalTitle
        );
        Integer result = watchlistService.editMovie(id, insertMovie.tmdbId, movie);
        return ResponseEntity.status(200).body(new ReturnMovie(result));
    }

    @DeleteMapping("/movie")
    public ResponseEntity<Object> RemoveMovie(@RequestParam("id") int id) {
        Integer result = watchlistService.removeMovie(id);
        return ResponseEntity.status(200).body(new ReturnMovie(result));
    }
}