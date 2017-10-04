package com.framgia.moviedb.genres;

import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.screen.genres.GenresPresenter;
import com.framgia.moviedb.screen.genres.GenresViewModel;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
    @InjectMocks
    private GenresViewModel mViewModel;
    @Before
    public void setUp(){
        mPresenter = new GenresPresenter(mViewModel,mReposity);
    }
    @Test
    public void getGenres_shouldReturnTrue_whenGetGenres() {
        //Give
        List<Genre> genres = new ArrayList<>();
        //When
        when(mReposity.getGenres(ArgumentMatchers.anyString())).thenReturn(Observable.just(genres));
        //Then
        mViewModel.setPresenter(mPresenter);
        verify(mViewModel).onGetGenresSuccess(genres);
    }
}
