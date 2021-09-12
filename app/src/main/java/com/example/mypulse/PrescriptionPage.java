package com.example.mypulse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mypulse.model.PrescriptionViewModel;

import java.util.ArrayList;

public class PrescriptionPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_page);

        ArrayList<PrescriptionViewModel> prescriptionlist = new ArrayList<>();


        PrescriptionViewModel model = new PrescriptionViewModel();

        model.setRemark("remark");
        model.setPrescriptionimage(R.drawable.hospitalfile);
        prescriptionlist.add(model);

        PrescriptionViewModel model1 = new PrescriptionViewModel();
        model1.setRemark("remark");
        model1.setPrescriptionimage(R.drawable.hospitalfile);
        prescriptionlist.add(model1);

        PrescriptionViewModel model2 = new PrescriptionViewModel();
        model2.setRemark("remark");
        model2.setPrescriptionimage(R.drawable.hospitalfile);
        prescriptionlist.add(model2);

        PrescriptionViewModel model3 = new PrescriptionViewModel();
        model3.setRemark("remark");
        model3.setPrescriptionimage(R.drawable.hospitalfile);
        prescriptionlist.add(model3);




        RecyclerView recyclerView = findViewById(R.id.recyclerviewprescription);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PrescriptionAdapter adapter = new PrescriptionAdapter(getApplicationContext(), prescriptionlist);
        recyclerView.setAdapter(adapter);
    }
}
