package com.framgia.moviedb.screen.movies;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.data.source.remote.MovieRemoteDataSource;
import com.framgia.moviedb.data.source.remote.service.MovieServiceClient;
import com.framgia.moviedb.databinding.FragmentMoviesBinding;
import com.framgia.moviedb.screen.BaseFragment;
import com.framgia.moviedb.utils.Constant;

/**
 * Movies Screen.
 */
public class MoviesFragment extends BaseFragment {
    int category;
    MoviesContract.Presenter presenter;
    private MoviesContract.ViewModel mViewModel;
    private MovieReposity mMovieReposity;

    public static MoviesFragment newInstance(int category) {
        MoviesFragment fragment = new MoviesFragment();
        Bundle args = new Bundle();
        args.putInt(Constant.MOVIES_BUNDLE, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovieReposity =
                new MovieReposity(new MovieRemoteDataSource(MovieServiceClient.getInstance()));
        category = getArguments().getInt(Constant.MOVIES_BUNDLE);
        mViewModel = new MoviesViewModel(getContext(), category);
        presenter = new MoviesPresenter(mViewModel, mMovieReposity);
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

    @Override
    public void onDestroy() {
        ((MoviesPresenter) presenter).onDestroy();
        super.onDestroy();
    }
}
