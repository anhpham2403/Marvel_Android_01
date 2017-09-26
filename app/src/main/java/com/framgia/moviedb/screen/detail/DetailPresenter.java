package com.framgia.moviedb.screen.detail;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.MovieReposity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Listens to user actions from the UI ({@link DetailActivity}), retrieves the data and updates
 * the UI as required.
 */
public class DetailPresenter implements DetailContract.Presenter {
    private DetailContract.ViewModel mViewModel;
    private MovieReposity mMovieReposity;
    private CompositeDisposable mDisposable;

    public DetailPresenter(DetailContract.ViewModel viewModel, MovieReposity movieReposity) {
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
    public void getDataMovie(int id) {
        mDisposable.add(mMovieReposity.getDetail(id, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Movie>() {
                    @Override
                    public void onNext(Movie value) {
                        mViewModel.getDataMovieSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.getDataMovieFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                }));
    }
}
