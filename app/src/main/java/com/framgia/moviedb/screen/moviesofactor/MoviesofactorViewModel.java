package com.framgia.moviedb.screen.moviesofactor;

import android.content.Context;
import android.databinding.Bindable;
import com.framgia.moviedb.data.model.Actor;

/**
 * Exposes the data to be used in the Moviesofactor screen.
 */

public class MoviesofactorViewModel implements MoviesofactorContract.ViewModel {

    private MoviesofactorContract.Presenter mPresenter;
    private Context mContext;
    private Actor mActor;

    public MoviesofactorViewModel(Context context, Actor actor) {
        mActor = actor;
        mContext = context;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(MoviesofactorContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public Actor getActor() {
        return mActor;
    }
}
