package com.example.mypulse;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission_group.CAMERA;


public class Registration_My extends AppCompatActivity {
    EditText FirstN, LastN, email, Mno, password;
    RadioGroup radiogroup;
    Button Submit;
    String Temp;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__my);


        FirstN = findViewById(R.id.FirstN);
        LastN = findViewById(R.id.LastN);
        email = findViewById(R.id.email);
        Mno = findViewById(R.id.Mno);

        password = findViewById(R.id.password);
        Submit = findViewById(R.id.register1);
        radiogroup = findViewById(R.id.radiogroup);


        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radiogroup, int i) {

                if (radiogroup.getCheckedRadioButtonId() == R.id.male) {
                    Temp = "male";

                } else {
                    Temp = "Female";

                }
            }
        });

        FirstN.addTextChangedListener(new TextWatcher() {
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
        LastN.addTextChangedListener(new TextWatcher() {
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
        email.addTextChangedListener(new TextWatcher() {
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
        Mno.addTextChangedListener(new TextWatcher() {
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
        password.addTextChangedListener(new TextWatcher() {
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



        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    checkvalidatiton();
                /*callRegister(FirstN.getText().toString(), LastN.getText().toString(), email.getText().toString(), password.getText().toString(), Mno.getText().toString());
                */
            }
        });

    }



    private void checkInputs() {

        if(!TextUtils.isEmpty(FirstN.getText())){
            if(!TextUtils.isEmpty(LastN.getText())){
                if(!TextUtils.isEmpty(email.getText())){
                    if(!TextUtils.isEmpty(Mno.getText()) && Mno.length()>=10 || Mno.length()<=10){
                        if(!TextUtils.isEmpty(password.getText())){
                            Submit.setEnabled(true);
                            Submit.setTextColor(Color.rgb(252,253,253));
                        }else {
                            Submit.setEnabled(false);
                            Submit.setTextColor(Color.argb(59,46,71,89));
                        }
                    }else {
                        Submit.setEnabled(false);
                        Submit.setTextColor(Color.argb(59,46,71,89));
                    }
                }else {
                    Submit.setEnabled(false);
                    Submit.setTextColor(Color.argb(59,46,71,89));
                }
            }else {
                Submit.setEnabled(false);
                Submit.setTextColor(Color.argb(59,46,71,89));
            }
        }else {
            Submit.setEnabled(false);
            Submit.setTextColor(Color.argb(59,46,71,89));
        }
    }

    private void checkvalidatiton() {
        if (email.getText().toString().matches(emailPattern)){
            if(password.length()>=7){

                Submit.setEnabled(false);
                Submit.setTextColor(Color.argb(59,46,71,89));

                Intent intent = new Intent(Registration_My.this, Choice_my.class);
                startActivity(intent);

            }else {
                        password.setError("atleast 7 character ");
            }
        }else{
                        email.setError("Invalid Email");
        }
    }
    /*private void callRegister(String fName, String lName, String email, String mobile, String password) {
        RequestBody fisrtname = RequestBody.create(MediaType.parse("text/plain"), fName);
        RequestBody lastname = RequestBody.create(MediaType.parse("text/plain"), lName);
        RequestBody Email = RequestBody.create(MediaType.parse("text/plain"), email);
        RequestBody PhoneNo = RequestBody.create(MediaType.parse("text/plain"), mobile);
        RequestBody Password = RequestBody.create(MediaType.parse("text/plain"), password);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> call = apiInterface.registerPatient(fisrtname, lastname, Email, Password, PhoneNo);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    Log.e("Registration", "onResponse  " + new Gson().toJson(response.body().string()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.e("Registration", "onFailure   " + t.getMessage());
            }
        });
    }
*/

 }