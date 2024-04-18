package com.backend.api.models.tmdb;

public class MovieDetailsSearch {
    public Integer movieId;
    public String language = "en-US";

    public MovieDetailsSearch(Integer movieId) {
        this.movieId = movieId;
    }
}