package com.backend.api.services;

import com.backend.api.models.InsertMovie;
import com.backend.api.models.MovieCustomDetails;
import com.backend.api.models.WatchlistData;
import com.backend.api.models.exceptions.TmdbServerOffException;
import com.backend.api.models.tmdb.MovieDetailsResult;
import com.backend.api.models.tmdb.MovieDetailsSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WatchlistService {
    @Autowired
    private TmdbService tmdbService;
    private ArrayList<WatchlistData> watchlist = new ArrayList<WatchlistData>();

    public Integer addMovie(Integer tmdbId, MovieCustomDetails movieCustomDetails) throws TmdbServerOffException {
        MovieDetailsResult tmdbMovie = tmdbService.getMovie(new MovieDetailsSearch(tmdbId));
        WatchlistData data = new WatchlistData();
        data.movieData = movieCustomDetails;
        data.tmdbMovieData = tmdbMovie;
        watchlist.add(data);
        return watchlist.size()-1;
    }

    public Integer editMovie(Integer id, Integer tmdbId, MovieCustomDetails movieCustomDetails) throws TmdbServerOffException{
        WatchlistData data = watchlist.get(id);
        if(data.tmdbMovieData == null || data.tmdbMovieData.id != tmdbId){ // testar null error
            MovieDetailsResult tmdbMovie = tmdbService.getMovie(new MovieDetailsSearch(tmdbId));
            data.tmdbMovieData = tmdbMovie;
        }
        if(movieCustomDetails != null){
            data.movieData = movieCustomDetails;
        }
        return id;
    }

    public Integer removeMovie(Integer id){
        WatchlistData data = watchlist.get(id);
        watchlist.remove(data);
        return id;
    }

    public ArrayList<WatchlistData> getWatchlist(){
        return watchlist;
    }

    public WatchlistData getMovie(Integer id){
        WatchlistData data = watchlist.get(id);
        return data;
    }

    public WatchlistData getMovie(){
        WatchlistData data = watchlist.get(1);
        return data;
    }
}