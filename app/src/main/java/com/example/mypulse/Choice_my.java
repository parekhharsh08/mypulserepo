package com.example.mypulse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choice_my extends AppCompatActivity {
Button doctorb, patientb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice__my);

        doctorb = findViewById(R.id.doctorbutton);
        patientb = findViewById(R.id.patientbutton);

        doctorb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Choice_my.this,DoctorDocumentPage.class);
                startActivity(intent);
            }
        });

        patientb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Choice_my.this,DocumentPatient.class);
                startActivity(intent);
            }
        });
    }



}
