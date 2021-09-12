package com.example.mypulse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mypulse.model.DoctorModel;
import java.util.ArrayList;


public class SelectDoctorAdapter extends RecyclerView.Adapter<SelectDoctorAdapter.SelectDoctorViewHolder> {

    Context context;
    ArrayList<DoctorModel> doctorList;


    public SelectDoctorAdapter(Context context, ArrayList<DoctorModel> doctorModels) {
        this.context = context;
        this.doctorList = doctorModels;
    }

    @NonNull
    @Override
    public SelectDoctorAdapter.SelectDoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_doctordetail,parent,false);
        return new SelectDoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectDoctorAdapter.SelectDoctorViewHolder holder, int position) {

        DoctorModel doctorModel = doctorList.get(position);

        holder.hospitalname.setText(doctorModel.getName());
        holder.hospitalarea.setText(doctorModel.getAddarea());
        holder.drname.setText(doctorModel.getDrname());
        holder.degree.setText(doctorModel.getDegree());
         holder.exp.setText(doctorModel.getExp());
        holder.doctor_Image.setImageDrawable(context.getResources().getDrawable(doctorModel.getDoctorimage()));
    }

    @Override
    public int getItemCount()
    {
        return doctorList.size();
    }

    public class SelectDoctorViewHolder extends RecyclerView.ViewHolder {
        ImageView doctor_Image,hospital_logo;
        TextView hospitalname,hospitalarea,drname,degree,degrename,exp;

        public SelectDoctorViewHolder(@NonNull View itemView) {
            super(itemView);

            doctor_Image=itemView.findViewById(R.id.doctor_img);
            hospital_logo=itemView.findViewById(R.id.hospital_logo);
            hospitalname=itemView.findViewById(R.id.hospitalname);
            hospitalarea=itemView.findViewById(R.id.hospitalarea);
            drname=itemView.findViewById(R.id.drname);
            degree=itemView.findViewById(R.id.degree);
            degrename=itemView.findViewById(R.id.degreename);
            exp=itemView.findViewById(R.id.exp);

        }
    }
}
