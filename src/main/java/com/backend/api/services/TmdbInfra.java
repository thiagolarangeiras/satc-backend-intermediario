package com.backend.api.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.backend.api.models.TmdbMovie;
import com.backend.api.models.TmdbResult;

@Service
public class TmdbInfra {
    private RestClient client = RestClient.create("https://api.themoviedb.org/3");
    @Value("${tmdb.key}")
    private String TmdbKey;

    private String formatUri(String endPoint, ArrayList<ArrayList<String>> params){
        endPoint += "?";
        for (ArrayList<String> element : params) {
            endPoint += element.get(0) + "=" + element.get(1) + "&";
        }
        return endPoint;
    }

    public TmdbMovie getMovie(Integer tmdbId){
        System.out.println("VARIAVLE" + TmdbKey);
        
        ArrayList<ArrayList<String>> params = new ArrayList<ArrayList<String>>();
        params.add(new ArrayList<String>() {{ add("language"); add("en-US"); }} );
        String uri = formatUri("/movie/" + tmdbId, params);

        return client.get()
                .uri(uri)
                .header("Authorization", String.format("Bearer %s", TmdbKey))
                .retrieve()
                .body(TmdbMovie.class);
    }

    public ArrayList<TmdbMovie> getMovie(String title, String language, Integer page, String region, Integer year) {
        ArrayList<ArrayList<String>> params = new ArrayList<ArrayList<String>>();
        params.add(new ArrayList<String>() {{ add("query"); add(title); }} );
        params.add(new ArrayList<String>() {{ add("include_adult"); add("false"); }} );
        params.add(new ArrayList<String>() {{ add("page"); add(page.toString()); }} );
        if(language == ""){
            params.add(new ArrayList<String>() {{ add("language"); add("en-US"); }} );
        }
        if(region != "")
            params.add(new ArrayList<String>() {{ add("region"); add(region); }} );
        
        if(year > 0)
            params.add(new ArrayList<String>() {{ add("year"); add(year.toString()); }} );
            //params.add(new ArrayList<String>() {{ add("primary_release_year"); add(year.toString()); }} );    

        String uri = formatUri("/search/movie", params);
        TmdbResult result = client.get()
            .uri(uri)                    
            .header("Authorization", String.format("Bearer %s", TmdbKey))                    
            .retrieve()
            .body(TmdbResult.class);
        return result.getResults();
    }
}