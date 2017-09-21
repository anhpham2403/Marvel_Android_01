package com.framgia.moviedb.data.model;

import android.databinding.Bindable;
import com.framgia.moviedb.utils.Constant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
    private String mTrailerUrl;
    private ProductorResponse mProductors;
    private ActorResponse mActors;
    private GenreResponse mIdGenres;

    @Bindable
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
        return mTrailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.mTrailerUrl = trailerUrl;
    }

    @Bindable
    public String getPosterUrl() {
        return mPosterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        mPosterUrl = posterUrl;
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

    @Bindable
    public String getDate() {
        SimpleDateFormat dt = new SimpleDateFormat(Constant.DATE_FORMAT_DDMMYYYY, Locale.US);
        return dt.format(mReleaseDate);
    }
}
