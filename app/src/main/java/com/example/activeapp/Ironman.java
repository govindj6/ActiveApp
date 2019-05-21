package com.example.activeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Ironman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ironman);
        Toast.makeText(this, "Ironman Page", Toast.LENGTH_SHORT).show();
    }
}
