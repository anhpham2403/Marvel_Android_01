package com.framgia.moviedb.screen.movies;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.utils.Constant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link MoviesFragment}), retrieves the data and updates
 * the UI as required.
 */
public class MoviesPresenter implements MoviesContract.Presenter {
    private MoviesContract.ViewModel mViewModel;
    private CompositeDisposable mDisposable;
    private MovieReposity mMovieReposity;

    public MoviesPresenter(MoviesContract.ViewModel viewModel, MovieReposity movieReposity) {
        mViewModel = viewModel;
        mDisposable = new CompositeDisposable();
        mMovieReposity = movieReposity;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void getDataMovies(int category, int page) {
        Observable<List<Movie>> observable = null;
        switch (category) {
            case Constant.POPULAR_FRAGMENT:
                observable = mMovieReposity.getPopular(BuildConfig.API_KEY, page);
                break;
            case Constant.NOW_PLAYING_FRAGMENT:
                observable = mMovieReposity.getNowPlaying(BuildConfig.API_KEY, page);
                break;
            case Constant.UP_COMING_FRAGMENT:
                observable = mMovieReposity.getUpcoming(BuildConfig.API_KEY, page);
                break;
            case Constant.TOP_RATE_FRAGMENT:
                observable = mMovieReposity.getTopRate(BuildConfig.API_KEY, page);
                break;
            case Constant.FAVORITE_FRAGMENT:
                break;
            default:
                observable = mMovieReposity.getPopular(BuildConfig.API_KEY, page);
                break;
        }
        if (observable == null) {
            return;
        }
        mDisposable.add(observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Movie>>() {
                    @Override
                    public void onNext(List<Movie> value) {
                        mViewModel.onGetMoviesSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetMoviesFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    public void onDestroy() {
        mDisposable.dispose();
    }
}