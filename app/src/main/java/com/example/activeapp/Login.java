package com.example.activeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.query.From;
import com.activeandroid.query.Select;

public class Login extends AppCompatActivity {
    EditText etEmailLogin,etPasswordLogin;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        etEmailLogin=findViewById(R.id.et_email_login);
        etPasswordLogin=findViewById(R.id.et_password_login);
        btnLogin=findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=etEmailLogin.getText().toString();
                String password=etPasswordLogin.getText().toString();

                From fromEmail=new Select().from(User.class).where("email=?",email);
                From fromPassword=new Select().from(User.class).where("Password=?",password);

                if (fromEmail.exists() && fromPassword.exists()){
                    Intent intent=new Intent(Login.this,Welcome.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }else {
                    Toast.makeText(Login.this, "You are not registered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
