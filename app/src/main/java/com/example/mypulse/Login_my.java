package com.example.mypulse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import static android.text.TextUtils.isEmpty;


public class Login_my extends AppCompatActivity {

Button login;
TextView registerbutton,forgetpassword;
EditText phone,login_password;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_my);

        login = findViewById(R.id.login);
        phone = findViewById(R.id.phone);
        forgetpassword = findViewById(R.id.forgot);

        login_password = findViewById(R.id.password_login);
        registerbutton = findViewById(R.id.signup);

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login_my.this,ForgotPassword.class);
                startActivity(intent);
            }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        login_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    signinValidate();
            }
        });

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login_my.this,Registration_My.class);
                startActivity(intent);
            }
        });

    }

    public void checkInputs(){
        if(!TextUtils.isEmpty(phone.getText())){
            if (!TextUtils.isEmpty(login_password.getText())){
                login.setEnabled(true);
                login.setTextColor(Color.rgb(252,253,253));
            }else {
                login.setEnabled(false);
                login.setTextColor(Color.argb(59,46,71,89));
            }
        }else {
            login.setEnabled(false);
            login.setTextColor(Color.argb(59,46,71,89));
        }
}

    private void signinValidate() {
        if (phone.length()>=10 || phone.length()<=10){
            if(login_password.length()>=7){

                login.setEnabled(false);
                login.setTextColor(Color.argb(59,46,71,89));

                Intent intent = new Intent(Login_my.this, Choice_my.class);
                startActivity(intent);

            }else {
                login_password.setError("atleast 7 character ");

            }
        }else{
            phone.setError("Please write your registered Mobile No");
        }
    }


}