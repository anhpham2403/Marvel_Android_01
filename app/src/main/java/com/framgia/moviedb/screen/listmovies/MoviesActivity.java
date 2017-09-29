package com.framgia.moviedb.screen.listmovies;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.Productor;
import com.framgia.moviedb.databinding.ActivityMoviesactivityBinding;
import com.framgia.moviedb.screen.BaseActivity;
import com.framgia.moviedb.utils.Constant;

/**
 * Moviesofgenre Screen.
 */
public class MoviesActivity extends BaseActivity {

    private MoviesActivityContract.ViewModel mViewModel;

    public static Intent getIntentMoviesActivity(Context context, Genre genre) {
        Intent intent = new Intent(context, MoviesActivity.class);
        intent.putExtra(Constant.ID_BUNDLE, Constant.GENRE_BUNDLE);
        intent.putExtra(Constant.BUNDLE, genre);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    public static Intent getIntentMoviesActivity(Context context, Actor actor) {
        Intent intent = new Intent(context, MoviesActivity.class);
        intent.putExtra(Constant.BUNDLE, actor);
        intent.putExtra(Constant.ID_BUNDLE, Constant.ACTOR_BUNDLE);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
    public static Intent getIntentMoviesActivity(Context context, Productor productor) {
        Intent intent = new Intent(context, MoviesActivity.class);
        intent.putExtra(Constant.BUNDLE, productor);
        intent.putExtra(Constant.ID_BUNDLE, Constant.PRODUCTOR_BUNDLE);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FragmentManager fragmentManager = getSupportFragmentManager();
        int category = getIntent().getIntExtra(Constant.ID_BUNDLE, -1);
        switch (category) {
            case Constant.GENRE_BUNDLE:
                Genre genre = getIntent().getExtras().getParcelable(Constant.BUNDLE);
                setTitle(genre.getName());
                mViewModel = new MoviesActivityViewModel(getApplicationContext(), fragmentManager,
                        genre);
                break;
            case Constant.ACTOR_BUNDLE:
                Actor actor = getIntent().getExtras().getParcelable(Constant.BUNDLE);
                setTitle(actor.getName());
                mViewModel = new MoviesActivityViewModel(getApplicationContext(), fragmentManager,
                        actor);
                break;
            case Constant.PRODUCTOR_BUNDLE:
                Productor productor = getIntent().getExtras().getParcelable(Constant.BUNDLE);
                setTitle(productor.getName());
                mViewModel = new MoviesActivityViewModel(getApplicationContext(), fragmentManager,
                        productor);
                break;
            default:
                break;
        }
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
