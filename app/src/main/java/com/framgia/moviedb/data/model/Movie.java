package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by anh on 19/09/2017.
 */

public class Movie extends BaseModel {
    @SerializedName("original_title")
    @Expose
    private String mTitle;
    @SerializedName("vote_average")
    @Expose
    private float mVoteAverage;
    @SerializedName("poster_path")
    @Expose
    private String mPosterUrl;
    @SerializedName("overview")
    @Expose
    private String mOverview;
    @SerializedName("release_date")
    @Expose
    private Date mReleaseDate;
    private String trailerUrl;
    private ProductorResponse mProductors;
    private ActorResponse mActors;
    private GenreResponse mIdGenres;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        mPosterUrl = posterUrl;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public Date getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public ProductorResponse getProductors() {
        return mProductors;
    }

    public void setProductors(ProductorResponse productors) {
        mProductors = productors;
    }

    public ActorResponse getActors() {
        return mActors;
    }

    public void setActors(ActorResponse actors) {
        mActors = actors;
    }

    public GenreResponse getIdGenres() {
        return mIdGenres;
    }

    public void setIdGenres(GenreResponse idGenres) {
        mIdGenres = idGenres;
    }
}
