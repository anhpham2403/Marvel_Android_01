package com.framgia.moviedb.data.model;

import android.databinding.Bindable;
import com.framgia.moviedb.BR;
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
    private String mLogoUrl;

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getLogoUrl() {
        return mLogoUrl;
    }

    public void setLogoURL(String logoUrl) {
        mLogoUrl = logoUrl;
        notifyPropertyChanged(BR.logoUrl);
    }
}
