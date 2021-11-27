package com.example.myshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewEntry extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.myshop.MESSAGE";
    public static final String EXTRA_SERIAL = "com.example.myshop.SERIAL";
    public static final String EXTRA_ADDRESS = "com.example.myshop.ADDRESS";
    public static final String EXTRA_CITY = "com.example.myshop.CITY";
    public static final String EXTRA_PHONE = "com.example.myshop.PHONE";
    public static final String EXTRA_DATE = "com.example.myshop.DATE";
    public static final String EXTRA_PRODUCT1 = "com.example.myshop.PRODUCT1";
    public static final String EXTRA_PRODUCT2 = "com.example.myshop.PRODUCT2";
    public static final String EXTRA_PRODUCT3 = "com.example.myshop.PRODUCT3";
    public static final String EXTRA_PRODUCT4 = "com.example.myshop.PRODUCT4";
    public static final String EXTRA_PRODUCT5 = "com.example.myshop.PRODUCT5";

    private String serialNum;

    APIService apiService;

    private List<DataModal> dataModalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_entry);

        //get all customer json objects and adding them to dataModalList
        //find list size to find total customers and give a serial number
        //to the next customer
        dataModalList = new ArrayList<>();

        apiService = ApiClient.getClient().create(APIService.class);

        Call<List<DataModal>> call = apiService.getCustomers();

        call.enqueue(new Callback<List<DataModal>>() {
            @Override
            public void onResponse(Call<List<DataModal>> call, Response<List<DataModal>> response) {
                if (response.isSuccessful()) {
                    dataModalList.addAll(response.body());
                    Log.e("AddNewEntry", "RESPONSE:" + dataModalList.size());
                }
            }

            @Override
            public void onFailure(Call<List<DataModal>> call, Throwable t) {
                Toast.makeText(AddNewEntry.this, "Error getting data and adding serial number to new customer", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void add(View view){
        Intent intent = new Intent(this, AddConfirmation.class);

        Bundle extras = new Bundle();

        serialNum = String.valueOf(dataModalList.size() + 1);
        extras.putString(EXTRA_SERIAL, serialNum);

        EditText editText1 = (EditText) findViewById(R.id.editTextTextPersonName);
        String name = editText1.getText().toString();
        extras.putString(EXTRA_NAME, name);

        EditText editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        String address = editText2.getText().toString();
        extras.putString(EXTRA_ADDRESS, address);

        EditText editText3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        String city = editText3.getText().toString();
        extras.putString(EXTRA_CITY, city);

        EditText editText4 = (EditText) findViewById(R.id.editTextNumber);
        String phone = editText4.getText().toString();
        extras.putString(EXTRA_PHONE, phone);

        EditText editText5 = (EditText) findViewById(R.id.editTextDate);
        String date = editText5.getText().toString();
        extras.putString(EXTRA_DATE, date);

        //products
        EditText editText6 = (EditText) findViewById(R.id.editTextNumberSigned3);
        String quantity1 = editText6.getText().toString();

        if(quantity1.isEmpty()){
            quantity1 = "-";
        }

        EditText editText7 = (EditText) findViewById(R.id.editTextNumberDecimal2);
        String price1 = editText7.getText().toString();

        if(price1.isEmpty()){
            price1 = "-";
        }

        EditText editText8 = (EditText) findViewById(R.id.editTextNumberSigned4);
        String quantity2 = editText8.getText().toString();

        if(quantity2.isEmpty()){
            quantity2 = "-";
        }

        EditText editText9 = (EditText) findViewById(R.id.editTextNumberDecimal3);
        String price2 = editText9.getText().toString();

        if(price2.isEmpty()){
            price2 = "-";
        }

        EditText editText10 = (EditText) findViewById(R.id.editTextNumberSigned5);
        String quantity3 = editText10.getText().toString();

        if(quantity3.isEmpty()){
            quantity3 = "-";
        }

        EditText editText11 = (EditText) findViewById(R.id.editTextNumberDecimal4);
        String price3 = editText11.getText().toString();

        if(price3.isEmpty()){
            price3 = "-";
        }

        EditText editText12 = (EditText) findViewById(R.id.editTextNumberSigned);
        String quantity4 = editText12.getText().toString();

        if(quantity4.isEmpty()){
            quantity4 = "-";
        }

        EditText editText13 = (EditText) findViewById(R.id.editTextNumberDecimal);
        String price4 = editText13.getText().toString();

        if(price4.isEmpty()){
            price4 = "-";
        }

        EditText editText14 = (EditText) findViewById(R.id.editTextNumberSigned2);
        String quantity5 = editText14.getText().toString();

        if(quantity5.isEmpty()){
            quantity5 = "-";
        }

        EditText editText15 = (EditText) findViewById(R.id.editTextNumberDecimal5);
        String price5 = editText15.getText().toString();

        if(price5.isEmpty()){
            price5 = "-";
        }

        String product1 = "Quantity:" + quantity1 + "  Price:" + price1;
        extras.putString(EXTRA_PRODUCT1, product1);

        String product2 = "Quantity:" + quantity2 + "  Price:" + price2;
        extras.putString(EXTRA_PRODUCT2, product2);

        String product3 = "Quantity:" + quantity3 + "  Price:" + price3;
        extras.putString(EXTRA_PRODUCT3, product3);

        String product4 = "Quantity:" + quantity4 + "  Price:" + price4;
        extras.putString(EXTRA_PRODUCT4, product4);

        String product5 = "Quantity:" + quantity5 + "  Price:" + price5;
        extras.putString(EXTRA_PRODUCT5, product5);

        AlertDialog.Builder emptyFieldDialog = new AlertDialog.Builder(this);
        emptyFieldDialog.setMessage("One or more field are empty, continue anyway?");
        emptyFieldDialog.setPositiveButton(
                "Continue",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                });

        emptyFieldDialog.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
            }
        });

        if(!name.isEmpty() && !address.isEmpty() && !city.isEmpty() && !phone.isEmpty()){
            //open dialog
            if(date.equals("")){
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date currentDate = new Date();
                date = formatter.format(currentDate);
            }

            extras.putString(EXTRA_NAME, name);
            extras.putString(EXTRA_ADDRESS, address);
            extras.putString(EXTRA_CITY, city);
            extras.putString(EXTRA_PHONE, phone);
            extras.putString(EXTRA_DATE, date);

            if(quantity1.equals("-") && quantity2.equals("-") && quantity3.equals("-") && quantity4.equals("-") && quantity5.equals("-")){
                AlertDialog alertDialog = emptyFieldDialog.create();
                alertDialog.show();
            }
            else{
                intent.putExtras(extras);
                startActivity(intent);
            }

        }
        else {
            Toast.makeText(AddNewEntry.this, "At least one of the customer info fields is empty", Toast.LENGTH_SHORT).show();
        }

    }
}