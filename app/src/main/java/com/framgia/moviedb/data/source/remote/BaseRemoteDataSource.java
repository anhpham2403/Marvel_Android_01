package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.source.MovieDataSource;
import com.framgia.moviedb.data.source.remote.service.MovieApi;

/**
 * Created by anh on 21/09/2017.
 */

public abstract class BaseRemoteDataSource implements MovieDataSource {
    MovieApi mMovieApi;

    public BaseRemoteDataSource(MovieApi movieApi) {
        mMovieApi = movieApi;
    }
}
