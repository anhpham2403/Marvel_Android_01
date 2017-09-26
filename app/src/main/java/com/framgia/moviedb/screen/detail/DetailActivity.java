package com.framgia.moviedb.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.databinding.ActivityDetailBinding;
import com.framgia.moviedb.screen.BaseActivity;
import com.framgia.moviedb.utils.Constant;

/**
 * Detail Screen.
 */
public class DetailActivity extends BaseActivity {

    private DetailContract.ViewModel mViewModel;

    public static Intent getDetailIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Constant.MOVIES_BUNDLE, movie);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new DetailViewModel();

        DetailContract.Presenter presenter = new DetailPresenter(mViewModel);
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
}
