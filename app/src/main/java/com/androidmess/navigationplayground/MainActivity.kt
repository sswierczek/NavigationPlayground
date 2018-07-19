package com.androidmess.navigationplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupToolbar()
        bottomNavigation.setupWithNavController(navController())
    }

    override fun onSupportNavigateUp() =
            navController().navigateUp()

    private fun setupToolbar() {
        mainToolbar.title = getString(R.string.menu_home_text)
        setSupportActionBar(mainToolbar)
        mainToolbar.setupWithNavController(navController())
    }

    private fun AppCompatActivity.navController() = findNavController(this, R.id.nav_host_fragment)
}