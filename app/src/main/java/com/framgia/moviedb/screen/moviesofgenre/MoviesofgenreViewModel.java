package com.framgia.moviedb.screen.moviesofgenre;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.android.databinding.library.baseAdapters.BR;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.detail.DetailActivity;
import com.framgia.moviedb.screen.movies.MovieAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Moviesofgenre screen.
 */

public class MoviesofgenreViewModel extends BaseObservable
        implements MoviesofgenreContract.ViewModel, MovieAdapter.OnItemClickListener {
    private MoviesofgenreContract.Presenter mPresenter;
    private boolean isLoadingMore;
    private Genre mGenre;
    private Context mContext;
    private List<Movie> mMovies;
    private MovieAdapter mAdapter;
    private int mPage;
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (dy <= 0) {
                return;
            }
            LinearLayoutManager layoutManager =
                    (LinearLayoutManager) recyclerView.getLayoutManager();
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
            if (!isLoadingMore() && (visibleItemCount + pastVisibleItems) >= totalItemCount) {
                setLoadingMore(true);
                loadMore();
            }
        }
    };

    public MoviesofgenreViewModel(Context context, Genre genre) {
        mGenre = genre;
        mContext = context;
        isLoadingMore = true;
        mMovies = new ArrayList<>();
        mAdapter = new MovieAdapter(mMovies, this);
        mPage = 1;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(MoviesofgenreContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getDataMoviesOfGenre(mGenre.getId(), mPage);
    }

    @Override
    public void onGetDataMoviesSuccess(List<Movie> movies) {
        mAdapter.updateAdapter(movies);
        setLoadingMore(false);
    }

    @Override
    public void onGetDataMoviesFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
        setLoadingMore(false);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
    }

    @Bindable
    public boolean isLoadingMore() {
        return isLoadingMore;
    }

    public void setLoadingMore(boolean loadingMore) {
        isLoadingMore = loadingMore;
        notifyPropertyChanged(BR.loadingMore);
    }

    @Bindable
    public Genre getGenre() {
        return mGenre;
    }

    @Override
    public void onItemClick(Movie movie) {
        mContext.startActivity(DetailActivity.getDetailIntent(mContext, movie)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public void loadMore() {
        mPage++;
        mPresenter.getDataMoviesOfGenre(mGenre.getId(), mPage);
    }

    @Bindable
    public MovieAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(MovieAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Bindable
    public RecyclerView.OnScrollListener getScrollListener() {
        return mScrollListener;
    }
}
