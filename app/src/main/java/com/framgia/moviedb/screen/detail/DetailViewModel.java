package com.framgia.moviedb.screen.detail;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.genres.GenreAdapter;
import java.util.List;

/**
 * Exposes the data to be used in the Detail screen.
 */

public class DetailViewModel extends BaseObservable
        implements DetailContract.ViewModel, GenreAdapter.OnItemClickListener {
    private Movie mMovie;
    private DetailContract.Presenter mPresenter;
    private Context mContext;
    private GenreAdapter mGenreAdapter;
    private ActorAdapter mActorAdapter;
    private ProductorAdapter mProductorAdapter;

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
        mPresenter.getDataActors(mMovie.getId());
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
    }

    @Override
    public void getDataMovieSuccess(Movie movie) {
        setMovie(movie);
        setGenreAdapter(new GenreAdapter(movie.getGenres(), this));
        setProductorAdapter(new ProductorAdapter(movie.getProductors()));
    }

    @Override
    public void getDataMovieFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void getDataActorsSuccess(List<Actor> actors) {
        setActorAdapter(new ActorAdapter(actors));
    }

    @Override
    public void getDataActorsFailure(String msg) {
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

    @Bindable
    public ActorAdapter getActorAdapter() {
        return mActorAdapter;
    }

    public void setActorAdapter(ActorAdapter actorAdapter) {
        mActorAdapter = actorAdapter;
        notifyPropertyChanged(BR.actorAdapter);
    }

    @Bindable
    public ProductorAdapter getProductorAdapter() {
        return mProductorAdapter;
    }

    public void setProductorAdapter(ProductorAdapter productorAdapter) {
        mProductorAdapter = productorAdapter;
        notifyPropertyChanged(BR.productorAdapter);
    }

    @Override
    public void onItemClickListener(Genre genre) {
        // TODO: 28/09/2017
    }
}
