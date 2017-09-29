package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.Productor;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by anh on 21/09/2017.
 */

public interface MovieDataSource {
    Observable<List<Movie>> getPopular(String apiKey, int page);

    Observable<List<Movie>> getNowPlaying(String apiKey, int page);

    Observable<List<Movie>> getUpcoming(String apiKey, int page);

    Observable<List<Movie>> getTopRate(String apiKey, int page);

    Observable<List<Genre>> getGenres(String apiKey);

    Observable<Movie> getDetail(int id, String apiKey);

    Observable<List<Actor>> getActorsByIdMovie(int id, String apiKey);

    Observable<List<Movie>> getMoviesByIdGenre(int id, String apiKey, int page);

    Observable<List<Movie>> getMoviesByIdActor(int id, String apiKey, int page);

    Observable<List<Movie>> getMoviesByIdProductor(int id, String apiKey, int page);

    Observable<Actor> getActor(String apiKey, int id);

    Observable<Productor> getProductor(String apiKey, int id);

    Observable<String> getTrailer(String apiKey, int id);
}