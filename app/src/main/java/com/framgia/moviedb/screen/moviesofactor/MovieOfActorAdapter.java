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
                ListItemMovieBinding itemListShopBinding =
                        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                R.layout.list_item_movie, parent, false);
                return new ContentViewHolder(itemListShopBinding, mListener);
            default:
                break;
        }
        return null;
    }
    @Override
    public int getItemViewType(int position) {
        return position == 0 ? HEADER : CONTENT;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case HEADER:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.bind(mActor);
                break;
            case CONTENT:
                ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
                contentViewHolder.bind(mMovies.get(position-1));
                break;
            default:
                break;
        }
    }

    public void updateMovies(List<Movie> movies) {
        if (movies == null) {
            return;
        }
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    public void updateActor(Actor actor) {
        if (actor == null) {
            return;
        }
        mActor = actor;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mMovies != null ? mMovies.size() + 1 : 1;
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
