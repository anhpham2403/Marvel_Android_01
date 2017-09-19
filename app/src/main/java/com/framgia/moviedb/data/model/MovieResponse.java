package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by anh on 19/09/2017.
 */

public class MovieResponse {
    @SerializedName("results")
    @Expose
    private List<Movie> mMovies;

    public MovieResponse() {
    }

    public MovieResponse(List<Movie> movies) {
        mMovies = movies;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }
}
