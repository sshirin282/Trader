package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class MainActivity8 : AppCompatActivity() {
    lateinit var editText81: EditText
    lateinit var editText82: EditText
    lateinit var editText83: EditText
    lateinit var editText84: EditText
    lateinit var textView81: TextView
    lateinit var button81: Button
    lateinit var button82: Button
    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)
        toolbar=findViewById(R.id.ttt)
        toolbar.setTitle("Register")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        setSupportActionBar(toolbar)
        editText81=findViewById(R.id.edit81)
        editText82=findViewById(R.id.edit82)
        editText83=findViewById(R.id.edit83)
        editText84=findViewById(R.id.edit84)
        textView81=findViewById(R.id.text8)
        button81=findViewById(R.id.bnt81)
        button82=findViewById(R.id.bnt82)
        button82.setOnClickListener {
            val intent= Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        })
    }
}