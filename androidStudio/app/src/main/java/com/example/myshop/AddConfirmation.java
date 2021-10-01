package com.example.myshop;

import static android.telephony.PhoneNumberUtils.formatNumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.telephony.SmsManager;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
    private ProgressBar loadingPB;
    EditText editTextPhone;
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

    private static final String BASE_URL = "http://10.0.2.2:3000";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_confirmation);

        sendSMS = (Button) findViewById(R.id.button4);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone2);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        name = extras.getString(AddNewEntry.EXTRA_NAME);
        // Capture the layout's TextView and set the string as its text
        TextView textView1 = findViewById(R.id.textView27);
        textView1.setText("Name: " + name);

        address = extras.getString(AddNewEntry.EXTRA_ADDRESS);
        // Capture the layout's TextView and set the string as its text
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

        message1 = name + ", " + address + ", " + city + ", " + phone + ", " + date;

        message2 = "Product1 " + product1 + ", Product2 " + product2 + ", Product3 " + product3;

        message3 = "Product4 " + product4 + ", Product5 " + product5;

        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(editTextPhone.getText().toString(), null, message1, null, null);
                    smsManager.sendTextMessage(editTextPhone.getText().toString(), null, message2, null, null);
                    smsManager.sendTextMessage(editTextPhone.getText().toString(), null, message3, null, null);
                    Toast.makeText(AddConfirmation.this, "SMS sent successfully", Toast.LENGTH_LONG).show();
                }
                catch(Exception e){
                    Toast.makeText(AddConfirmation.this, "SMS not sent, try again", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void finish(View view){
        // below line is for displaying our progress bar.
        loadingPB.setVisibility(View.VISIBLE);

        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        APIService apiService = retrofit.create(APIService.class);

        // passing data from our text fields to our modal class.
        DataModal modal = new DataModal(name, address, city, phone, date, product1, product2, product3, product4, product5);

        // calling a method to create a post and passing our modal class.
        Call<DataModal> call = apiService.newCustomer(modal);

        // on below line we are executing our method.
        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                // this method is called when we get response from our api.
                Toast.makeText(AddConfirmation.this, "Data saved successfully", Toast.LENGTH_SHORT).show();

                // below line is for hiding our progress bar.
                loadingPB.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                Toast.makeText(AddConfirmation.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        Intent finishIntent = new Intent(this, MainActivity.class);
        startActivity(finishIntent);
    }

    public void cancel(View view){
        Intent cancelIntent = new Intent(this, MainActivity.class);
        startActivity(cancelIntent);
    }


}

