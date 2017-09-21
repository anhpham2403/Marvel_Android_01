package com.framgia.moviedb.screen.genres;

import com.framgia.moviedb.data.model.Genre;
import java.util.ArrayList;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link GenresFragment}), retrieves the data and updates
 * the UI as required.
 */
public class GenresPresenter implements GenresContract.Presenter {
    private final GenresContract.ViewModel mViewModel;
    private List<Genre> mGenres;

    public GenresPresenter(GenresContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
        mGenres = new ArrayList<>();
        mViewModel.onGetGenreSuccess(mGenres);
    }

    @Override
    public void onStop() {
    }
}
