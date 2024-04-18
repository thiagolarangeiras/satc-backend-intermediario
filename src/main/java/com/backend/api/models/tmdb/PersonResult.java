package com.backend.api.models.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PersonResult {
    @JsonProperty("adult")
    public boolean adult;

    @JsonProperty("gender")
    public int gender;

    @JsonProperty("id")
    public int id;

    @JsonProperty("known_for_department")
    public String knownForDepartment;

    @JsonProperty("name")
    public String name;

    @JsonProperty("original_name")
    public String originalName;

    @JsonProperty("popularity")
    public double popularity;

    @JsonProperty("profile_path")
    public String profilePath;

    @JsonProperty("known_for")
    public ArrayList<PersonResultKnownfor> knownFor;
}