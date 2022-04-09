package com.ajay.tmdbapplication;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TMDBRetrofitAPI {
    //TODO: to fetch JSON data and convert to user mode

    public static final String BASE_URL = "https://api.themoviedb.org";

    public static <S> S getInstance(Class<S> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        return retrofit.create(serviceClass);
    }
}
