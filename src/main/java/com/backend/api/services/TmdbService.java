package com.backend.api.services;

import java.util.ArrayList;

import com.backend.api.models.exceptions.TmdbServerOffException;
import com.backend.api.models.tmdb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

@Service
public class TmdbService {
    private RestClient client = RestClient.create("https://api.themoviedb.org/3");
    @Value("${tmdb.key}")
    private String TmdbKey;

    private String formatUri(String endPoint, String[][] params){
        endPoint += "?";
        for (String[] element : params) {
            if(element[1] == null || element[1].isEmpty())
                continue;
            endPoint += element[0] + "=" + element[1] + "&";
        }
        return endPoint;
    }

    private RestClient.ResponseSpec request(String uri) throws TmdbServerOffException{
        try{
            return client.get()
                .uri(uri)
                .header("Authorization", String.format("Bearer %s", TmdbKey))
                .retrieve();
        } catch(HttpClientErrorException e){
            throw new TmdbServerOffException(e.getMessage());
        } catch(HttpServerErrorException e){
            throw new TmdbServerOffException(e.getMessage());
        }
    }

    public MovieDetailsResult getMovie(MovieDetailsSearch movieDetailsSearch) throws TmdbServerOffException{
        String [][] params = {
                {"language", movieDetailsSearch.language}
        };
        String uri = formatUri("/movieq/" + movieDetailsSearch.movieId.toString(), params);
        try{
            return request(uri).body(MovieDetailsResult.class);
        } catch(RestClientResponseException e){
            throw new TmdbServerOffException(e.getMessage());
        }
    }

    public ArrayList<MovieResult> searchMovie(MovieSearch movieSearch) throws TmdbServerOffException{
        String[][] params = {
                {"query", movieSearch.title},
                {"include_adult", movieSearch.includeAdult.toString()},
                {"page", movieSearch.page.toString()},
                {"language", movieSearch.language},
                {"region", movieSearch.region},
                {"year", movieSearch.year},
                {"primary_release_year", movieSearch.primaryReleaseYear}
        };
        String uri = formatUri("/search/movie", params);
        try{
            return request(uri).body(MovieResultRoot.class).results;
        } catch(RestClientResponseException e){
            throw new TmdbServerOffException(e.getMessage());
        }
    }

    public ArrayList<PersonResult> searchPerson(PersonSearch personSearch) throws TmdbServerOffException {
        String[][] params = {
                {"query", personSearch.name},
                {"include_adult", personSearch.includeAdult.toString()},
                {"page", personSearch.page.toString()},
                {"language", personSearch.language}
        };
        String uri = formatUri("/search/person", params);
        try{
            return request(uri).body(PersonResultRoot.class).results;
        } catch(RestClientResponseException e){
            throw new TmdbServerOffException(e.getMessage());
        }
    }
}