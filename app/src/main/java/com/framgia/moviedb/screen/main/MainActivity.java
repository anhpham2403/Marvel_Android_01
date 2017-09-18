package com.framgia.moviedb.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mMainViewModel;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainViewModel = new MainViewModel(getSupportFragmentManager());
        mMainPresenter = new MainPresenter(mMainViewModel);
        mMainViewModel.setMainPresenter(mMainPresenter);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mMainViewModel);
    }
}
