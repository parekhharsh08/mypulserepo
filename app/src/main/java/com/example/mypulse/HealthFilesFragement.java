package com.example.mypulse;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class HealthFilesFragement extends Fragment implements Button.OnClickListener {

    TextView editprofile;

    LinearLayout editprofile2;

    Button signoutbutton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.healthfiles_fragement, container, false);

        signoutbutton = rootview.findViewById(R.id.signoutbutton);
        signoutbutton.setOnClickListener(this);
        final TextView editprofile = (TextView) rootview.findViewById(R.id.editprofile);
        final LinearLayout prescription = (LinearLayout) rootview.findViewById(R.id.prescription_page);
        final LinearLayout editprofile2 = (LinearLayout) rootview.findViewById(R.id.editprofile2);

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), EditProfileHealthfiles.class);
                startActivity(intent);
            }
        });

        editprofile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), EditProfileHealthfiles.class);
                startActivity(intent);
            }
        });

        prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PrescriptionPage.class);
                startActivity(intent);
            }
        });

        return rootview;
    }


    public void btn_showdialog(View view) {

        final Dialog dialog = new Dialog(getContext());
        View mview = LayoutInflater.from(getActivity()).inflate(R.layout.custom_dialogbox_signout, null, false);
        dialog.setContentView(mview);
        TextView signout = dialog.findViewById(R.id.signout);
        TextView cancel = dialog.findViewById(R.id.cancel);


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
                Intent intent = new Intent(getActivity(), Login_my.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(getContext(), "Dialog Cancel", Toast.LENGTH_SHORT).show();

                Log.e("AlertDialog", "AlertDialog  ");


            }

        });

        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.signoutbutton) {
            btn_showdialog(view);
        }

    }
}





