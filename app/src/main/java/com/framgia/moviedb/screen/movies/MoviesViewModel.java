package com.framgia.moviedb.screen.movies;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Movie;
import java.util.List;

/**
 * Exposes the data to be used in the Movies screen.
 */

public class MoviesViewModel extends BaseObservable implements MoviesContract.ViewModel {
    public static final int SPAN_COUNT = 2;
    private MoviesContract.Presenter mPresenter;
    private MovieAdapter mAdapter;
    private Context mContext;
    private int mCategory;
    private boolean mIsComplete;

    public MoviesViewModel(Context context, int category) {
        mContext = context;
        mCategory = category;
        mIsComplete = false;
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
    public void setPresenter(MoviesContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getDataMovies(mCategory);
    }

    @Bindable
    public MovieAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(MovieAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Bindable
    public int getSpanCount() {
        return SPAN_COUNT;
    }
    @Bindable
    public boolean isComplete() {
        return mIsComplete;
    }

    public void setComplete(boolean complete) {
        mIsComplete = complete;
        notifyPropertyChanged(BR.complete);
    }

    @Override
    public void onGetMoviesSuccess(List<Movie> movies) {
        setAdapter(new MovieAdapter(movies));
        setComplete(true);
    }

    @Override
    public void onGetMoviesFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
        setComplete(true);
    }
}
