package com.hit.api;

import androidx.annotation.Nullable;

import com.hit.model.DefaultResponse;
import com.hit.model.LoginResponse;

import com.hit.model.UserResponse;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("createUser")
     Call<DefaultResponse> createUser(
            @Nullable @Field("name")String name,
            @Nullable @Field("course")String course,
            @Nullable @Field("email")String email,
            @Nullable @Field("password")String password,
            @Nullable @Field("age")String age
    );


   @FormUrlEncoded
    @POST("userLogin")
    Call<LoginResponse> userLogin(
            @Nullable @Field("password")String password,
            @Nullable @Field("email")String email
    );
   @GET("getAll")
   Call<UserResponse> getUsers();
}
