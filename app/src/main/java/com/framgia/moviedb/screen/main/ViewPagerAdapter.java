package com.framgia.moviedb.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.moviedb.screen.genres.GenresFragment;
import com.framgia.moviedb.screen.movies.MoviesFragment;
import com.framgia.moviedb.utils.Constant;

/**
 * Created by anh on 18/09/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final int COUNT_FRAGMENT = 6;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constant.NOW_PLAYING_FRAGMENT:
                return MoviesFragment.newInstance(Constant.NOW_PLAYING_FRAGMENT);
            case Constant.UP_COMING_FRAGMENT:
                return MoviesFragment.newInstance(Constant.UP_COMING_FRAGMENT);
            case Constant.POPULAR_FRAGMENT:
                return MoviesFragment.newInstance(Constant.POPULAR_FRAGMENT);
            case Constant.TOP_RATE_FRAGMENT:
                return MoviesFragment.newInstance(Constant.TOP_RATE_FRAGMENT);
            case Constant.FAVORITE_FRAGMENT:
                return MoviesFragment.newInstance(Constant.FAVORITE_FRAGMENT);
            case Constant.GENRES_FRAGMENT:
                return GenresFragment.newInstance();
            default:
                return MoviesFragment.newInstance(Constant.NOW_PLAYING_FRAGMENT);
        }
    }

    @Override
    public int getCount() {
        return COUNT_FRAGMENT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case Constant.NOW_PLAYING_FRAGMENT:
                return Constant.NOW_PLAYING;
            case Constant.UP_COMING_FRAGMENT:
                return Constant.UP_COMING;
            case Constant.POPULAR_FRAGMENT:
                return Constant.POPULAR;
            case Constant.TOP_RATE_FRAGMENT:
                return Constant.TOP_RATE;
            case Constant.GENRES_FRAGMENT:
                return Constant.GENRES;
            case Constant.FAVORITE_FRAGMENT:
                return Constant.FAVORITE;
            default:
                return Constant.NOW_PLAYING;
        }
    }
}
