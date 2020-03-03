package com.mpidesarrollo.goldenstar;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("token")
    Call <LoginRequest>createLoginReques(@Body LoginRequest loginRequest);
}