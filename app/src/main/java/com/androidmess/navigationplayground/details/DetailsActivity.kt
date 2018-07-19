package com.androidmess.navigationplayground.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.androidmess.navigationplayground.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setupToolbar()
    }

    override fun onSupportNavigateUp() =
            navController().navigateUp()

    private fun setupToolbar() {
        detailsToolbar.title = getString(R.string.menu_details_text)
        setSupportActionBar(detailsToolbar)
        detailsToolbar.setupWithNavController(navController())
    }

    private fun AppCompatActivity.navController() = Navigation.findNavController(this, R.id.details_nav_host_fragment)
}