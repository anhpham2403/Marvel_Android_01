package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.remote.MovieRemoteDataSource;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by anh on 21/09/2017.
 */

public class MovieReposity implements MovieDataSource {
    private MovieRemoteDataSource mRemoteDataSource;

    public MovieReposity(MovieRemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Movie>> getPopular(String apiKey, int page) {
        return mRemoteDataSource.getPopular(apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getNowPlaying(String apiKey, int page) {
        return mRemoteDataSource.getNowPlaying(apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getUpcoming(String apiKey, int page) {
        return mRemoteDataSource.getUpcoming(apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getTopRate(String apiKey, int page) {
        return mRemoteDataSource.getTopRate(apiKey, page);
    }

    @Override
    public Observable<List<Genre>> getGenres(String apiKey) {
        return mRemoteDataSource.getGenres(apiKey);
    }

    @Override
    public Observable<Movie> getDetail(int id, String apiKey) {
        return mRemoteDataSource.getDetail(id, apiKey);
    }

    @Override
    public Observable<List<Actor>> getActorsByIdMovie(int id, String apiKey) {
        return mRemoteDataSource.getActorsByIdMovie(id, apiKey);
    }

    @Override
    public Observable<List<Movie>> getMoviesByIdGenre(int id, String apiKey) {
        return mRemoteDataSource.getMoviesByIdGenre(id, apiKey);
    }

    @Override
    public Observable<List<Movie>> getMoviesByIdActor(int id, String apiKey) {
        return mRemoteDataSource.getMoviesByIdActor(id, apiKey);
    }

    @Override
    public Observable<List<Movie>> getMoviesByIdProductor(int id, String apiKey) {
        return mRemoteDataSource.getMoviesByIdProductor(id, apiKey);
    }
}
