package com.backend.api.models.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PersonResultKnownfor {
    @JsonProperty("backdrop_path")
    public String backdropPath;
    
    @JsonProperty("id")
    public int id;
    
    @JsonProperty("original_title")
    public String originalTitle;
    
    @JsonProperty("overview")
    public String overview;
    
    @JsonProperty("poster_path")
    public String posterPath;
    
    @JsonProperty("media_type")
    public String mediaType;
    
    @JsonProperty("adult")
    public boolean adult;
    
    @JsonProperty("title")
    public String title;
    
    @JsonProperty("original_language")
    public String originalLanguage;
    
    @JsonProperty("genre_ids")
    public ArrayList<Integer> genreIds;
    
    @JsonProperty("popularity")
    public double popularity;
    
    @JsonProperty("release_date")
    public String releaseFate;
    
    @JsonProperty("video")
    public boolean video;
    
    @JsonProperty("vote_average")
    public double voteAverage;
    
    @JsonProperty("vote_count")
    public int voteCount;
    
    @JsonProperty("original_name")
    public String originalName;
    
    @JsonProperty("name")
    public String name;
    
    @JsonProperty("first_air_date")
    public String firstAirDate;
    
    @JsonProperty("origin_country")
    public ArrayList<String> originCountry;
}
