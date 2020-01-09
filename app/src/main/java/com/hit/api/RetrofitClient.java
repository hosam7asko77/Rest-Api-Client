package com.hit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    private static final String BASED_URL="http://192.168.0.6/Slim/Rest-Api/Rest-Api/public/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;
    public RetrofitClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASED_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }

}
