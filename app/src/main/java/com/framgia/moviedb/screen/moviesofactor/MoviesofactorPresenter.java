package com.framgia.moviedb.screen.moviesofactor;

import android.util.Log;
import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.MovieReposity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link MoviesofactorActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
public class MoviesofactorPresenter implements MoviesofactorContract.Presenter {

    private final MoviesofactorContract.ViewModel mViewModel;
    private MovieReposity mMovieReposity;
    private CompositeDisposable mDisposable;

    public MoviesofactorPresenter(MoviesofactorContract.ViewModel viewModel,
            MovieReposity movieReposity) {
        mViewModel = viewModel;
        mMovieReposity = movieReposity;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void getMoviesOfAtor(int id, int page) {
        mDisposable.add(mMovieReposity.getMoviesByIdActor(id, BuildConfig.API_KEY, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<List<Movie>>() {
                    @Override
                    public void onNext(List<Movie> value) {
                        mViewModel.onGetDataMoviesSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetDataMoviesFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void getDataActor(int id) {
        mDisposable.add(mMovieReposity.getActor(BuildConfig.API_KEY, id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<Actor>() {
                    @Override
                    public void onNext(Actor value) {
                        mViewModel.onGetDataActorSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetDataActorFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void onDestroy() {
        mDisposable.dispose();
    }
}
