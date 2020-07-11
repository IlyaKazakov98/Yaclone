package com.readyfo.yaclone.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.readyfo.yaclone.R
import com.readyfo.yaclone.presentation.utils.setVisibility


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

    private fun setupNavigation() {
        bottomNavView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.navigation_translator, R.id.navigation_history -> showBottomNavigation()
                else -> hideBottomNavigation()
            }
        }

        bottomNavView.setupWithNavController(navController)
    }

    private fun showBottomNavigation() {
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        setVisibility(navView, true)
    }

    private fun hideBottomNavigation() {
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        setVisibility(navView, false)
    }
}