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
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainContest : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView:NavigationView
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_contest)
        toolbar=findViewById(R.id.contesttoll)
        navigationView=findViewById(R.id.sidenavigationviewcontext)
        bottomNavigationView=findViewById(R.id.bottomnavigationcontext)
        drawerLayout=findViewById(R.id.dracontest)
        textView=findViewById(R.id.contesttext)
        toolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24)
        toolbar.setTitle("Contest")
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.isDrawerIndicatorEnabled = true

        val header: View = navigationView.getHeaderView(0)
        val tv: TextView = header.findViewById(R.id.login)
        tv.setOnClickListener {
            val intent= Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
        val tv1: TextView = header.findViewById(R.id.sign)
        tv1.setOnClickListener {
            val intent= Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }

        bottomNavigationView.setSelectedItemId(R.id.contest)
        val fragment = BlankFragment5()
        supportFragmentManager.beginTransaction().replace(R.id.relativecontest, fragment).commit()
        true
        navigationView.setCheckedItem(R.id.contest2)
        toolbar.setTitle("Contest")

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.intra -> {
                    val intent=Intent(this,MainActivity3::class.java)
                    startActivity(intent)
                    val fragment = BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.relativecontest, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.intra2)
                    toolbar.setTitle("Intraday")
                    true
                }
                R.id.sterm -> {
                    val intent=Intent(this,MainActivity3::class.java)
                    startActivity(intent)
                    val fragment = BlankFragment2()
                    supportFragmentManager.beginTransaction().replace(R.id.relativecontest, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.sterm2)
                    toolbar.setTitle("Short term")
                    true
                }
                R.id.lterm -> {
                    val intent=Intent(this,MainActivity3::class.java)
                    startActivity(intent)
                    val fragment = BlankFragment3()
                    supportFragmentManager.beginTransaction().replace(R.id.relativecontest, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.lterm2)
                    toolbar.setTitle("Long term")
                    true
                }
                R.id.detail -> {
                    val intent=Intent(this,MainDetails::class.java)
                    startActivity(intent)
                    val fragment = BlankFragment4()
                    supportFragmentManager.beginTransaction().replace(R.id.relativecontest, fragment).commit()
                    true
                    navigationView.setCheckedItem(R.id.detail2)
                    toolbar.setTitle("Details")
                    true
                }
                R.id.contest -> {
                    true
                }
                else -> false
            }
        }


        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home2 -> {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    true
                }
                R.id.intra2 -> {
                    val intent=Intent(this,MainActivity3::class.java)
                    startActivity(intent)
                    bottomNavigationView.setSelectedItemId(R.id.intra)
                    toolbar.setTitle("Intraday")
                    val fragment = BlankFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                }
                R.id.sterm2 -> {
                    val intent=Intent(this,MainActivity3::class.java)
                    startActivity(intent)
                    bottomNavigationView.setSelectedItemId(R.id.sterm)
                    toolbar.setTitle("Short term")
                    val fragment = BlankFragment2()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                }
                R.id.lterm2 -> {
                    val intent=Intent(this,MainActivity3::class.java)
                    startActivity(intent)
                    bottomNavigationView.setSelectedItemId(R.id.lterm)
                    toolbar.setTitle("Long term")
                    val fragment = BlankFragment3()
                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                }
                R.id.detail2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.detail)
                    toolbar.setTitle("Details")
                    val intent=Intent(this,MainDetails::class.java)
                    startActivity(intent)
//                    val fragment = BlankFragment4()
//                    supportFragmentManager.beginTransaction().replace(R.id.framedetails, fragment).commit()
                    true
                }
                R.id.contest2 -> {
                    bottomNavigationView.setSelectedItemId(R.id.contest)
                    true
                }
                R.id.share2 -> {
                    val intent=Intent(this,MainShare::class.java)
                    startActivity(intent)
                    true
                }
                R.id.prize2 -> {
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                    true
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
