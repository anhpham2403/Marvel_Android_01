package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.GenreResponse;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.MovieResponse;
import com.framgia.moviedb.data.source.remote.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by anh on 21/09/2017.
 */

public class MovieRemoteDataSource extends BaseRemoteDataSource {
    public MovieRemoteDataSource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Movie>> getPopular(String apiKey) {
        return mMovieApi.getPopular(apiKey).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getNowPlaying(String apiKey) {
        return mMovieApi.getNowPlaying(apiKey).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getUpcoming(String apiKey) {
        return mMovieApi.getUpcoming(apiKey).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getTopRate(String apiKey) {
        return mMovieApi.getTopRate(apiKey).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<List<Genre>> getGenres(String apiKey) {
        return mMovieApi.getGenres(apiKey).map(new Function<GenreResponse, List<Genre>>() {
            @Override
            public List<Genre> apply(GenreResponse genreResponse) throws Exception {
                return genreResponse.getGenres();
            }
        });
    }

    @Override
    public Observable<List<Genre>> getDetail(int id, String apiKey) {
        return mMovieApi.getDetail(id, apiKey).map(new Function<GenreResponse, List<Genre>>() {
            @Override
            public List<Genre> apply(GenreResponse genreResponse) throws Exception {
                return genreResponse.getGenres();
            }
        });
    }
}
