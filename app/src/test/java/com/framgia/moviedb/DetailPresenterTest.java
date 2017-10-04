package com.framgia.moviedb;

import android.content.Context;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.screen.detail.DetailPresenter;
import com.framgia.moviedb.screen.detail.DetailViewModel;
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
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by anh on 05/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DetailPresenterTest {
    @Mock
    private MovieReposity mReposity;
    @Mock
    private Context mContext;
    @InjectMocks
    private DetailPresenter mPresenter;
    @Mock
    private Movie mMovie;
    private DetailViewModel mViewModel;

    @Before
    public void setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                new Function<Callable<Scheduler>, Scheduler>() {

                    @Override
                    public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                        return Schedulers.trampoline();
                    }
                });
        mViewModel = spy(new DetailViewModel(mContext, mMovie));
        mPresenter = new DetailPresenter(mViewModel, mReposity);
    }

    @Test
    public void getDataMovie_shouldReturnTrue_whenGetDataMovie() throws Exception {
        //Give
        Movie movie = new Movie();
        List<Actor> actors = new ArrayList<>();
        //When
        when(mReposity.getDetail(anyInt(), anyString())).thenReturn(Observable.just(movie));
        when(mReposity.getActorsByIdMovie(anyInt(), anyString())).thenReturn(
                Observable.just(actors));
        when(mReposity.getTrailer(anyString(), anyInt())).thenReturn(Observable.just(anyString()));
        //Then
        mViewModel.setPresenter(mPresenter);
        verify(mViewModel).getDataMovieSuccess(movie);
        verify(mViewModel).getTrailerSuccess(anyString());
        verify(mViewModel).getDataActorsSuccess(actors);
    }

    @Test(expected = Throwable.class)
    public void getDataMovie_shouldReturnFail_wwhenGetDataMovie() {
        //Give
        Throwable throwable = new Throwable("test");
        //When
        when(mReposity.getDetail(anyInt(), anyString())).thenThrow(throwable);
        when(mReposity.getActorsByIdMovie(anyInt(), anyString())).thenThrow(throwable);
        when(mReposity.getTrailer(anyString(), anyInt())).thenThrow(throwable);
        //Then
        mViewModel.setPresenter(mPresenter);
        verify(mViewModel).getDataMovieFailure(anyString());
        verify(mViewModel).getDataActorsFailure(anyString());
        verify(mViewModel).getTrailerFailure(anyString());
    }
}
