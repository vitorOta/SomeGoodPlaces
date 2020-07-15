package com.vitorota.somegoodplaces.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.vitorota.somegoodplaces.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.navHostFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> navController.navigate(R.id.nav_places)
                R.id.menu_map -> navController.navigate(R.id.nav_map)
                R.id.menu_profile -> navController.navigate(R.id.nav_profile)
            }

            supportActionBar?.title = navController.currentDestination?.label

            true
        }
    }
}