package com.backend.api.models.tmdb;

import org.springframework.lang.Nullable;

import java.time.Year;

public class MovieSearch {
    public String title;
    public Boolean includeAdult = false;
    public Integer page = 1;
    public String language = "en-US";
    public String region;
    public String year;
    public String primaryReleaseYear;

    public MovieSearch(
        String title,
        String region,
        String year,
        String primaryReleaseYear
    ){
        this.title = title;
        this.region = region;
        this.year = year;
        this.primaryReleaseYear = primaryReleaseYear;
    }
    

    public String getTitle() {
        return title;
    }
    public Boolean getIncludeAdult() {
        return includeAdult;
    }    
    public Integer getPage() {
        return page;
    }
    public String getLanguage() {
        return language;
    }
    public String getRegion() {
        return region;
    }
    public String getYear() {
        return year;
    }
    public String getPrimaryReleaseYear() {
        return primaryReleaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setIncludeAdult(Boolean includeAdult) {
        this.includeAdult = includeAdult;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public void setPrimaryReleaseYear(String primaryReleaseYear) {
        this.primaryReleaseYear = primaryReleaseYear;
    }
}