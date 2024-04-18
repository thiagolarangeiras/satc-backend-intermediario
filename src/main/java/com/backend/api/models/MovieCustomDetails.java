package com.backend.api.models;

import java.util.ArrayList;
import java.util.Date;

public class MovieCustomDetails {
    //public Integer id;
    public String title;
    public ArrayList<Integer> type;
    public String author;
    public Short status;
    public Date conclusionDate;
    public Short rating;
    public String originalTitle;

    public MovieCustomDetails(
            String title,
            ArrayList<Integer> type,
            String author,
            Short status,
            Date conclusionDate,
            Short rating,
            String originalTitle
    ) {
        this.title = title;
        this.type = type;
        this.author = author;
        this.status = status;
        this.conclusionDate = conclusionDate;
        this.rating = rating;
        this.originalTitle = originalTitle;
    }
}
