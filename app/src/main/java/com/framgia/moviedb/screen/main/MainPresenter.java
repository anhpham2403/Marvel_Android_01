package com.framgia.moviedb.screen.main;

/**
 * Created by anh on 19/09/2017.
 */

public class MainPresenter implements MainContract.Presenter{
    private MainContract.ViewModel mViewModel;

    public MainPresenter(MainContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }
}
