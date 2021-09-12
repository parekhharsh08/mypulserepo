package com.example.mypulse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    Context c;
    String[] name,time;

    public NotificationAdapter(@NonNull Context c, String[] name, String[] time) {
        this.c = c;
        this.name = name;
        this.time = time;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_notification,parent,false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        holder.notifi_text.setText(name[position]);
        holder.notifi_time.setText(time[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder{


        ImageView notifi_Image;
        TextView notifi_text,notifi_time;

       public NotificationViewHolder(@NonNull View itemView) {

           super(itemView);
           notifi_Image=itemView.findViewById(R.id.notification_img);
           notifi_text=itemView.findViewById(R.id.notification_text);
           notifi_time=itemView.findViewById(R.id.notification_time);


       }
   }
}
