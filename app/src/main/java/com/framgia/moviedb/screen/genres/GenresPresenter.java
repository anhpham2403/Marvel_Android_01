package com.framgia.moviedb.screen.genres;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.source.MovieReposity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link GenresFragment}), retrieves the data and updates
 * the UI as required.
 */
public class GenresPresenter implements GenresContract.Presenter {
    private final GenresContract.ViewModel mViewModel;
    private MovieReposity mReposity;
    private CompositeDisposable mDisposable;

    public GenresPresenter(GenresContract.ViewModel viewModel, MovieReposity reposity) {
        mViewModel = viewModel;
        mReposity = reposity;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void getDataGenres() {
        mDisposable.add(mReposity.getGenres(BuildConfig.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<List<Genre>>() {
                    @Override
                    public void onNext(List<Genre> value) {
                        mViewModel.onGetGenresSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetGenresFailure(e.getMessage());
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
