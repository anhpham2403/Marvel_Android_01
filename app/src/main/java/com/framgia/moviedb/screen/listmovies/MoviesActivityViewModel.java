package com.framgia.moviedb.screen.listmovies;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.detail.DetailActivity;
import com.framgia.moviedb.screen.movies.MovieAdapter;
import com.framgia.moviedb.screen.movies.MoviesFragment;
import com.framgia.moviedb.utils.Constant;

/**
 * Exposes the data to be used in the Moviesofgenre screen.
 */

public class MoviesActivityViewModel extends BaseObservable
        implements MoviesActivityContract.ViewModel, MovieAdapter.OnItemClickListener {
    private MoviesActivityContract.Presenter mPresenter;
    private Genre mGenre;
    private Context mContext;
    private FragmentManager mManager;
    private Fragment mFragment;

    public MoviesActivityViewModel(Context context, FragmentManager manager, Genre genre) {
        mGenre = genre;
        mManager = manager;
        mContext = context;
        mFragment = MoviesFragment.newInstance(Constant.MOVIE_OF_GENRES_FRAGMENT, genre.getId());
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
    public void setPresenter(MoviesActivityContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public Genre getGenre() {
        return mGenre;
    }

    @Override
    public void onItemClick(Movie movie) {
        mContext.startActivity(DetailActivity.getDetailIntent(mContext, movie));
    }

    @Bindable
    public FragmentManager getManager() {
        return mManager;
    }

    @Bindable
    public Fragment getFragment() {
        return mFragment;
    }
}
