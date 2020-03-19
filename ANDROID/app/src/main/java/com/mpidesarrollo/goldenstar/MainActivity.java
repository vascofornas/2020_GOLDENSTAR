package com.mpidesarrollo.goldenstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.util.List;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.128.0.2:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        textViewResult = findViewById(R.id.text_view_result);



        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        login_Request();

        

    }
    private void login_Request() {


        Log.d("ESTOY EN LOGIN REQUEST", "ESTOY EN LOGIN REQUEST");

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        Call<ResponseBody> call = jsonPlaceHolderApi.createLoginRequest("HALEJANDRO", "ALEJANDR0123", "password", "19.4953148", "-99.1131595");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("ESTOY EN LOGIN REQUEST", "ESTOY EN LOGIN REQUEST success "+response);
                String object = null;
                try {
                    object = response.body().string();
                    try {
                        textViewResult.setText(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("response string.....", object);

                Log.d("response string.....", object);



            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("ESTOY EN LOGIN REQUEST", "ESTOY EN LOGIN REQUEST error");
            }
        });


    }




}
