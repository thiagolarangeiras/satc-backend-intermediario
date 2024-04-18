package com.backend.api.models.tmdb;

import java.util.ArrayList;

public class PersonResultRoot {
    public int page;
    public ArrayList<PersonResult> results;
    public int total_pages;
    public int total_results;
}
