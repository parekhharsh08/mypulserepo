package com.example.mypulse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mypulse.model.PatientListModel;

import java.util.ArrayList;

public class DoctorPatientDetailRecy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_patient_detail_recy);

        ArrayList<PatientListModel> patientlist = new ArrayList<>();

        PatientListModel model = new PatientListModel();

        model.setImage(R.drawable.pic1);
        model.setName("Akshay Patel");
        patientlist.add(model);

        PatientListModel model1 = new PatientListModel();

        model1.setImage(R.drawable.pic2);
        model1.setName("Harsh Patel");
        patientlist.add(model1);

        PatientListModel model2 = new PatientListModel();

        model2.setImage(R.drawable.pic3);
        model2.setName("Ruchit Parejiya");
        patientlist.add(model2);

       PatientListModel model3 = new PatientListModel();
        model3.setImage(R.drawable.pic4);
        model3.setName("Divy Bhagat");
        patientlist.add(model3);

        PatientListModel model4 = new PatientListModel();
        model4.setImage(R.drawable.pic5);
        model4.setName("Arpit Shah");
        patientlist.add(model4);

        PatientListModel model5 = new PatientListModel();
        model5.setImage(R.drawable.pic6);
        model5.setName("Neha Patel");
        patientlist.add(model5);




        RecyclerView recyclerView = findViewById(R.id.recyclerviewpatientlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PatientListAdapter adapter = new PatientListAdapter(getApplicationContext(),patientlist);
        recyclerView.setAdapter(adapter);


    }
}
