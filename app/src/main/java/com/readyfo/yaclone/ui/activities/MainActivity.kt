package com.readyfo.yaclone.ui.activities

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.readyfo.yaclone.ui.fragments.HistoryFragment
import com.readyfo.yaclone.ui.fragments.TranslatorFragment



class MainActivity : AppCompatActivity() {
    private lateinit var navView: BottomNavigationView
    private val fm = supportFragmentManager
    private var transFrag = TranslatorFragment.newInstance()
    private var historyFrag = HistoryFragment.newInstance()
    private var active = transFrag

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            com.readyfo.yaclone.R.id.navigation_home -> {
                removeFragment("history")
                showFragment("translator")
                return@OnNavigationItemSelectedListener true
            }
            com.readyfo.yaclone.R.id.navigation_dashboard -> {
                replaceAndHideFragment(historyFrag, "history")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.readyfo.yaclone.R.layout.activity_main)

        if (savedInstanceState == null) {
            addFragment(transFrag, "translator")
        }

        navView = findViewById(com.readyfo.yaclone.R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun onBackPressed() {
        if (transFrag.isHidden) {
            removeFragment("history")
            showFragment("translator")
            navView.menu.getItem(0).isChecked = true
        }
        else
            super.onBackPressed()
    }


    private fun addFragment(fragment: Fragment, tag: String){
        fm.beginTransaction()
            .add(com.readyfo.yaclone.R.id.mainFragmentContainer, fragment, tag)
            .commitAllowingStateLoss()
    }

    private fun replaceAndHideFragment(fragment: Fragment, tag: String){
        fm.beginTransaction()
            .hide(active)
            .add(com.readyfo.yaclone.R.id.mainFragmentContainer, fragment, tag)
            .commitAllowingStateLoss()
    }

    private fun showFragment(tag: String){
        val fragment = fm.findFragmentByTag(tag)
        if (fragment != null) {
            fm.beginTransaction()
                .show(fragment)
                .commit()
        }
    }

    private fun removeFragment(tag: String){
        val fragment = fm.findFragmentByTag(tag)
        if (fragment != null) {
            fm.beginTransaction()
                .remove(fragment)
                .commit()
        }
    }
}
