package com.akter.retrofitdemo.retrofit;

import com.akter.retrofitdemo.modelClass.FlowerResponse;
import com.akter.retrofitdemo.modelClass.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {


    @GET("flowers.json")
    Call<FlowerResponse> getFlowers();

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> userLogin(@Field("username") String userName, @Field("password") String password);



}
