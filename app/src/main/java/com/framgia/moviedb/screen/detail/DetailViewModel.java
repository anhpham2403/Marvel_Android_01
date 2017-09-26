package com.framgia.moviedb.screen.detail;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.genres.GenreAdapter;

/**
 * Exposes the data to be used in the Detail screen.
 */

public class DetailViewModel extends BaseObservable implements DetailContract.ViewModel {
    private Movie mMovie;
    private DetailContract.Presenter mPresenter;
    private Context mContext;
    private GenreAdapter mGenreAdapter;

    public DetailViewModel(Context context, Movie movie) {
        mContext = context;
        mMovie = movie;
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
        mPresenter.getDataMovie(mMovie.getId());
    }

    @Override
    public void getDataMovieSuccess(Movie movie) {
        setMovie(movie);
        setGenreAdapter(new GenreAdapter(movie.getGenres()));
    }

    @Override
    public void getDataMovieFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    @Bindable
    public GenreAdapter getGenreAdapter() {
        return mGenreAdapter;
    }

    public void setGenreAdapter(GenreAdapter genreAdapter) {
        mGenreAdapter = genreAdapter;
        notifyPropertyChanged(BR.genreAdapter);
    }
}
