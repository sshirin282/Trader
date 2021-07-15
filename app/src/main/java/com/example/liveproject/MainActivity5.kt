package com.example.liveproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.widget.Toolbar

class MainActivity5 : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var custemAdapter: custemAdapter
    lateinit var toolbar:Toolbar
    val image= arrayOf<Int>(R.drawable.d,R.drawable.d,R.drawable.d,R.drawable.d,
        R.drawable.d,R.drawable.d,R.drawable.d)
    val name= arrayOf<String>("The information on Stock Market APP is for the education puurpose only.",
    "Before acting on any of the imformation given on the Stock Market APP, you should do your own diligent study or seek advice from an independent financial adviser.",
    "All the information shared on Stock Market APP is totally free and we are not selling any kind of products/services through this app directly or indirectly.",
    "You should consult a SEBI registered financial advisor prior to making any actual investment or trading decisions.",
    "The purpose of username/sign in required for the tracking of NIFTY weekly contest only, we are not keeping any ones data or sharing this data to anyone.",
    "Stock Market APP doesn't requires any additional permission like contact, storage or location.",
    "Users are requested to keep notification ON for the early updates.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        toolbar=findViewById(R.id.tool2)
        setSupportActionBar(toolbar)
        listView=findViewById(R.id.textview5)
        custemAdapter=custemAdapter(this,name,image)
        listView.adapter=custemAdapter

    }
}