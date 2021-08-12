package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity6 : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var button1: Button
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        toolbar = findViewById(R.id.toolbar2)
        textView = findViewById(R.id.textforget)
        button = findViewById(R.id.bnt2)
        button1 = findViewById(R.id.bnt1)
        textView.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }
//        button1.setOnClickListener {
//            val username = username.text.toString().trim()
//            val password = password.text.toString().trim()
//            if (username.isEmpty()){
//                username.ifEmpty { "username required"}
//            }else if(password.isEmpty()){
//                password.ifBlank { "password required" }
//            }
//        }


//        button1.setOnClickListener {
//            val user_msg_error: String = username.text.toString()
//
//            //check if the EditText have values or not
//            if (user_msg_error.trim().isEmpty()) {
//                username.error = "Required"
//                Toast.makeText(applicationContext, "User Name Required ", Toast.LENGTH_SHORT).show()
//            } else if (password.text.toString().trim().isEmpty()) {
//                password.error = "Required"
//                Toast.makeText(applicationContext, "Email Required ", Toast.LENGTH_SHORT).show()
//            }
            toolbar.setTitle("Login")
            toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
            setSupportActionBar(toolbar)
            username = findViewById(R.id.username)
            password = findViewById(R.id.password)
            toolbar.setNavigationOnClickListener(View.OnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish()
            })

        }
    }