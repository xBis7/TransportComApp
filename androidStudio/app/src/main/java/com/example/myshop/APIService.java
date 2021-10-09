package com.example.myshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("/customers")
    Call<List<DataModal>> getCustomers();

    @GET("/customers/{serialNum}")
    Call<DataModal> getCustomer(@Path("SerialNum") String SerialNum);

    @GET("/customers/find")
    Call<DataModal> getCustomerUsingQuery(@Query("serialNum") String serialNum);

    @POST("/customers")
    Call<DataModal> newCustomer(@Body DataModal dataModal);
}
