package com.framgia.moviedb.screen.moviesofactor;

import com.framgia.moviedb.data.source.MovieReposity;

/**
 * Listens to user actions from the UI ({@link MoviesofactorActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
public class MoviesofactorPresenter implements MoviesofactorContract.Presenter {

    private final MoviesofactorContract.ViewModel mViewModel;
    private MovieReposity mMovieReposity;

    public MoviesofactorPresenter(MoviesofactorContract.ViewModel viewModel,
            MovieReposity movieReposity) {
        mViewModel = viewModel;
        mMovieReposity = movieReposity;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
