package com.framgia.moviedb.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.data.source.remote.MovieRemoteDataSource;
import com.framgia.moviedb.data.source.remote.service.MovieServiceClient;
import com.framgia.moviedb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainContract.ViewModel mMainViewModel;
    private MainContract.Presenter mMainPresenter;
    private ActivityMainBinding mBinding;
    private MovieReposity mMovieReposity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovieReposity =
                new MovieReposity(new MovieRemoteDataSource(MovieServiceClient.getInstance()));
        mMainViewModel = new MainViewModel(getSupportFragmentManager());
        mMainPresenter = new MainPresenter(mMainViewModel, mMovieReposity);
        mMainViewModel.setPresenter(mMainPresenter);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setViewModel((MainViewModel) mMainViewModel);
    }
}
