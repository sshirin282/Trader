package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth

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
        button.setOnClickListener {
            val auth=FirebaseAuth.getInstance()
            auth.sendPasswordResetEmail(editText.text.toString())
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Successful",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show()
                    }
                }

        }
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
            finish()
        })



    }
}