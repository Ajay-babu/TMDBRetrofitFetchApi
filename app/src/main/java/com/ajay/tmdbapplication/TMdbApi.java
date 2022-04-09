package com.ajay.tmdbapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMdbApi {

@GET("3/movie/popular?")
    Call<ResponseModel> getpopularmovies(@Query("api_key") String apikey);

}
