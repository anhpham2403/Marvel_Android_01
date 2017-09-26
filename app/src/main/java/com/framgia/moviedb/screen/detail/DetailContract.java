package com.framgia.moviedb.screen.detail;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DetailContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void getDataMovieSuccess(Movie movie);

        void getDataMovieFailure(String msg);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getDataMovie(int id);
    }
}
