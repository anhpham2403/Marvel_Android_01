package com.framgia.moviedb.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.framgia.moviedb.screen.main.ViewPagerAdapter;
import com.framgia.moviedb.utils.LayoutManagers;
import com.squareup.picasso.Picasso;

/**
 * Created by anh on 18/09/2017.
 */

public final class BindingUtils {
    private BindingUtils() {
    }

    @BindingAdapter({ "bind:viewPagerAdapter" })
    public static void setAdapterForViewPager(ViewPager viewPager, ViewPagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }

    @BindingAdapter({ "bind:viewPager" })
    public static void setViewPagerForTabLayout(TabLayout tabLayout, ViewPager viewPager) {
        tabLayout.setupWithViewPager(viewPager);
    }

    @BindingAdapter({ "bind:recyclerAdapter" })
    public static void setAdapterForRecyclerView(RecyclerView recyclerView,
            RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({ "bind:imageUrl" })
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext()).load(imageUrl).into(view);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView,
            LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        if (recyclerView.getAdapter() != null) {
            recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
        }
    }
}
