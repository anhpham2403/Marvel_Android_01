package com.framgia.moviedb.screen.moviesofactor;

import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface MoviesofactorContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onDestroy();
        void onGetDataMoviesSuccess(List<Movie> movies);
        void onGetDataMoviesFailure(String msg);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getMoviesOfAtor(int id);
        void onDestroy();
    }
}
