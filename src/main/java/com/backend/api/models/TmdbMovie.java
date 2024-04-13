package com.backend.api.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/*
 * ObjectMapper om = new ObjectMapper();
 * Root root = om.readValue(myJsonString, Root.class);
 */
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

public class TmdbMovie {
    private Boolean adult;
    private String backdropPath;
    //private ArrayList<Integer> genreIds;
    private Integer id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Double popularity;
    private String posterPath;
    private String releaseDate;
    private String title;
    private Boolean video;
    private Double voteAverage;
    private Integer voteCount;

    @JsonProperty("adult")
    public boolean getAdult() {
        return this.adult;
    }

    @JsonProperty("backdrop_path")
    public String getBackdropPath() {
        return this.backdropPath;
    }

    // @JsonProperty("genre_ids") 
    // public ArrayList<Integer> getGenreIds() { 
	// 	return this.genreIds; 
    // }

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    @JsonProperty("original_language")
    public String getOriginalLanguage() {
        return this.originalLanguage;
    }

    @JsonProperty("original_title")
    public String getOriginalTitle() {
        return this.originalTitle;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return this.overview;
    }

    @JsonProperty("popularity")
    public double getPopularity() {
        return this.popularity;
    }

    @JsonProperty("poster_path")
    public String getPosterPath() {
        return this.posterPath;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return this.releaseDate;
    }

    @JsonProperty("title")
    public String getTitle() {
        return this.title;
    }

    @JsonProperty("video")
    public boolean getVideo() {
        return this.video;
    }

    @JsonProperty("vote_average")
    public double getVoteAverage() {
        return this.voteAverage;
    }

    @JsonProperty("vote_count")
    public int getVoteCount() {
        return this.voteCount;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public void setBackdropPath(String backdrop_path) {
        this.backdropPath = backdrop_path;
    }

    // public void setGenreIds(ArrayList<Integer> genre_ids) { 
	// 	 this.genreIds = genre_ids; 
    // } 

    public void setId(int id) {
        this.id = id;
    }

    public void setOriginalLanguage(String original_language) {
        this.originalLanguage = original_language;
    }

    public void setOriginalTitle(String original_title) {
        this.originalTitle = original_title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void setPosterPath(String poster_path) {
        this.posterPath = poster_path;
    }

    public void setReleaseDate(String release_date) {
        this.releaseDate = release_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public void setVoteAverage(double vote_average) {
        this.voteAverage = vote_average;
    }

    public void setVoteCount(int vote_count) {
        this.voteCount = vote_count;
    }
}