package com.framgia.moviedb.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.MovieReposity;
import com.framgia.moviedb.data.source.remote.MovieRemoteDataSource;
import com.framgia.moviedb.data.source.remote.service.MovieServiceClient;
import com.framgia.moviedb.databinding.ActivityDetailBinding;
import com.framgia.moviedb.utils.Constant;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

/**
 * Detail Screen.
 */
public class DetailActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener,ActorAdapter.OnItemClickListener {
    private DetailContract.ViewModel mViewModel;

    public static Intent getDetailIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Constant.MOVIES_BUNDLE, movie);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieReposity mMovieReposity =
                new MovieReposity(new MovieRemoteDataSource(MovieServiceClient.getInstance()));
        Movie mMovie = getIntent().getExtras().getParcelable(Constant.MOVIES_BUNDLE);
        mViewModel = new DetailViewModel(getApplicationContext(), mMovie);
        DetailContract.Presenter presenter = new DetailPresenter(mViewModel, mMovieReposity);
        mViewModel.setPresenter(presenter);
        ActivityDetailBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setViewModel((DetailViewModel) mViewModel);
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
        mViewModel.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
            YouTubePlayer youTubePlayer, boolean b) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
            YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    public void onItemClickListener(Actor actor) {

    }
}
