package com.framgia.moviedb.screen.listmovies;

/**
 * Listens to user actions from the UI ({@link MoviesActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
public class MoviesActivityPresenter implements MoviesActivityContract.Presenter {
    private final MoviesActivityContract.ViewModel mViewModel;

    public MoviesActivityPresenter(MoviesActivityContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
