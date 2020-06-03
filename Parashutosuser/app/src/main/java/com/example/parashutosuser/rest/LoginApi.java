package com.example.parashutosuser.rest;

import com.example.parashutosuser.rest.DTOs.InfoHTTPDto;
import com.example.parashutosuser.rest.DTOs.LoginPair;
import com.example.parashutosuser.rest.DTOs.UserHTTPDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApi {
    @POST("/Parashutos.server/registration") //имя в томкате
    public Call<LoginPair> registeration(@Body UserHTTPDto Data);

    @GET("/Parashutos.server/login") //имя в томкате
    public Call<LoginPair> login(@Query("login") String userEmail, @Query("password") String userPassword);

    @POST("/Parashutos.server/save") //имя в томкате
    public Call<String> save(@Body InfoHTTPDto Data);
}

