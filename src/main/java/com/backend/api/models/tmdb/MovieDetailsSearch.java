package com.backend.api.models.tmdb;

public class MovieDetailsSearch {
    public Integer movieId;
    public String language = "en-US";

    public MovieDetailsSearch(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMovieId(){
        return this.movieId;
    }
    public String getLanguage(){
        return this.language;
    }

    public void setMovieId(Integer movieid){
        this.movieId = movieid;
    }
    public void setLanguage(String language){
        this.language = language;
    }
}