package com.framgia.moviedb;

import android.content.Context;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.screen.movies.MovieAdapter;
import com.framgia.moviedb.screen.movies.MoviesPresenter;
import com.framgia.moviedb.screen.movies.MoviesViewModel;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by anh on 05/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MoviesPresenterTest {
    @Mock
    private MovieReposity mReposity;
    @Mock
    private Context mContext;
    @Spy
    private MoviesViewModel mViewModel = new MoviesViewModel(mContext);
    @Mock
    private MovieAdapter mAdapter;
    @InjectMocks
    private MoviesPresenter mPresenter;

    @Before
    public void setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                new Function<Callable<Scheduler>, Scheduler>() {

                    @Override
                    public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                        return Schedulers.trampoline();
                    }
                });
        mPresenter = new MoviesPresenter(mViewModel, mReposity);
    }

    @Test
    public void getMoviesPopular_shouldReturnTrue_whenGetMovies() throws Exception {
        //Give
        List<Movie> movies = new ArrayList<>();
        int test = 2;
        //When
        when(mReposity.getPopular(anyString(), anyInt())).thenReturn(Observable.just(movies));
        mViewModel.setAdapter(mAdapter);
        mViewModel.setId(test);
        mViewModel.setCategory(test);
        mViewModel.setPresenter(mPresenter);
        //Then
        verify(mViewModel).onGetMoviesSuccess(movies);
    }

    @Test(expected = Throwable.class)
    public void getMoviesPopular_shouldReturnFalse_whenGetMovies() {
        //Give
        int test = 2;
        //When
        when(mReposity.getPopular(anyString(), anyInt())).thenThrow(new Throwable("test"));
        mViewModel.setAdapter(mAdapter);
        mViewModel.setId(test);
        mViewModel.setCategory(test);
        mViewModel.setPresenter(mPresenter);
        //Then
        verify(mViewModel).onGetMoviesFailure(anyString());
    }
}
