package com.framgia.moviedb.screen.moviesofactor;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.databinding.ListItemHeaderActorBinding;
import com.framgia.moviedb.databinding.ListItemMovieBinding;
import com.framgia.moviedb.screen.movies.MovieAdapter;
import java.util.List;

/**
 * Created by anh on 28/09/2017.
 */

public class MovieOfActorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER = 0;
    private static final int CONTENT = 1;
    private MovieAdapter.OnItemClickListener mListener;
    private List<Movie> mMovies;
    private Actor mActor;

    public MovieOfActorAdapter(List<Movie> movies, Actor actor,
            MovieAdapter.OnItemClickListener listener) {
        mListener = listener;
        mMovies = movies;
        mActor = actor;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                ListItemHeaderActorBinding itemHeaderActorBinding =
                        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                R.layout.list_item_header_actor, parent, false);
                return new HeaderViewHolder(itemHeaderActorBinding);
            case CONTENT:
                ItemListShopBinding itemListShopBinding =
                        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                R.layout., parent, false);
                return new ContentViewHolder(itemListShopBinding, mListener);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * class holder
     */
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private ListItemHeaderActorBinding mBinding;

        public HeaderViewHolder(ListItemHeaderActorBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Actor actor) {
            if (actor != null) {
                mBinding.setViewModel(actor);
                mBinding.executePendingBindings();
            }
        }
    }

    /**
     * class holder
     */
    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private ListItemMovieBinding mBinding;
        private MovieAdapter.OnItemClickListener mOnItemClickListener;

        public ContentViewHolder(ListItemMovieBinding binding,
                MovieAdapter.OnItemClickListener onItemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mOnItemClickListener = onItemClickListener;
        }

        public void bind(Movie movie) {
            if (movie != null) {
                mBinding.setViewModel(movie);
                mBinding.setListenner(mOnItemClickListener);
                mBinding.executePendingBindings();
            }
        }
    }
}
