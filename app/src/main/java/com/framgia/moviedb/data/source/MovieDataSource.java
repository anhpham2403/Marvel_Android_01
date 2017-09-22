package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.Movie;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by anh on 21/09/2017.
 */

public interface MovieDataSource {
    Observable<List<Movie>> getPopular(String apiKey);

    Observable<List<Movie>> getNowPlaying(String apiKey);

    Observable<List<Movie>> getUpcoming(String apiKey);

    Observable<List<Movie>> getTopRate(String apiKey);

    Observable<List<Genre>> getGenres(String apiKey);

    Observable<List<Genre>> getDetail(int id, String apiKey);
}
