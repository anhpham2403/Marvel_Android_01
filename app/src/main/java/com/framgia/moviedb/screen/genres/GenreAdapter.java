package com.framgia.moviedb.screen.genres;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.databinding.ListItemGenreBinding;
import java.util.List;

/**
 * Created by anh on 19/09/2017.
 */

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.BindingHolder> {
    private List<Genre> mGenres;

    public GenreAdapter(List<Genre> genres) {
        mGenres = genres;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemGenreBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.list_item_genre, parent, false);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.bind(mGenres.get(position));
    }

    @Override
    public int getItemCount() {
        return mGenres != null ? mGenres.size() : 0;
    }

    /**
     * hold item
     */
    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ListItemGenreBinding mBinding;

        public BindingHolder(ListItemGenreBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Genre genre) {
            if (genre != null) {
                mBinding.setViewModel(genre);
                mBinding.executePendingBindings();
            }
        }
    }
}
