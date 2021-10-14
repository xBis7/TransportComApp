package com.example.myshop;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://customers-restapi.herokuapp.com/";  //"http://10.0.2.2:3000" for local testing, not deployed rest api
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
