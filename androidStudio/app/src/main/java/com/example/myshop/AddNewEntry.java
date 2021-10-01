package com.example.myshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewEntry extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.myshop.MESSAGE";
    public static final String EXTRA_ADDRESS = "com.example.myshop.ADDRESS";
    public static final String EXTRA_CITY = "com.example.myshop.CITY";
    public static final String EXTRA_PHONE = "com.example.myshop.PHONE";
    public static final String EXTRA_DATE = "com.example.myshop.DATE";
    public static final String EXTRA_PRODUCT1 = "com.example.myshop.PRODUCT1";
    public static final String EXTRA_PRODUCT2 = "com.example.myshop.PRODUCT2";
    public static final String EXTRA_PRODUCT3 = "com.example.myshop.PRODUCT3";
    public static final String EXTRA_PRODUCT4 = "com.example.myshop.PRODUCT4";
    public static final String EXTRA_PRODUCT5 = "com.example.myshop.PRODUCT5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_entry);
    }

    public void add(View view){
        Intent intent = new Intent(this, AddConfirmation.class);

        Bundle extras = new Bundle();

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

        if(quantity1.equals("")){
            quantity1 = "-";
        }

        EditText editText7 = (EditText) findViewById(R.id.editTextNumberDecimal2);
        String price1 = editText7.getText().toString();

        if(price1.equals("")){
            price1 = "-";
        }

        EditText editText8 = (EditText) findViewById(R.id.editTextNumberSigned4);
        String quantity2 = editText8.getText().toString();

        if(quantity2.equals("")){
            quantity2 = "-";
        }

        EditText editText9 = (EditText) findViewById(R.id.editTextNumberDecimal3);
        String price2 = editText9.getText().toString();

        if(price2.equals("")){
            price2 = "-";
        }

        EditText editText10 = (EditText) findViewById(R.id.editTextNumberSigned5);
        String quantity3 = editText10.getText().toString();

        if(quantity3.equals("")){
            quantity3 = "-";
        }

        EditText editText11 = (EditText) findViewById(R.id.editTextNumberDecimal4);
        String price3 = editText11.getText().toString();

        if(price3.equals("")){
            price3 = "-";
        }

        EditText editText12 = (EditText) findViewById(R.id.editTextNumberSigned);
        String quantity4 = editText12.getText().toString();

        if(quantity4.equals("")){
            quantity4 = "-";
        }

        EditText editText13 = (EditText) findViewById(R.id.editTextNumberDecimal);
        String price4 = editText13.getText().toString();

        if(price4.equals("")){
            price4 = "-";
        }

        EditText editText14 = (EditText) findViewById(R.id.editTextNumberSigned2);
        String quantity5 = editText14.getText().toString();

        if(quantity5.equals("")){
            quantity5 = "-";
        }

        EditText editText15 = (EditText) findViewById(R.id.editTextNumberDecimal5);
        String price5 = editText15.getText().toString();

        if(price5.equals("")){
            price5 = "-";
        }

        String product1 = "Product1     Quantity:" + quantity1 + "  Price:" + price1;
        extras.putString(EXTRA_PRODUCT1, product1);

        String product2 = "Product2     Quantity:" + quantity2 + "  Price:" + price2;
        extras.putString(EXTRA_PRODUCT2, product2);

        String product3 = "Product3     Quantity:" + quantity3 + "  Price:" + price3;
        extras.putString(EXTRA_PRODUCT3, product3);

        String product4 = "Product4     Quantity:" + quantity4 + "  Price:" + price4;
        extras.putString(EXTRA_PRODUCT4, product4);

        String product5 = "Product5     Quantity:" + quantity5 + "  Price:" + price5;
        extras.putString(EXTRA_PRODUCT5, product5);

        AlertDialog.Builder emptyFieldDialog = new AlertDialog.Builder(this);
        emptyFieldDialog.setMessage("One or more field are empty, continue anyway?");
        emptyFieldDialog.setPositiveButton(
                "Continue",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(AddNewEntry.this,"Continuing to info confirmation",Toast.LENGTH_LONG).show();
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

        if(name.equals("") || address.equals("") || city.equals("") || phone.equals("") || date.equals("")){
            //open dialog
            if(name.equals("")){
                name = "--";
            }
            if(address.equals("")){
                address = "--";
            }
            if(city.equals("")){
                city = "--";
            }
            if(phone.equals("")){
                phone = "--";
            }
            if(date.equals("")){
                date = "--";
            }

            extras.putString(EXTRA_NAME, name);
            extras.putString(EXTRA_ADDRESS, address);
            extras.putString(EXTRA_CITY, city);
            extras.putString(EXTRA_PHONE, phone);
            extras.putString(EXTRA_DATE, date);

            AlertDialog alertDialog = emptyFieldDialog.create();
            alertDialog.show();
        }
        else{
            intent.putExtras(extras);
            startActivity(intent);
        }

    }
}