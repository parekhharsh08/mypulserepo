package com.example.mypulse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationFragement extends Fragment {


    String[] name={"Dr.Shah Accept your Prescreption","Dr.Shah Rejected your Prescreption","Dr.Shah Rejected your Prescreption","Dr.Shah Rejected your Prescreption","Dr.Shah Rejected your Prescreption","Dr.Shah Rejected your Prescreption","Dr.Shah Rejected your Prescreption","Dr.Shah Rejected your Prescreption","Dr.Shah Rejected your Prescreption","Dr.Shah Rejected your Prescreption"};
    String[] time={"fri at 7:45pm","fri at 7:45pm","fri at 7:45pm","fri at 7:45pm","fri at 7:45pm","fri at 7:45pm","fri at 7:45pm","fri at 7:45pm","fri at 7:45pm","fri at 7:45pm"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View home= inflater.inflate(R.layout.notification_fragement,container,false);

        RecyclerView recyclerView=home.findViewById(R.id.notification_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        NotificationAdapter adapter=new NotificationAdapter(this.getActivity(),name,time);
        recyclerView.setAdapter(adapter);
        return home;

    }
}
