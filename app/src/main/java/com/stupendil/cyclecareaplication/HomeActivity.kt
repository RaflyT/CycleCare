package com.stupendil.cyclecareaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stupendil.cyclecareaplication.ChatFragment
import com.stupendil.cyclecareaplication.DiscussFragment
import com.stupendil.cyclecareaplication.HistoryFragment
import com.stupendil.cyclecareaplication.HomeFragment
import com.stupendil.cyclecareaplication.ScheduleFragment
import java.lang.Exception

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.discuss -> {
                    loadFragment(DiscussFragment())
                    true
                }
                R.id.schedule -> {
                    loadFragment(ScheduleFragment())
                    true
                }
                R.id.history -> {
                    loadFragment(HistoryFragment())
                    true
                }
                R.id.chat -> {
                    loadFragment(ChatFragment())
                    true
                }


            }
            false
        }
    }
    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

}
