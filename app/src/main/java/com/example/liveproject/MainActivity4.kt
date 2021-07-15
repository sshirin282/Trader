package com.example.liveproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar

class MainActivity4 : AppCompatActivity() {
    lateinit var toolbar1: androidx.appcompat.widget.Toolbar
    lateinit var imageView1: ImageView
    lateinit var textView1: TextView
    lateinit var imageView2: ImageView
    lateinit var textView2: TextView
    lateinit var imageView3: ImageView
    lateinit var textView3: TextView
    lateinit var imageView4: ImageView
    lateinit var textView4: TextView
    lateinit var imageView5: ImageView
    lateinit var textView5: TextView
    lateinit var imageView6: ImageView
    lateinit var textView6: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        toolbar1= findViewById(R.id.tool1)
        setSupportActionBar(toolbar1)
        imageView1=findViewById(R.id.imageview1)
        textView1=findViewById(R.id.textview1)
        imageView2=findViewById(R.id.imageview2)
        textView2=findViewById(R.id.textview2)
        imageView3=findViewById(R.id.imageview3)
        textView3=findViewById(R.id.textview3)
        imageView4=findViewById(R.id.imageview4)
        textView4=findViewById(R.id.textview4)
        imageView5=findViewById(R.id.imageview5)
        textView5=findViewById(R.id.textview5)
        imageView6=findViewById(R.id.imageview6)
        textView6=findViewById(R.id.textview6)

    }
}