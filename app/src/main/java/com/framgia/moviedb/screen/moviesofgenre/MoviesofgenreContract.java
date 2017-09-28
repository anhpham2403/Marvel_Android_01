package com.framgia.moviedb.screen.moviesofgenre;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface MoviesofgenreContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetDataMoviesSuccess(List<Movie> movies);

        void onGetDataMoviesFailure(String msg);

        void onDestroy();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getDataMoviesOfGenre(int id, int page);

        void onDestroy();
    }
}
