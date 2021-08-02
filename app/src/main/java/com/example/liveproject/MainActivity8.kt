package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class MainActivity8 : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)
        editText=findViewById(R.id.ereset)
        textView=findViewById(R.id.textreset)
        button=findViewById(R.id.resetbutton)
        toolbar=findViewById(R.id.toolreset)

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar.setTitle("Reset Password")
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            val intent=Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
    }
}