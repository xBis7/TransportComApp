package com.example.myshop;

import static android.telephony.PhoneNumberUtils.formatNumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.provider.ContactsContract;
import android.telephony.SmsManager;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddConfirmation extends AppCompatActivity {

    private Button sendSMS;
    private String message1;
    private String message2;
    private String message3;
    private String message4;
    private ProgressBar loadingPB;
    EditText editTextPhone;
    String serialNum;
    String name;
    String address;
    String city;
    String phone;
    String date;
    String product1;
    String product2;
    String product3;
    String product4;
    String product5;

    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_confirmation);

        apiService = ApiClient.getClient().create(APIService.class);

        sendSMS = (Button) findViewById(R.id.button4);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone2);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        name = extras.getString(AddNewEntry.EXTRA_NAME);
        TextView textView1 = findViewById(R.id.textView27);
        textView1.setText("Name: " + name);

        serialNum = extras.getString(AddNewEntry.EXTRA_SERIAL);
        TextView textView = findViewById(R.id.textView32);
        textView.setText("Serial Number: " + serialNum);

        address = extras.getString(AddNewEntry.EXTRA_ADDRESS);
        TextView textView2 = findViewById(R.id.textView28);
        textView2.setText("Address: " + address);

        city = extras.getString(AddNewEntry.EXTRA_CITY);
        TextView textView3 = findViewById(R.id.textView21);
        textView3.setText("City: " + city);

        phone = extras.getString(AddNewEntry.EXTRA_PHONE);
        TextView textView4 = findViewById(R.id.textView22);
        textView4.setText("Phone: " + phone);

        date = extras.getString(AddNewEntry.EXTRA_DATE);
        TextView textView5 = findViewById(R.id.textView23);
        textView5.setText("Date: " + date);

        product1 = extras.getString(AddNewEntry.EXTRA_PRODUCT1);
        TextView textView6 = findViewById(R.id.textView24);
        textView6.setText("Product1 " + product1);

        product2 = extras.getString(AddNewEntry.EXTRA_PRODUCT2);
        TextView textView7 = findViewById(R.id.textView25);
        textView7.setText("Product2 " + product2);

        product3 = extras.getString(AddNewEntry.EXTRA_PRODUCT3);
        TextView textView8 = findViewById(R.id.textView26);
        textView8.setText("Product3 " + product3);

        product4 = extras.getString(AddNewEntry.EXTRA_PRODUCT4);
        TextView textView9 = findViewById(R.id.textView29);
        textView9.setText("Product4 " + product4);

        product5 = extras.getString(AddNewEntry.EXTRA_PRODUCT5);
        TextView textView10 = findViewById(R.id.textView30);
        textView10.setText("Product5 " + product5);

        loadingPB = findViewById(R.id.progressBar);

        message1 = name + ", " + serialNum + ", " + address;

        message2 = city + ", " + phone + ", " + date;

        message3 = "Product1 " + product1 + ", Product2 " + product2 + ", Product3 " + product3;

        message4 = "Product4 " + product4 + ", Product5 " + product5;

        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(editTextPhone.getText().toString(), null, message1, null, null);
                    smsManager.sendTextMessage(editTextPhone.getText().toString(), null, message2, null, null);
                    smsManager.sendTextMessage(editTextPhone.getText().toString(), null, message3, null, null);
                    smsManager.sendTextMessage(editTextPhone.getText().toString(), null, message4, null, null);
                    Toast.makeText(AddConfirmation.this, "SMS sent successfully", Toast.LENGTH_LONG).show();
                }
                catch(Exception e){
                    Toast.makeText(AddConfirmation.this, "SMS not sent, try again", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void finish(View view){

        Intent finishIntent = new Intent(this, MainActivity.class);

        //displaying the progress bar.
        loadingPB.setVisibility(View.VISIBLE);

        //passing data from text fields to the modal class.
        DataModal modal = new DataModal(name, serialNum, address, city, phone, date, product1, product2, product3, product4, product5);

        //calling a method to create a post and passing the modal class.
        Call<DataModal> call = apiService.newCustomer(modal);

        //execute the method
        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {

                Toast.makeText(AddConfirmation.this, "Data saved successfully", Toast.LENGTH_SHORT).show();

                //hide the progress bar
                loadingPB.setVisibility(View.GONE);

                startActivity(finishIntent);
            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {

                //on error response
                Toast.makeText(AddConfirmation.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void cancel(View view){
        Intent cancelIntent = new Intent(this, MainActivity.class);
        startActivity(cancelIntent);
    }


}

