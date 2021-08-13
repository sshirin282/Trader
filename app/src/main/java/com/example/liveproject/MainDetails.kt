package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainDetails : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle:ActionBarDrawerToggle
    //lateinit var recyclerView: RecyclerView
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_details)
        drawerLayout=findViewById(R.id.detailsdraw)
        toolbar=findViewById(R.id.tool)
        //recyclerView=findViewById(R.id.recyclerdetails)
        navigationView=findViewById(R.id.navigationviewdetailsside)
        bottomNavigationView=findViewById(R.id.navigationdetails)
        toolbar.setTitle("Details")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24)
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.isDrawerIndicatorEnabled = true

        val header: View = navigationView.getHeaderView(0)
        val tv: TextView = header.findViewById(R.id.login)
        tv.setOnClickListener {
            val intent=Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
        val tv1: TextView = header.findViewById(R.id.sign)
        tv1.setOnClickListener {
            val intent=Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }

        bottomNavigationView.setSelectedItemId(R.id.detail)
        val fragment = BlankFragment4()
        supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
        true
        navigationView.setCheckedItem(R.id.detail2)
        toolbar.setTitle("Details")

        bottomNavigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.intra -> {
                    val fragment = BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.intra2)
                    toolbar.setTitle("Intraday")

                }
                R.id.sterm -> {
                    val fragment = BlankFragment2()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.sterm2)
                    toolbar.setTitle("Short term")

                }
                R.id.lterm -> {
                    val fragment = BlankFragment3()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.lterm2)
                    toolbar.setTitle("Long term")

                }
                R.id.detail -> {
                    val fragment = BlankFragment4()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.detail2)
                    toolbar.setTitle("Details")

                }
                R.id.contest -> {
                }

            }
        }
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home2 -> {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                }
                R.id.intra2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.intra)
                    toolbar.setTitle("Intraday")
                    val fragment = BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                }
                R.id.sterm2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.sterm)
                    toolbar.setTitle("Short term")
                    val fragment = BlankFragment2()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                }
                R.id.lterm2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.lterm)
                    toolbar.setTitle("Long term")
                    val fragment = BlankFragment3()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                }
                R.id.detail2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.detail)
                    toolbar.setTitle("Details")
                    val fragment = BlankFragment4()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                }
                R.id.contest2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.contest)
                }
                R.id.share2 -> {
                    val intent=Intent(this,MainShare::class.java)
                    startActivity(intent)
                }
                R.id.prize2 -> {
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                }
                R.id.disclaimer2 -> {
                    val intent = Intent(this, MainActivity5::class.java)
                    startActivity(intent)
                }
            }
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.homecontext, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.conthome -> {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
        }
        return true
    }

}


