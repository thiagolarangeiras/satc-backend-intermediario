package com.backend.api.models.tmdb;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResultRoot {
    @JsonProperty("page")
    public Integer page;

    @JsonProperty("results")
    public ArrayList<MovieResult> results;

    @JsonProperty("total_pages")
    public int totalPages;

    @JsonProperty("total_results")
    public int totalResults;
}

