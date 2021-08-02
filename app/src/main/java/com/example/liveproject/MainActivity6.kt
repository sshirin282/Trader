package com.example.liveproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toolbar

class MainActivity6 : AppCompatActivity() {
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        toolbar=findViewById(R.id.toolbar2)
        toolbar.setTitle("Login")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        setSupportActionBar(toolbar)
        editText1=findViewById(R.id.edittext)
        editText2=findViewById(R.id.edittext1)
    }


}