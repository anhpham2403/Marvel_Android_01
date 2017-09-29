package com.framgia.moviedb.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Productor;
import com.framgia.moviedb.databinding.ListItemProductorBinding;
import java.util.List;

/**
 * Created by anh on 26/09/2017.
 */

public class ProductorAdapter extends RecyclerView.Adapter<ProductorAdapter.BindingHolder> {
    private List<Productor> mProductorList;
    private OnItemClick mOnItemClick;

    public ProductorAdapter(List<Productor> productorList, OnItemClick onItemClick) {
        mProductorList = productorList;
        mOnItemClick = onItemClick;
    }

    @Override
    public ProductorAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemProductorBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.list_item_productor, parent, false);
        return new ProductorAdapter.BindingHolder(binding, mOnItemClick);
    }

    @Override
    public void onBindViewHolder(ProductorAdapter.BindingHolder holder, int position) {
        holder.bind(mProductorList.get(position));
    }

    @Override
    public int getItemCount() {
        return mProductorList != null ? mProductorList.size() : 0;
    }

    /**
     * listener interface
     */
    public interface OnItemClick {
        void onItemClick(Productor productor);
    }

    /**
     * class holder
     */
    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ListItemProductorBinding mBinding;
        private OnItemClick mOnItemClick;

        public BindingHolder(ListItemProductorBinding binding, OnItemClick onItemClick) {
            super(binding.getRoot());
            mBinding = binding;
            mOnItemClick = onItemClick;
        }

        public void bind(Productor productor) {
            if (productor != null) {
                mBinding.setViewModel(productor);
                mBinding.setListener(mOnItemClick);
                mBinding.executePendingBindings();
            }
        }
    }
}
