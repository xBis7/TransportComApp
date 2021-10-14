package com.example.myshop;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://10.0.2.2:3000";  //https://<your-rest-apis-name>.herokuapp.com/   if your rest api is deployed to heroku
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
