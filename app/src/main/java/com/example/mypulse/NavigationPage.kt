package com.example.mypulse

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigationpage)
        val bottomnav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomnav.setOnNavigationItemSelectedListener(navListener)
        loadFragment(HomeFragement())
    }

    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        var fragment: Fragment? = null
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_home -> {
                    /*toolbar.setTitle("Home");*/fragment = HomeFragement()
                    loadFragment(fragment)
                    return true
                }
                R.id.navigation_appointment -> {
                    /*toolbar.setTitle("Appointment");*/fragment = AppointmentFragement()
                    loadFragment(fragment)
                    return true
                }
                R.id.navigation_notification -> {
                    /*toolbar.setTitle("notification");*/fragment = NotificationFragement()
                    loadFragment(fragment)
                    return true
                }
                R.id.navigation_healthfiles -> {
                    /* toolbar.setTitle("Health Files");*/fragment = HealthFilesFragement()
                    loadFragment(fragment)
                    return true
                }
            }
            return false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}