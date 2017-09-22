package com.framgia.moviedb.data.source.remote.service;

import com.framgia.moviedb.data.model.GenreResponse;
import com.framgia.moviedb.data.model.MovieResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by anh on 21/09/2017.
 */

public interface MovieApi {
    @GET("movie/popular")
    Observable<MovieResponse> getPopular(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Observable<MovieResponse> getNowPlaying(@Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Observable<MovieResponse> getUpcoming(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRate(@Query("api_key") String apiKey);

    @GET("genre/movie/list")
    Observable<GenreResponse> getGenres(@Query("api_key") String apiKey);

    @GET("genre/movie/{id}")
    Observable<GenreResponse> getDetail(@Path("id") int id, @Query("api_key") String apiKey);
}
