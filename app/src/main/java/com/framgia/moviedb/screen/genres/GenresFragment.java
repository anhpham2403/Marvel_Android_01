package com.framgia.moviedb.screen.genres;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.moviedb.R;

/**
 * Created by anh on 20/09/2017.
 */

public class GenresFragment extends Fragment {
    public static GenresFragment newInstance() {
        return new GenresFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_movie, container, false);
    }
}
