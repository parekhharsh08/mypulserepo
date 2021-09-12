package com.example.mypulse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypulse.model.PatientListModel;

import java.util.ArrayList;

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.PatientListViewHolder> {

    Context context;
    ArrayList<PatientListModel> patientlist;

    public PatientListAdapter(Context context, ArrayList<PatientListModel> patientlist) {
        this.context = context;
        this.patientlist = patientlist;
    }

    @NonNull
    @Override
    public PatientListAdapter.PatientListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.list_patientdetail,parent,false);
        return new PatientListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientListAdapter.PatientListViewHolder holder, int position) {

        final PatientListModel patientListModel = patientlist.get(position);

        holder.imageView.setImageDrawable(context.getResources().getDrawable(patientListModel.getImage()));
        holder.name.setText(patientListModel.getName());


    }

    @Override
    public int getItemCount()
    {
        return patientlist.size();
    }

    public class PatientListViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView imageView;
        TextView name;
        CardView cardView;
        public PatientListViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.patientimage);
            name=itemView.findViewById(R.id.patient_name);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
