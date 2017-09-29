package com.framgia.moviedb.utils.binding;

<<<<<<< 0d84451198a0427276034dd3f1dae4e3c2710bbb
=======
import android.app.Activity;
import android.content.Context;
>>>>>>> fix ui
import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
<<<<<<< 0d84451198a0427276034dd3f1dae4e3c2710bbb
=======
import android.widget.Toast;
import android.widget.Toolbar;
import com.framgia.moviedb.BuildConfig;
>>>>>>> fix ui
import com.framgia.moviedb.screen.main.ViewPagerAdapter;
import com.framgia.moviedb.utils.Constant;
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
        viewPager.setOffscreenPageLimit(6);
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
    public static void loadImage(ImageView view, String imagePath) {
        String imageUrl = Constant.BASE_URL_IMAGE + imagePath;
        Picasso.with(view.getContext()).load(imageUrl).into(view);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView,
            LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }

    @BindingAdapter({ "scrollListenner" })
    public static void setScrollListenner(RecyclerView recyclerView,
            RecyclerView.OnScrollListener listener) {
        recyclerView.addOnScrollListener(listener);
    }

    @BindingAdapter({ "bind:manager", "bind:fragment" })
    public static void setFragmentManager(FrameLayout layout, FragmentManager manager,
            Fragment fragment) {
        if (fragment == null) {
            return;
        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(layout.getId(), fragment).commit();
    }

    @BindingAdapter({ "bind:back", "bind:title" })
    public static void setBackButtonHome(Toolbar toolbar, final Activity activity, String title) {
        activity.setActionBar(toolbar);
        activity.getActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getActionBar().setTitle(title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
    }
}
