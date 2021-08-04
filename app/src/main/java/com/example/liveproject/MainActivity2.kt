package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView



class MainActivity2 : AppCompatActivity() {
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var textView: TextView
//    lateinit var linearLayout1: LinearLayout
    lateinit var linearLayout2: LinearLayout
//    lateinit var linearLayout3: LinearLayout
    lateinit var linearLayout4: LinearLayout
    lateinit var linearLayout5: LinearLayout
    lateinit var linearLayout6: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        navigationView = findViewById(R.id.navigationview)
        drawerLayout = findViewById(R.id.drawerlayout)
        toolbar = findViewById(R.id.tool)
        toolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24)
        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.isDrawerIndicatorEnabled = true
        val navigationView: NavigationView =  findViewById(R.id.navigationview)
        val header: View = navigationView.getHeaderView(0)
        val tv: TextView = header.findViewById(R.id.login)
        tv.setOnClickListener {
            val intent=Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
        val tv1: TextView = header.findViewById(R.id.sign)
        tv1.setOnClickListener {
            val intent=Intent(this,MainActivity8::class.java)
            startActivity(intent)
        }

//        linearLayout1 = findViewById(R.id.card11)
        linearLayout2 = findViewById(R.id.card12)
//        linearLayout3 = findViewById(R.id.card21)
        linearLayout4 = findViewById(R.id.card22)
        linearLayout5 = findViewById(R.id.card34)
        linearLayout6 = findViewById(R.id.card32)

//        linearLayout1.setOnClickListener {
//            val intent=Intent(this,MainActivity3::class.java)
//            intent.putExtra("fragment","Intraday")
//            startActivity(intent)
//        }
        linearLayout2.setOnClickListener {
            val intent=Intent(this,MainActivity3::class.java)
            intent.putExtra("fragment","Short term")
            startActivity(intent)
        }
//        linearLayout3.setOnClickListener {
//            val intent=Intent(this,MainActivity3::class.java)
//            intent.putExtra("fragment","Long term")
//            startActivity(intent)
//        }
        linearLayout4.setOnClickListener {
            val intent=Intent(this,MainActivity3::class.java)
            intent.putExtra("fragment","Details")
            startActivity(intent)
        }
        linearLayout5.setOnClickListener {
            val intent=Intent(this,MainActivity3::class.java)
            intent.putExtra("fragment","Contest")
            startActivity(intent)
        }
        linearLayout6.setOnClickListener {

        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home2 -> {
                    val intent=Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                }
                R.id.intra2 -> {
                    val intent=Intent(this,MainActivity3::class.java)
                    intent.putExtra("fragment","Intraday")
                    startActivity(intent)
                }
                R.id.sterm2 -> {
                    val intent=Intent(this,MainActivity3::class.java)
                    intent.putExtra("fragment","Short term")
                    startActivity(intent)
                }
                R.id.lterm2 ->{
                    val intent=Intent(this,MainActivity3::class.java)
                    intent.putExtra("fragment","Long term")
                    startActivity(intent)
                }
                R.id.detail2 ->{
                    val intent=Intent(this,MainActivity3::class.java)
                    intent.putExtra("fragment","Details")
                    startActivity(intent)
                }
                R.id.contest2 ->{
                    val intent=Intent(this,MainActivity3::class.java)
                    intent.putExtra("fragment","Contest")
                    startActivity(intent)
                }
                R.id.share2 ->{
                    val intent=Intent(this,MainShare::class.java)
                    startActivity(intent)
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

    }

}








