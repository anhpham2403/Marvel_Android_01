package com.framgia.moviedb.screen.moviesofactor;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.data.source.remote.MovieRemoteDataSource;
import com.framgia.moviedb.data.source.remote.service.MovieServiceClient;
import com.framgia.moviedb.databinding.ActivityMoviesofactorBinding;
import com.framgia.moviedb.screen.BaseActivity;
import com.framgia.moviedb.utils.Constant;

/**
 * Moviesofactor Screen.
 */
public class MoviesofactorActivity extends BaseActivity {

    private MoviesofactorContract.ViewModel mViewModel;

    public static Intent getIntentMoviesOfActor(Context context, Actor actor) {
        Intent intent = new Intent(context, MoviesofactorActivity.class);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Actor actor = getIntent().getExtras().getParcelable(Constant.MOVIES_BUNDLE);
        MovieReposity reposity =
                new MovieReposity(new MovieRemoteDataSource(MovieServiceClient.getInstance()));
        mViewModel = new MoviesofactorViewModel(getApplicationContext(), actor);
        MoviesofactorContract.Presenter presenter =
                new MoviesofactorPresenter(mViewModel, reposity);
        mViewModel.setPresenter(presenter);
        ActivityMoviesofactorBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_moviesofactor);
        binding.setViewModel((MoviesofactorViewModel) mViewModel);
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
