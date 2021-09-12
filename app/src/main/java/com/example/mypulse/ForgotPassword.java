package com.example.mypulse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {

    EditText mobilenumber;
    Button forgotbtn;
    TextView goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mobilenumber = findViewById(R.id.forget_email);
        forgotbtn = findViewById(R.id.forgot_btn);
        goback = findViewById(R.id.fotgot_goback);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPassword.this,Login_my.class);
                startActivity(intent);
            }
        });
    }
}