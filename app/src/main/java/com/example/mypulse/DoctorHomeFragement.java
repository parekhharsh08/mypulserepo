package com.example.mypulse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class DoctorHomeFragement extends Fragment {
    CardView patientlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.doctor_home_fragement,container,false);

        final CardView patientlist = (CardView) rootview.findViewById(R.id.patientdetails);

        patientlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent =  new Intent(getActivity(),DoctorPatientDetailRecy.class);
               startActivity(intent);
            }
        });
        return rootview;
    }
}
