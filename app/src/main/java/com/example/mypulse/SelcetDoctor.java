package com.example.mypulse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mypulse.model.DoctorModel;

import java.util.ArrayList;


public class SelcetDoctor extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selcet_doctor);


        ArrayList<DoctorModel> doctorList = new ArrayList<>();


        DoctorModel model = new DoctorModel();

        model.setDoctorimage(R.drawable.neurologist);
        model.setName("Apollo Hospital");
        model.setAddarea("Shivrajani,Ahmedabad");
        model.setDrname("Dr.pankaj");
        model.setDegree("Physician");
        model.setDegreename("MBBS");

        doctorList.add(model);

        DoctorModel model1 = new DoctorModel();

        model1.setDoctorimage(R.drawable.pic1);
        model1.setName("kims Hospital");
        model1.setAddarea("satelite,Ahmedabad");
        model1.setDrname("Dr.veer");
        model1.setDegree("Physician");
        model1.setDegreename("MBBS");

        doctorList.add(model1);

        DoctorModel model2 = new DoctorModel();

        model2.setDoctorimage(R.drawable.pic2);
        model2.setName("Zydus Hospital");
        model2.setAddarea("Shivrajani,Ahmedabad");
        model2.setDrname("Dr.pankaj");
        model2.setDegree("Physician");
        model2.setDegreename("MBBS");

        doctorList.add(model2);

        DoctorModel model3 = new DoctorModel();

        model3.setDoctorimage(R.drawable.pic3);
        model3.setName("Apollo Hospital");
        model3.setAddarea("Shivrajani,Ahmedabad");
        model3.setDrname("Dr.pankaj");
        model3.setDegree("Physician");
        model3.setDegreename("MBBS");

        doctorList.add(model3);

        DoctorModel model4 = new DoctorModel();

        model4.setDoctorimage(R.drawable.pic4);
        model4.setName("Apollo Hospital");
        model4.setAddarea("Shivrajani,Ahmedabad");
        model4.setDrname("Dr.pankaj");
        model4.setDegree("Physician");
        model4.setDegreename("MBBS");

        doctorList.add(model4);

        DoctorModel model5 = new DoctorModel();

        model5.setDoctorimage(R.drawable.pic5);
        model5.setName("Kims Hospital");
        model5.setAddarea("Shivrajani,Ahmedabad");
        model5.setDrname("Dr.pankaj");
        model5.setDegree("Physician");
        model5.setDegreename("MBBS");

        doctorList.add(model5);

        DoctorModel model6 = new DoctorModel();

        model6.setDoctorimage(R.drawable.pic6);
        model6.setName("Apollo Hospital");
        model6.setAddarea("Shivrajani,Ahmedabad");
        model6.setDrname("Dr.pankaj");
        model6.setDegree("Physician");
        model6.setDegreename("MBBS");

        doctorList.add(model6);


        RecyclerView recyclerView = findViewById(R.id.doctorrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SelectDoctorAdapter adapter = new SelectDoctorAdapter(getApplicationContext(), doctorList);
        recyclerView.setAdapter(adapter);


    }


}
