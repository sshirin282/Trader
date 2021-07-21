package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity3 : AppCompatActivity() {
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        bottomNavigationView=findViewById(R.id.navigation)
        navigationView=findViewById(R.id.navigationview)
        drawerLayout=findViewById(R.id.dra)
        toolbar=findViewById(R.id.tool)
        toolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24)
        toolbar.setTitle("Intraday")
        setSupportActionBar(toolbar)

        toggle= ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.isDrawerIndicatorEnabled=true


        val fragment= BlankFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
        true

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home2 -> {
                    val intent=Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                }
                R.id.intra2 -> {
                    toolbar.setTitle("Intraday")
                    val fragment= BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.sterm2 -> {
                    toolbar.setTitle("Short term")
                    val fragment= BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.lterm2 ->{
                    toolbar.setTitle("Long term")
                    val fragment= BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.detail2 ->{
                    toolbar.setTitle("Details")
                    val fragment= BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.contest2 ->{
                }
                R.id.share2 ->{
                }
                R.id.prize2 ->{
                    val intent=Intent(this,MainActivity4::class.java)
                    startActivity(intent)
                }
                R.id.disclaimer2 ->{
                    val intent=Intent(this,MainActivity5::class.java)
                    startActivity(intent)
                }
            }
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }


        bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.intra->{
                    toolbar.setTitle("Intraday")
                    val fragment= BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
//                    Toast.makeText(this,"Intraday",Toast.LENGTH_LONG).show()
//                    val intent=Intent(this,MainActivity2::class.java)
//                    startActivity(intent)
                }
                R.id.sterm->{
                    toolbar.setTitle("Short term")
                    val fragment= BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.lterm->{
                    toolbar.setTitle("Long term")
                    val fragment= BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.detail->{
                    toolbar.setTitle("Details")
                    val fragment= BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.contest->{
                }

            }
        }
    }
}