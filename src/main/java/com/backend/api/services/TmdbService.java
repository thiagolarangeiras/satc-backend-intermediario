package com.backend.api.services;

import java.util.ArrayList;

import com.backend.api.models.tmdb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

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

    public MovieDetailsResult getMovie(MovieDetailsSearch movieDetailsSearch){
        String [][] params = {
                {"language", movieDetailsSearch.language}
        };

        String uri = formatUri("/movie/" + movieDetailsSearch.movieId.toString(), params);

        return client.get()
                .uri(uri)
                .header("Authorization", String.format("Bearer %s", TmdbKey))
                .retrieve()
                .body(MovieDetailsResult.class);
    }

    public ArrayList<PersonResult> searchPerson(PersonSearch personSearch) {
        String[][] params = {
                {"query", personSearch.name},
                {"include_adult", personSearch.includeAdult.toString()},
                {"page", personSearch.page.toString()},
                {"language", personSearch.language}
        };

        String uri = formatUri("/search/person", params);
        PersonResultRoot result = client.get()
            .uri(uri)
            .header("Authorization", String.format("Bearer %s", TmdbKey))
            .retrieve()
            .body(PersonResultRoot.class);
        return result.results;
    }

    public ArrayList<MovieResult> searchMovie(MovieSearch movieSearch) {
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
        MovieResultRoot result = client.get()
                .uri(uri)
                .header("Authorization", String.format("Bearer %s", TmdbKey))
                .retrieve()
                .body(MovieResultRoot.class);
        return result.results;
    }
}