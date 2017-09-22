package com.framgia.moviedb.data.source.remote.service;

import com.framgia.moviedb.utils.Constant;

/**
 * Created by anh on 21/09/2017.
 */

public class MovieServiceClient extends ServiceClient {
    private static MovieApi mMovieApi;

    public static MovieApi getInstance() {
        if (mMovieApi == null) {
            mMovieApi = createService(Constant.BASE_URL, MovieApi.class);
        }
        return mMovieApi;
    }
}
