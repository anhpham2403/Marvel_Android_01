package com.framgia.moviedb.data.source.remote.service;

import com.framgia.moviedb.utils.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anh on 21/09/2017.
 */

public class ServiceClient {
    static <T> T createService(String endPoint, Class<T> serviceClass) {
        Gson gson = new GsonBuilder().setDateFormat(Constant.DATE_FORMAT_YYYYMMDD).create();
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(endPoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(serviceClass);
    }
}
