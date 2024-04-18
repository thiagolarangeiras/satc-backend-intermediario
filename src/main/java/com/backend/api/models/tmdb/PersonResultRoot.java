package com.backend.api.models.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PersonResultRoot {
    @JsonProperty("page")
    public int page;
    
    @JsonProperty("results")
    public ArrayList<PersonResult> results;
    
    @JsonProperty("total_pages")
    public int totalPages;
    
    @JsonProperty("total_results")
    public int totalResults;
}
