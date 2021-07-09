package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.nio.channels.AsynchronousFileChannel.open


class MainActivity2 : AppCompatActivity() {
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var toolbar:Toolbar
    lateinit var cardView1: CardView
    lateinit var cardView2: CardView
    lateinit var cardView3: CardView
    lateinit var cardView4: CardView
    lateinit var cardView5: CardView
    lateinit var cardView6: CardView


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
        cardView1=findViewById(R.id.card1)
        cardView2=findViewById(R.id.card2)
        cardView3=findViewById(R.id.card3)
        cardView4=findViewById(R.id.card4)
        cardView5=findViewById(R.id.card5)
        cardView6=findViewById(R.id.card6)
        cardView1.setOnClickListener{
            val intent= Intent(this,MainActivity3::class.java)
         startActivity(intent)
        }
        cardView2.setOnClickListener{
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        cardView3.setOnClickListener{
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        cardView4.setOnClickListener{
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        cardView5.setOnClickListener{
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        cardView6.setOnClickListener{
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
    }
}
