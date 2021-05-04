package com.example.loginnavigation

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val host = supportFragmentManager.findFragmentById(R.id.nav_graph2) as NavHostFragment??:return
        val navController = host.navController
        if (navController != null) {
            Toast.makeText(this@MainActivity, "nav controller value is null",
                Toast.LENGTH_SHORT).show()
        }


      //  appBarConfiguration = AppBarConfiguration(1,navController.graph,true)

       // setupBottomNavMenu(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                Integer.toString(destination.id)
            }

            Toast.makeText(this@MainActivity, "Navigated to $dest",
                Toast.LENGTH_SHORT).show()
            Log.d("NavigationActivity", "Navigated to $dest")
        }
    }


private fun setupBottomNavMenu(navController: NavController) {

    val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
    bottomNav?.setupWithNavController(navController)

}
    private fun BottomNavigationView.setupWithNavController(navController: NavController) {
        NavigationUI.setupWithNavController(this, navController)
    }

}