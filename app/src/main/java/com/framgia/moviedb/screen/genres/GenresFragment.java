package com.framgia.moviedb.screen.genres;

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
import com.framgia.moviedb.databinding.FragmentGenresBinding;
import com.framgia.moviedb.screen.BaseFragment;

/**
 * Genres Screen.
 */
public class GenresFragment extends BaseFragment {
    private GenresContract.ViewModel mViewModel;

    public static GenresFragment newInstance() {
        return new GenresFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new GenresViewModel(getContext());
        MovieReposity movieReposity =
                new MovieReposity(new MovieRemoteDataSource(MovieServiceClient.getInstance()));
        GenresContract.Presenter presenter = new GenresPresenter(mViewModel, movieReposity);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentGenresBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_genres, container, false);
        binding.setViewModel((GenresViewModel) mViewModel);
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
        mViewModel.onDestroy();
        super.onDestroy();
    }
}
