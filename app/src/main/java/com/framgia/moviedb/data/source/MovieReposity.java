package com.framgia.moviedb.data.source;

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
    public Observable<List<Movie>> getPopular(String apiKey) {
        return mRemoteDataSource.getPopular(apiKey);
    }

    @Override
    public Observable<List<Movie>> getNowPlaying(String apiKey) {
        return mRemoteDataSource.getNowPlaying(apiKey);
    }

    @Override
    public Observable<List<Movie>> getUpcoming(String apiKey) {
        return mRemoteDataSource.getUpcoming(apiKey);
    }

    @Override
    public Observable<List<Movie>> getTopRate(String apiKey) {
        return mRemoteDataSource.getTopRate(apiKey);
    }

    @Override
    public Observable<List<Genre>> getGenres(String apiKey) {
        return mRemoteDataSource.getGenres(apiKey);
    }

    @Override
    public Observable<List<Genre>> getDetail(int id, String apiKey) {
        return mRemoteDataSource.getDetail(id, apiKey);
    }
}
