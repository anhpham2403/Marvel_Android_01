package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by anh on 19/09/2017.
 */

public class ActorResponse {
    @SerializedName("cast")
    @Expose
    private List<Actor> mActors;

    public ActorResponse() {
    }

    public ActorResponse(List<Actor> actors) {
        mActors = actors;
    }

    public List<Actor> getActors() {
        return mActors;
    }

    public void setActors(List<Actor> actors) {
        mActors = actors;
    }
}
