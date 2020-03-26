package com.example.resume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.resume.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //for navigation drawer
        drawerLayout = binding.drawerLayout

        //in order for the menu to appear in all our main tabs from navigation drawer we have to specify them
        appBarConfiguration = AppBarConfiguration.Builder(setOf(R.id.homeFragment,R.id.educationFragment,R.id.workexperienceFragment)).setOpenableLayout(drawerLayout).build()

        val navController = this.findNavController(R.id.myNavHostFragment)

        //for action bar
        //we also declare here which fragments will have the up button
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)

        //for navigation drawer
        NavigationUI.setupWithNavController(binding.navDrawerView,navController)

        //for bottom navigation drawer
        NavigationUI.setupWithNavController(binding.bottomNav,navController)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val retValue = super.onCreateOptionsMenu(menu)
        val navigationView = findViewById<NavigationView>(R.id.navDrawerView)
        // The NavigationView already has these same navigation items, so we only add
        // navigation items to the menu here if there isn't a NavigationView
        if (navigationView == null) {
            menuInflater.inflate(R.menu.options_menu, menu)
            return true
        }
        return retValue
    }

    //for the options menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.myNavHostFragment))
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController,appBarConfiguration)
    }

}
