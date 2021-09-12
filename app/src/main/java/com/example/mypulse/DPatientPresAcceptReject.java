package com.example.mypulse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DPatientPresAcceptReject extends AppCompatActivity {

    ImageView imageview;
    TextView name;
    EditText editText;
    Button btn1,btn2;
    String name1;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpatient_pres_accept_reject);

        imageview= findViewById(R.id.prescriptionimage);
        name= findViewById(R.id.prescriptiontext);
        editText= findViewById(R.id.edit);
        btn1= findViewById(R.id.accept);
        btn2= findViewById(R.id.reject);
        name1=getIntent().getStringExtra("name");
        image=getIntent().getIntExtra("image",0);


    }
}
