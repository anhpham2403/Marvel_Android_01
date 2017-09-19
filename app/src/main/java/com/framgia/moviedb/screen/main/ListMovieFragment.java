package com.framgia.moviedb.screen.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.moviedb.R;

/**
 * Created by anh on 18/09/2017.
 */

public class ListMovieFragment extends Fragment {
    public static ListMovieFragment newInstance() {
        ListMovieFragment fragment = new ListMovieFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_movie, container, false);
    }
}
