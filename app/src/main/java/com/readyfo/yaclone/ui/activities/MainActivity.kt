package com.readyfo.yaclone.ui.activities

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.readyfo.yaclone.R
import com.readyfo.yaclone.ui.fragments.HistoryFragment
import com.readyfo.yaclone.ui.fragments.TranslatorFragment

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceFragment(TranslatorFragment(), "translator")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                replaceFragment(HistoryFragment(), "history")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        if(savedInstanceState == null)
            addFragment(TranslatorFragment(), "translator")

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }


    private fun addFragment(fragment: androidx.fragment.app.Fragment, tag: String){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainFragmentContainer, fragment, tag)
            .commitAllowingStateLoss()
    }

    private fun replaceFragment(fragment: androidx.fragment.app.Fragment, tag: String){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFragmentContainer, fragment, tag)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }
}
