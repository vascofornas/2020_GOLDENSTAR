package com.mpidesarrollo.goldenstar;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @FormUrlEncoded
    @POST("token")
    Call <ResponseBody> createLoginRequest(@Field("username") String username,
                                          @Field("password") String password,
                                          @Field("grant_type") String grant_type,
                                          @Field("latitude") String latitude,
                                          @Field("longitude") String longitude

                                          );
}