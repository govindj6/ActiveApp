package com.example.activeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText etName,etMobile,etEmail,etPassword;
    Button btnRegistration,btnAlreadyRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        etName=findViewById(R.id.et_name);
        etMobile=findViewById(R.id.et_mobile);
        etEmail=findViewById(R.id.et_email);
        etPassword=findViewById(R.id.et_password);
        btnRegistration=findViewById(R.id.btn_registration);
        btnAlreadyRegistered=findViewById(R.id.btn_already_registered);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user=new User();
                user.name=etName.getText().toString();
                user.mobile=etMobile.getText().toString();
                user.email=etEmail.getText().toString();
                user.password=etPassword.getText().toString();
                user.save();
                etName.getText().clear();
                etMobile.getText().clear();
                etEmail.getText().clear();
                etPassword.getText().clear();
                Toast.makeText(Registration.this, "successfully Registered", Toast.LENGTH_SHORT).show();

            }
        });

        btnAlreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Registration.this,Login.class);
                startActivity(in);
            }
        });
    }
}
