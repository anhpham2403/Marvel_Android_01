package com.framgia.moviedb.screen.main;

import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;

/**
 * Created by anh on 19/09/2017.
 */

public class MainContract {
    /**
     * connect presenter
     */
    interface Presenter extends BasePresenter {

    }

    /**
     * connect viewModel
     */
    interface ViewModel extends BaseViewModel<Presenter> {

    }
}
