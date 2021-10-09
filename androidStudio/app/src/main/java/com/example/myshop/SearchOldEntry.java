package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchOldEntry extends AppCompatActivity {

    private String serialNum;

    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_old_entry);

        apiService = ApiClient.getClient().create(APIService.class);

    }

    public void find(View view){

        EditText findEditText = (EditText) findViewById(R.id.editTextTextPersonName4);
        serialNum = findEditText.getText().toString();

        Call<DataModal> call = apiService.getCustomerUsingQuery(serialNum);


        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {

                if(response.isSuccessful()){
                    response.body();
                    Log.e("SearchOldEntry", "RESPONSE:" + response.body().toString());

                }

            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                Toast.makeText(SearchOldEntry.this, "Error finding customer with serial number " + serialNum, Toast.LENGTH_SHORT).show();
            }
        });

    }

}