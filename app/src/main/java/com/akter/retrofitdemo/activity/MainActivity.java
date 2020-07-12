package com.akter.retrofitdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.akter.retrofitdemo.R;
import com.akter.retrofitdemo.adapter.FlowerListAdapter;
import com.akter.retrofitdemo.modelClass.FlowerData;
import com.akter.retrofitdemo.modelClass.FlowerResponse;
import com.akter.retrofitdemo.retrofit.ApiInterface;
import com.akter.retrofitdemo.retrofit.RetrofitClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    List<FlowerData> allFlowers;
    RecyclerView recyclerView;
    FlowerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize apiInterface
        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);

        recyclerView = findViewById(R.id.recyclerView);

        //api call to get the data
        getAllFlowerData();

    }

    private void getAllFlowerData() {

        apiInterface.getFlowers().enqueue(new Callback<FlowerResponse>() {
            @Override
            public void onResponse(Call<FlowerResponse> call, Response<FlowerResponse> response) {
                if (response.isSuccessful()){

                    allFlowers  = new ArrayList<>();
                    allFlowers.addAll(response.body().getFlowerlist());

                    if (allFlowers.size() > 0){
                        adapter = new FlowerListAdapter(MainActivity.this,allFlowers);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<FlowerResponse> call, Throwable t) {

            }
        });


    }
}