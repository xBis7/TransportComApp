package com.example.myshop;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("customers")
    Call<DataModal> newCustomer(@Body DataModal dataModal);
}
