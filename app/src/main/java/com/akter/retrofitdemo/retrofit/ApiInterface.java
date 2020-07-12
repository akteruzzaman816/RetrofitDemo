package com.akter.retrofitdemo.retrofit;

import com.akter.retrofitdemo.modelClass.FlowerResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("flowers.json")
    Call<FlowerResponse> getFlowers();



}
