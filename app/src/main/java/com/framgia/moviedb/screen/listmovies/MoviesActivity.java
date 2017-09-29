package com.framgia.moviedb.screen.listmovies;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.databinding.ActivityMoviesactivityBinding;
import com.framgia.moviedb.screen.BaseActivity;
import com.framgia.moviedb.utils.Constant;

/**
 * Moviesofgenre Screen.
 */
public class MoviesActivity extends BaseActivity {

    private MoviesActivityContract.ViewModel mViewModel;

    public static Intent getIntentMoviesOfGenre(Context context, Genre genre) {
        Intent intent = new Intent(context, MoviesActivity.class);
        intent.putExtra(Constant.GENRES_BUNDLE, genre);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Genre genre = getIntent().getExtras().getParcelable(Constant.GENRES_BUNDLE);
        setTitle(genre.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewModel = new MoviesActivityViewModel(getApplicationContext(), fragmentManager, genre);
        MoviesActivityContract.Presenter presenter = new MoviesActivityPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        ActivityMoviesactivityBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_moviesactivity);
        binding.setViewModel((MoviesActivityViewModel) mViewModel);
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
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
