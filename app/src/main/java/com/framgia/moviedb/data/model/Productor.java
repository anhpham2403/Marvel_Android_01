package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anh on 16/09/2017.
 */

public class Productor extends BaseModel {
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("logo_path")
    @Expose
    private String mLogoURL;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getLogoURL() {
        return mLogoURL;
    }

    public void setLogoURL(String logoURL) {
        mLogoURL = logoURL;
    }
}
