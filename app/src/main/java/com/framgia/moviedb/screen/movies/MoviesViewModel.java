package com.framgia.moviedb.screen.movies;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.detail.DetailActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Movies screen.
 */

public class MoviesViewModel extends BaseObservable
        implements MoviesContract.ViewModel, MovieAdapter.OnItemClickListener {
    public static final int SPAN_COUNT = 2;
    private MoviesContract.Presenter mPresenter;
    private MovieAdapter mAdapter;
    private Context mContext;
    private int mCategory;
    private boolean mIsLoadingMore;
    private int mPage;
    private List<Movie> mMovies;
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

    public MoviesViewModel(Context context, int category) {
        mContext = context;
        mCategory = category;
        mIsLoadingMore = true;
        mPage = 1;
        mMovies = new ArrayList<>();
        mAdapter = new MovieAdapter(mMovies, this);
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
    public void setPresenter(MoviesContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getDataMovies(mCategory, mPage);
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
    public int getSpanCount() {
        return SPAN_COUNT;
    }

    @Override
    public void onGetMoviesSuccess(List<Movie> movies) {
        mAdapter.updateAdapter(movies);
        setLoadingMore(false);
    }

    @Override
    public void onGetMoviesFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
        setLoadingMore(false);
    }

    @Override
    public void onItemClick(Movie movie) {
        mContext.startActivity(DetailActivity.getDetailIntent(mContext, movie));
    }
    @Bindable
    public boolean isLoadingMore() {
        return mIsLoadingMore;
    }

    public void setLoadingMore(boolean loadingMore) {
        mIsLoadingMore = loadingMore;
        notifyPropertyChanged(BR.loadingMore);
    }

    public void loadMore() {
        mPage++;
        mPresenter.getDataMovies(mCategory, mPage);
    }

    @Bindable
    public RecyclerView.OnScrollListener getScrollListener() {
        return mScrollListener;
    }
}
