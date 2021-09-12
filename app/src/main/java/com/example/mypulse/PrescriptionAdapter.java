package com.example.mypulse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypulse.model.PrescriptionViewModel;

import java.util.ArrayList;

public class PrescriptionAdapter extends RecyclerView.Adapter<PrescriptionAdapter.PrescriptionViewHolder> {

    Context context;
    ArrayList<PrescriptionViewModel> prescriptionlist;

    public PrescriptionAdapter(Context context, ArrayList<PrescriptionViewModel> prescriptionlist) {
        this.context = context;
        this.prescriptionlist = prescriptionlist;
    }

    @NonNull
    @Override
    public PrescriptionAdapter.PrescriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_prescription,parent,false);
        return new PrescriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrescriptionAdapter.PrescriptionViewHolder holder, int position) {

        PrescriptionViewModel prescriptionmodel = prescriptionlist.get(position);
        holder.textView.setText(prescriptionmodel.getRemark());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(prescriptionmodel.getPrescriptionimage()));

    }

    @Override
    public int getItemCount() {
        return prescriptionlist.size();
    }

    public class PrescriptionViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public PrescriptionViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.prescriptionimage);
            textView =itemView.findViewById(R.id.prescriptiontext);
        }
    }
}
