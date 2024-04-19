package com.example.app_rickmorty.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.app_rickmorty.R
import com.example.app_rickmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        private lateinit var appBarConfiguration: AppBarConfiguration
        private lateinit var binding: ActivityMainBinding
        private lateinit var navController: NavController

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            setSupportActionBar(binding.toolbar)

            val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHost
            navController = navHost.navController
            appBarConfiguration = AppBarConfiguration(navController.graph)
            setupActionBarWithNavController(navController, appBarConfiguration)

        }

        override fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp(appBarConfiguration)
                    || super.onSupportNavigateUp()
        }
}