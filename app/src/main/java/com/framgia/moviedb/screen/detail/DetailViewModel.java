package com.framgia.moviedb.screen.detail;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Movie;

/**
 * Exposes the data to be used in the Detail screen.
 */

public class DetailViewModel extends BaseObservable implements DetailContract.ViewModel {
    private Movie mMovie;
    private DetailContract.Presenter mPresenter;

    public DetailViewModel() {
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Bindable
    public Movie getMovie() {
        return mMovie;
    }

    public void setMovie(Movie movie) {
        mMovie = movie;
        notifyPropertyChanged(BR.movie);
    }

    public DetailContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
