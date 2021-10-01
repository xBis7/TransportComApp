package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void search(View view){
        Intent intent = new Intent(this, SearchOldEntry.class);
        startActivity(intent);
    }

    public void newEntry(View view){
        Intent intent = new Intent(this, AddNewEntry.class);
        startActivity(intent);
    }
}