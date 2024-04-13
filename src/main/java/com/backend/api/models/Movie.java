package com.backend.api.models;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
    private Integer id;
    private String title;
    private ArrayList<Integer> type;
    private String author;
    private Short status;
    private Date conclusionDate;
    private Short rating;
    private String originalTitle;
    
    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public ArrayList<Integer> getType() {
        return type;
    }
    public String getAuthor() {
        return author;
    }
    public Short getStatus() {
        return status;
    }
    public Date getConclusionDate() {
        return conclusionDate;
    }
    public Short getRating() {
        return rating;
    }
    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setType(ArrayList<Integer> type) {
        this.type = type;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setStatus(Short status) {
        this.status = status;
    }
    public void setConclusionDate(Date conclusionDate) {
        this.conclusionDate = conclusionDate;
    }
    public void setRating(Short rating) {
        this.rating = rating;
    }
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
}
