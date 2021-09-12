package com.example.mypulse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppointmentFragement extends Fragment {

    SearchView searchView;

    LinearLayout fever;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview= inflater.inflate(R.layout.appointment_fragement, container, false);


          searchView = rootview.findViewById(R.id.searchview);
          fever = rootview.findViewById(R.id.fever_a);
        fever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(getActivity(),SelcetDoctor.class);
                startActivity(intent);
            }
        });



     /* adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listdisease);
      listView.setAdapter(adapter);*/




        return rootview;
    }

}
