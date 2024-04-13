package com.backend.api.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TmdbResult {
    private Integer page;
    private ArrayList<TmdbMovie> results;
    private int totalPages;
    private int totalResults;
    
    @JsonProperty("page")
    public int getPage() {
        return this.page;
    }

    @JsonProperty("results")
    public ArrayList<TmdbMovie> getResults() {
        return this.results;
    }

    @JsonProperty("total_pages")
    public int getTotalPages() {
        return this.totalPages;
    }

    @JsonProperty("total_results")
    public int getTotalResults() {
        return this.totalResults;
    }
    
    public void setPage(int page) {
        this.page = page;
    }

    public void setResults(ArrayList<TmdbMovie> results) {
        this.results = results;
    }

    public void setTotalPages(int total_pages) {
        this.totalPages = total_pages;
    }

    public void setTotalResults(int total_results) {
        this.totalResults = total_results;
    }
    
}