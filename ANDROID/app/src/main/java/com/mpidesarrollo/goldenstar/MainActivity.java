package com.mpidesarrollo.goldenstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.128.0.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        login_Request();

        

    }
    private void login_Request(){


        Log.d("ESTOY EN LOGIN REQUEST","ESTOY EN LOGIN REQUEST");
        LoginRequest loginRequest = new LoginRequest("HALEJANDRO","ALEJANDR0123","password","19.3509","-99.1566");

        Call <LoginRequest> call = jsonPlaceHolderApi.createLoginReques(loginRequest);
        call.enqueue(new Callback<LoginRequest>() {
            @Override
            public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {


                Log.d("ESTOY EN LOGIN REQUEST","ESTOY EN LOGIN REQUEST "+response);

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Login> login = (List<Login>) response.body();

                for (Login loginResponse : login ){
                    String content = "";
                    content += "Access Token: " + loginResponse.getAccess_topken() + "\n";
                    content += "Token Type: " + loginResponse.getToken_type() + "\n";


                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<LoginRequest> call, Throwable t) {

            }
        });
    }





}
