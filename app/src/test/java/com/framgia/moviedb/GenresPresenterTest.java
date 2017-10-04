package com.framgia.moviedb;

import android.content.Context;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.screen.genres.GenresPresenter;
import com.framgia.moviedb.screen.genres.GenresViewModel;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by anh on 04/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class GenresPresenterTest {
    @InjectMocks
    private GenresPresenter mPresenter;
    @Mock
    private MovieReposity mReposity;
    @Mock
    private Context mContext;
    private GenresViewModel mViewModel;

    @Before
    public void setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                new Function<Callable<Scheduler>, Scheduler>() {

                    @Override
                    public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                        return Schedulers.trampoline();
                    }
                });
        mViewModel = spy(new GenresViewModel(mContext));
        mPresenter = new GenresPresenter(mViewModel, mReposity);
    }

    @Test
    public void getGenres_shouldReturnTrue_whenGetGenres() throws Exception {
        //Give
        List<Genre> genres = new ArrayList<>();
        //When
        when(mReposity.getGenres(ArgumentMatchers.anyString())).thenReturn(Observable.just(genres));
        //Then
        mViewModel.setPresenter(mPresenter);
        verify(mViewModel).onGetGenresSuccess(genres);
    }

    @Test(expected = Throwable.class)
    public void getGenres_shouldReturnFail_whenGetGenres() {
        //When
        when(mReposity.getGenres(anyString())).thenThrow(new Throwable());
        //Then
        mViewModel.setPresenter(mPresenter);
        verify(mViewModel).onGetGenresFailure(anyString());
    }
}
