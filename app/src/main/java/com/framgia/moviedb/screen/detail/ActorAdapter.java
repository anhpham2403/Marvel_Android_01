package com.framgia.moviedb.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.databinding.ListItemActorBinding;
import java.util.List;

/**
 * Created by anh on 26/09/2017.
 */

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.BindingHolder> {
    public OnItemClick mOnItemClick;
    private List<Actor> mList;

    public ActorAdapter(List<Actor> list, OnItemClick onItemClick) {
        mList = list;
        mOnItemClick = onItemClick;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemActorBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.list_item_actor, parent, false);
        return new BindingHolder(binding, mOnItemClick);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.bind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    /**
     * listener interface
     */
    public interface OnItemClick {
        void onItemClick(Actor actor);
    }

    /**
     * class holder
     */
    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ListItemActorBinding mBinding;
        private OnItemClick mOnItemClick;

        public BindingHolder(ListItemActorBinding binding, OnItemClick onItemClick) {
            super(binding.getRoot());
            mBinding = binding;
            mOnItemClick = onItemClick;
        }

        public void bind(Actor actor) {
            if (actor != null) {
                mBinding.setViewModel(actor);
                mBinding.setListener(mOnItemClick);
                mBinding.executePendingBindings();
            }
        }
    }
}
