package com.example.managerpakingcar.api;

import com.example.managerpakingcar.BaseResponseModel;
import com.example.managerpakingcar.SignUpRequestModel;
import com.example.managerpakingcar.UserRequestModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    //https://core-java-api-app.herokuapp.com/users/sign-in
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .setLenient()
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://core-api-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @GET("hello")
    Call<String> getSayHello();

    @POST("users/sign-in")
    Call<BaseResponseModel<String>> signIn(@Body UserRequestModel user);

    @POST("users/sign-up")
    Call<BaseResponseModel<String>> signUp(@Body SignUpRequestModel user);

}
