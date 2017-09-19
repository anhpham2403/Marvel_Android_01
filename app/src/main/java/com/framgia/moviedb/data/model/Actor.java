package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by anh on 16/09/2017.
 */

public class Actor extends BaseModel {
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("profiles")
    @Expose
    private List<String> mAvatarUrl;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public List<String> getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(List<String> avatarUrl) {
        mAvatarUrl = avatarUrl;
    }
}