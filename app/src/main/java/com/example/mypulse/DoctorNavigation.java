package com.example.mypulse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DoctorNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_navigation);

        BottomNavigationView bottomnav = findViewById(R.id.doctornavigation);
        bottomnav.setOnNavigationItemSelectedListener(navListener);

        loadFragment(new DoctorHomeFragement());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.doctor_navigation_home:
                    /*toolbar.setTitle("Home");*/
                    fragment = new DoctorHomeFragement();
                    loadFragment(fragment);
                    return true;

                case R.id.doctor_navigation_profile:
                    /*toolbar.setTitle("Profile");*/
                    fragment = new DoctorProfileFragement();
                    loadFragment(fragment);
                    return true;

            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
