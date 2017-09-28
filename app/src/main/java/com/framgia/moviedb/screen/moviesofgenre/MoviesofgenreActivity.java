package com.framgia.moviedb.screen.moviesofgenre;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.data.source.remote.MovieRemoteDataSource;
import com.framgia.moviedb.data.source.remote.service.MovieServiceClient;
import com.framgia.moviedb.databinding.ActivityMoviesofgenreBinding;
import com.framgia.moviedb.screen.BaseActivity;
import com.framgia.moviedb.utils.Constant;

/**
 * Moviesofgenre Screen.
 */
public class MoviesofgenreActivity extends BaseActivity {

    private MoviesofgenreContract.ViewModel mViewModel;

    public static Intent getIntentMoviesOfGenre(Context context, Genre genre) {
        Intent intent = new Intent(context, MoviesofgenreActivity.class);
        intent.putExtra(Constant.GENRES_BUNDLE, genre);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Genre genre = getIntent().getExtras().getParcelable(Constant.GENRES_BUNDLE);
        mViewModel = new MoviesofgenreViewModel(getApplicationContext(), genre);
        MovieReposity movieReposity =
                new MovieReposity(new MovieRemoteDataSource(MovieServiceClient.getInstance()));
        MoviesofgenreContract.Presenter presenter =
                new MoviesofgenrePresenter(mViewModel, movieReposity);
        mViewModel.setPresenter(presenter);
        ActivityMoviesofgenreBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_moviesofgenre);
        binding.setViewModel((MoviesofgenreViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
