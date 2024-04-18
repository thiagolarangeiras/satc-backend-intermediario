package com.backend.api.models.tmdb;

public class PersonSearch {
    public String name;
    public Boolean includeAdult = false;
    public Integer page = 1;
    public String language = "en-US";

    public PersonSearch(String name){
        this.name = name;
    }


    public String getName(){
        return this.name;
    }
    public Boolean getIncludeAdult(){
        return this.includeAdult;
    }
    public Integer getPage(){
        return this.page;
    }
    public String getLanguage(){
        return this.language;
    }


    public void setName(String name){
        this.name = name;
    }
    public void setIncludeAdult(Boolean includeAdult){
        this.includeAdult = includeAdult;
    }
    public void setPage(Integer page){
        this.page = page;
    }
    public void setLanguage(String language){
        this.language = language;
    }
}