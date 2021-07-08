package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.nio.channels.AsynchronousFileChannel.open


class MainActivity2 : AppCompatActivity() {
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var toolbar:Toolbar
    val name= arrayOf<String>("Intraday", "Short Term","Long Term", "Details", "Contest", "Share")
    val image=arrayOf<Int>(R.drawable.ic_baseline_business_center_24,R.drawable.ic_baseline_timer_24,
    R.drawable.ic_baseline_bar_chart_24,R.drawable.ic_baseline_details_24,R.drawable.ic_baseline_category_24,
    R.drawable.ic_baseline_share_24)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        navigationView=findViewById(R.id.navigationview)
        drawerLayout=findViewById(R.id.drawerlayout)
        toolbar=findViewById(R.id.tool)
        setSupportActionBar(toolbar)
        toggle= ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.isDrawerIndicatorEnabled=true
//
//        imageView1.setOnClickListener{
//            val intent= Intent(this,MainActivity3::class.java)
//         startActivity(intent)
//        }
//        imageView2.setOnClickListener{
//            val intent= Intent(this,MainActivity3::class.java)
//            startActivity(intent)
//        }
//        imageView3.setOnClickListener{
//            val intent= Intent(this,MainActivity3::class.java)
//            startActivity(intent)
//        }
//        imageView4.setOnClickListener{
//            val intent= Intent(this,MainActivity3::class.java)
//            startActivity(intent)
//        }
//        imageView5.setOnClickListener{
//            val intent= Intent(this,MainActivity3::class.java)
//            startActivity(intent)
//        }
//        imageView6.setOnClickListener{
//            val intent= Intent(this,MainActivity3::class.java)
//            startActivity(intent)
//        }
//




    }


    }
