package com.akter.retrofitdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akter.retrofitdemo.R;
import com.akter.retrofitdemo.modelClass.LoginResponse;
import com.akter.retrofitdemo.retrofit.ApiInterface;
import com.akter.retrofitdemo.retrofit.RetrofitClient;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    Button loginButton;
    EditText userNameEditText,passwordEditText;
    SpotsDialog spotsDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        apiInterface       = RetrofitClient.getRetrofit("https://midemart.000webhostapp.com/api/").create(ApiInterface.class);

        loginButton        = findViewById(R.id.button_login);
        userNameEditText   = findViewById(R.id.edit_email);
        passwordEditText   = findViewById(R.id.edit_password);
        spotsDialog        = new SpotsDialog(LoginActivity.this,R.style.Custom);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String name         = userNameEditText.getText().toString();
                    String pass         = passwordEditText.getText().toString();

                    if (name.isEmpty()){
                        userNameEditText.setError("Email");
                        return;
                    }else if (pass.isEmpty()){
                        passwordEditText.setError("Password");
                        return;
                    }
                    spotsDialog.show();

                    apiInterface.userLogin(name,pass).enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                            if (response.isSuccessful()){

                                if (response.body().getStatusCode() == 1){
                                    spotsDialog.dismiss();
                                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    spotsDialog.dismiss();
                                    Toast.makeText(LoginActivity.this, "Failed to login", Toast.LENGTH_SHORT).show();
                                }

                            }

                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {

                        }
                    });




            }
        });





    }
}