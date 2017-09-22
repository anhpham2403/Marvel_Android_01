package com.framgia.moviedb.screen.main;

import com.framgia.moviedb.data.source.MovieReposity;

/**
 * Created by anh on 19/09/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.ViewModel mViewModel;
    private MovieReposity mMovieReposity;

    public MainPresenter(MainContract.ViewModel viewModel, MovieReposity movieReposity) {
        mMovieReposity = movieReposity;
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
