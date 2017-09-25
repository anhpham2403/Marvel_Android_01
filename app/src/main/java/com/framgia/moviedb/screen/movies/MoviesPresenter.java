package com.framgia.moviedb.screen.movies;

import com.framgia.moviedb.data.model.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link MoviesFragment}), retrieves the data and updates
 * the UI as required.
 */
public final class MoviesPresenter implements MoviesContract.Presenter {
    private MoviesContract.ViewModel mViewModel;
    private List<Movie> mMovies;

    public MoviesPresenter(MoviesContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
        mMovies = new ArrayList<>();
        mViewModel.onGetMoviesSuccess(mMovies);
    }

    @Override
    public void onStop() {
    }
}
