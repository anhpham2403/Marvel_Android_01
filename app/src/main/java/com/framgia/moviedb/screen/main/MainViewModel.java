package com.framgia.moviedb.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.FragmentManager;

/**
 * Created by anh on 18/09/2017.
 */

public class MainViewModel extends BaseObservable implements MainContract.ViewModel {
    private ViewPagerAdapter mAdapter;
    private MainContract.Presenter mMainPresenter;

    public MainViewModel(FragmentManager fragmentManager) {
        mAdapter = new ViewPagerAdapter(fragmentManager);
    }

    @Bindable
    public ViewPagerAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onStart() {
        mMainPresenter.onStart();
    }

    @Override
    public void onStop() {
        mMainPresenter.onStop();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mMainPresenter = presenter;
    }
}
