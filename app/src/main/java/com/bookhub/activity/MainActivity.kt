package com.bookhub.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat
import com.bookhub.*
import com.bookhub.fragment.AboutAppFragment
import com.bookhub.fragment.DashboardFragment
import com.bookhub.fragment.FavouriteFragment
import com.bookhub.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout:DrawerLayout
    lateinit var coordinatorLayout:CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView:NavigationView
    var previousMenuItem : MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BookHub)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)


        setUpToolbar()
        openDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout , R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            if(previousMenuItem != null)
            {
                 previousMenuItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked =true
            previousMenuItem =it


            when(it.itemId)
            {
                R.id.dashboard ->{
                    openDashboard()
                }

//                R.id.favourites ->{
//
//                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, FavouriteFragment()).commit()
//                    supportActionBar?.title = "Favourites"
//                    drawerLayout.closeDrawers()
//                }

                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, ProfileFragment()).commit()
                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }
                R.id.about_app ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, AboutAppFragment()).commit()
                    supportActionBar?.title = "About App"
                    drawerLayout.closeDrawers()                }
            }

            return@setNavigationItemSelectedListener true
        }
    }

    fun setUpToolbar()
    {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "BookHub"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    fun openDashboard()
    {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = DashboardFragment()

        transaction.replace(R.id.frameLayout,fragment)
        transaction.commit()

        supportActionBar?.title = "Dashboard"
        drawerLayout.closeDrawers()

        navigationView.setCheckedItem(R.id.dashboard)

    }

    override fun onBackPressed() {

        val frag = supportFragmentManager.findFragmentById(R.id.frameLayout)

        when(frag)
        {
            !is DashboardFragment -> openDashboard()

            else -> super.onBackPressed()
        }

    }
}