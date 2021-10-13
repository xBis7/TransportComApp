package com.example.myshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import java.util.List;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_overflow_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.item_clear){

            Call<DataModal> call = apiService.deleteCustomers();
            call.enqueue(new Callback<DataModal>() {
                @Override
                public void onResponse(Call<DataModal> call, Response<DataModal> response) {

                    if(response.isSuccessful()){
                        Toast.makeText(SearchOldEntry.this, "Customer book has been cleared", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<DataModal> call, Throwable t) {
                    Toast.makeText(SearchOldEntry.this, "Error clearing customer book", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return super.onOptionsItemSelected(item);
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

                    //alert
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SearchOldEntry.this);
                    dialogBuilder.setTitle("Customer info");
                    dialogBuilder.setMessage(response.body().toString());

                    dialogBuilder.setPositiveButton("SHARE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //add share code
                        }
                    });

                    dialogBuilder.setNegativeButton("BACK", null);

                    AlertDialog dialog = dialogBuilder.create();
                    dialog.show();
                }
                else{
                    Toast.makeText(SearchOldEntry.this, "Customer with serial number " + serialNum + " doesn't exist ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                Toast.makeText(SearchOldEntry.this, "Error fetching data for customer with serial number " + serialNum, Toast.LENGTH_SHORT).show();
            }
        });

    }

}