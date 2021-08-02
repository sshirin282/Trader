package com.example.liveproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class MainActivity7 : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var textText: TextView
    lateinit var button: Button
    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        toolbar=findViewById(R.id.tool7)
        toolbar.setTitle("Reset Password")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        setSupportActionBar(toolbar)
        editText=findViewById(R.id.edit2)
        textText=findViewById(R.id.textview7)
        button=findViewById(R.id.bnt7)
    }
}