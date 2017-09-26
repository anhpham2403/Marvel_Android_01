package com.framgia.moviedb.screen.detail;

/**
 * Listens to user actions from the UI ({@link DetailActivity}), retrieves the data and updates
 * the UI as required.
 */
public class DetailPresenter implements DetailContract.Presenter {
    private final DetailContract.ViewModel mViewModel;

    public DetailPresenter(DetailContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
