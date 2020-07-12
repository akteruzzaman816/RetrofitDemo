package com.akter.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    List<CountryData> allCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);

        apiInterface.getCountry("1000").enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {

                if (response.isSuccessful()){
                    allCountry = new ArrayList<>();
                    allCountry.addAll(response.body().getData());
                    Log.wtf("countrysize",allCountry.get(0).getCountryName());

                }

            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {

            }
        });


    }
}