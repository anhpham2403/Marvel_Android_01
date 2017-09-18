package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anh on 16/09/2017.
 */

public class Genre extends BaseModel {
    @SerializedName("name")
    @Expose
    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }
}
