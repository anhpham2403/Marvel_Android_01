package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by anh on 19/09/2017.
 */

public class ProductorResponse {
    @SerializedName("production_companies")
    @Expose
    private List<Productor> mProductors;

    public ProductorResponse() {
    }

    public ProductorResponse(List<Productor> productors) {
        mProductors = productors;
    }

    public List<Productor> getProductors() {
        return mProductors;
    }

    public void setProductors(List<Productor> productors) {
        mProductors = productors;
    }
}
