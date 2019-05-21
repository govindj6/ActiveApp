package com.example.activeapp;

import android.content.Intent;
import android.database.Cursor;
import android.icu.lang.UScript;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;

import java.util.List;

public class Welcome extends AppCompatActivity {
    TextView tvTitle;
    EditText mobile,email,pass,height,moto,power;
    RadioGroup radioGroup;
    RadioButton rbtnMale,rbtnFemale;
    Button btnSelectImage,btnSave;
    String Useremail="";
    Uri selectedImage=null;
    public static final int REQUESTCODE=23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();
        tvTitle=findViewById(R.id.tv_title);
        mobile=findViewById(R.id.et_mobile_welcome);
        email=findViewById(R.id.et_Email_welcome);
        pass=findViewById(R.id.et_Password_welcome);
        height=findViewById(R.id.et_height_welcome);
        moto=findViewById(R.id.et_Moto_welcome);
        power=findViewById(R.id.et_power_welcome);
        radioGroup=findViewById(R.id.radioGroup_welcome);
        rbtnMale=findViewById(R.id.rbtn_male);
        rbtnFemale=findViewById(R.id.rbtn_female);
        btnSelectImage=findViewById(R.id.btn_select_picture);
        btnSave=findViewById(R.id.btn_save);

        Intent intent=getIntent();
        Useremail=intent.getStringExtra("email");
        List<User> getAll = new Select().from(User.class).where("email=?",Useremail).execute();
        tvTitle.setText("Welcome "+getAll.get(0).name);

        new Delete().from(User.Ironman.class).where("email = ?", "ironman@gmail.com").execute();


        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUESTCODE);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User.Ironman ironman = new User.Ironman();
                ironman.mobile = mobile.getText().toString();
                ironman.email = email.getText().toString();
                ironman.password = pass.getText().toString();
                ironman.height = height.getText().toString();
                ironman.moto = moto.getText().toString();
                ironman.power = power.getText().toString();
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId){
                            case R.id.rbtn_male:
                                ironman.gender="Male";
                                break;
                            case R.id.rbtn_female:
                                ironman.gender="Male";
                                break;
                        }
                    }
                });
                ironman.image=selectedImage.toString();
                ironman.save();
                Toast.makeText(Welcome.this, "profile updated successfully", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Welcome.this, Ironman.class);
                startActivity(i);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE){
            selectedImage = data.getData();
        }
    }
}
