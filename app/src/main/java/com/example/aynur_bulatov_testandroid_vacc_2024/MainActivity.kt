package com.example.aynur_bulatov_testandroid_vacc_2024

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.containerView) as NavHostFragment

        navController = navHostFragment.navController
        binding.bottomMenu.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.mainScreenFragment -> {
                    binding.bottomMenu.visibility = View.VISIBLE
                }

                R.id.authFragment -> {
                    binding.bottomMenu.visibility = View.GONE
                }

                R.id.detailsScreenFragment -> {
                    binding.bottomMenu.visibility = View.GONE
                }

                R.id.shoppingCartFragment -> {
                    binding.bottomMenu.visibility = View.VISIBLE
                }

                else -> {
                    binding.bottomMenu.visibility = View.VISIBLE
                }
            }
        }
    }
}