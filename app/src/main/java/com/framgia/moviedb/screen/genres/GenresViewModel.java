package com.framgia.moviedb.screen.genres;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.screen.listmovies.MoviesActivity;
import java.util.List;

/**
 * Exposes the data to be used in the Genres screen.
 */

public class GenresViewModel extends BaseObservable
        implements GenresContract.ViewModel, GenreAdapter.OnItemClickListener {

    private GenresContract.Presenter mPresenter;
    private GenreAdapter mAdapter;
    private Context mContext;

    public GenresViewModel(Context context) {
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
    public void setPresenter(GenresContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getDataGenres();
    }

    @Override
    public void onGetGenresSuccess(List<Genre> response) {
        setAdapter(new GenreAdapter(response, this));
    }

    @Override
    public void onGetGenresFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    @Bindable
    public GenreAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(GenreAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
    }

    @Override
    public void onItemClickListener(Genre genre) {
        mContext.startActivity(MoviesActivity.getIntentMoviesOfGenre(mContext, genre));
    }
}
