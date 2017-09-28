package com.framgia.moviedb.screen.moviesofactor;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.movies.MovieAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Moviesofactor screen.
 */

public class MoviesofactorViewModel extends BaseObservable
        implements MoviesofactorContract.ViewModel, MovieAdapter.OnItemClickListener {

    private MoviesofactorContract.Presenter mPresenter;
    private Context mContext;
    private int mPage;
    private boolean mIsLoadingMore;
    private List<Movie> mMovies;
    private Actor mActor;
    private MovieOfActorAdapter mAdapter;
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

    public MoviesofactorViewModel(Context context, Actor actor) {
        mContext = context;
        mPage = 1;
        mIsLoadingMore = true;
        mMovies = new ArrayList<>();
        mActor = actor;
        mAdapter = new MovieOfActorAdapter(mMovies, mActor, this);
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
    public void setPresenter(MoviesofactorContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getMoviesOfAtor(mActor.getId(), mPage);
        mPresenter.getDataActor(mActor.getId());
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
    }

    @Override
    public void onGetDataMoviesSuccess(List<Movie> movies) {
        mAdapter.updateMovies(movies);
        setLoadingMore(false);
    }

    @Override
    public void onGetDataMoviesFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGetDataActorSuccess(Actor actor) {
        mAdapter.updateActor(actor);
    }

    @Override
    public void onGetDataActorFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    @Bindable
    public RecyclerView.OnScrollListener getScrollListener() {
        return mScrollListener;
    }

    public void loadMore() {
        mPage++;
        mPresenter.getMoviesOfAtor(mActor.getId(), mPage);
    }

    @Bindable
    public boolean isLoadingMore() {
        return mIsLoadingMore;
    }

    public void setLoadingMore(boolean loadingMore) {
        mIsLoadingMore = loadingMore;
        notifyPropertyChanged(BR.loadingMore);
    }

    @Bindable
    public MovieOfActorAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(MovieOfActorAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Override
    public void onItemClick(Movie movie) {
        //Todo
    }
}
