package com.backend.api.models.tmdb;

import java.util.ArrayList;

public class PersonResult {
    public boolean adult;
    public int gender;
    public int id;
    public String known_for_department;
    public String name;
    public String original_name;
    public double popularity;
    public String profile_path;
    public ArrayList<PersonResultKnownfor> known_for;
}