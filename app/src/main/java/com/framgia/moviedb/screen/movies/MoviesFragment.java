package com.framgia.moviedb.screen.movies;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.databinding.FragmentMoviesBinding;
import com.framgia.moviedb.screen.BaseFragment;

/**
 * Movies Screen.
 */
public class MoviesFragment extends BaseFragment {

    private MoviesContract.ViewModel mViewModel;

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new MoviesViewModel(getContext());

        MoviesContract.Presenter presenter = new MoviesPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentMoviesBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false);
        binding.setViewModel((MoviesViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
