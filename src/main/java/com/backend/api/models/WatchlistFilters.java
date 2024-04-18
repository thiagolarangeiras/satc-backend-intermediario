package com.backend.api.models;

import java.util.ArrayList;

public class WatchlistFilters {
    private String title;
    private String author;
    private Short status;

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Short getStatus() {
        return status;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setStatus(Short status) {
        this.status = status;
    }
}