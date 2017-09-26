package com.framgia.moviedb.screen.movies;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.databinding.ListItemMovieBinding;
import java.util.List;

/**
 * Created by anh on 19/09/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.BindingHolder> {
    private List<Movie> mMovies;
    private OnItemClickListener mOnItemClickListener;

    public MovieAdapter(List<Movie> movies, OnItemClickListener onItemClickListener) {
        mMovies = movies;
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemMovieBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.list_item_movie, parent, false);
        return new BindingHolder(binding, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies != null ? mMovies.size() : 0;
    }

    /**
     * OnRecyclerViewItemClickListener
     */
    public interface OnItemClickListener {
        void onItemClick(Movie movie);
    }

    /**
     * class holder
     */
    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ListItemMovieBinding mBinding;
        private OnItemClickListener mOnItemClickListener;

        public BindingHolder(ListItemMovieBinding binding,
                OnItemClickListener onItemClickListener) {
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
