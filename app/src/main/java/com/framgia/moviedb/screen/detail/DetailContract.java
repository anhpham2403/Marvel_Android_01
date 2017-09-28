package com.framgia.moviedb.screen.detail;

import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DetailContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onDestroy();

        void getDataMovieSuccess(Movie movie);

        void getDataMovieFailure(String msg);

        void getDataActorsSuccess(List<Actor> actors);

        void getDataActorsFailure(String msg);

        void getTrailerSuccess(String keyVideo);

        void getTrailerFailure(String msg);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void onDestroy();

        void getDataMovie(int id);

        void getDataActors(int id);

        void getTrailer(int id);
    }
}
