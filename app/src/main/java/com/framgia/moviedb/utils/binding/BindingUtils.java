package com.framgia.moviedb.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import com.framgia.moviedb.screen.main.ViewPagerAdapter;

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
}
