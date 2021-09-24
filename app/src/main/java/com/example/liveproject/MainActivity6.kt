package com.example.liveproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.android.volley.VolleyLog.TAG
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity6 : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var button1: Button
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var refUser:DatabaseReference
     var firebaseUserID: String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        toolbar = findViewById(R.id.toolbar2)
        textView = findViewById(R.id.textforget)
        button = findViewById(R.id.bnt2)
        button1 = findViewById(R.id.bnt1)

        val sharedPreferences:SharedPreferences=this.getSharedPreferences("USER",Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor=sharedPreferences.edit()
        textView.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }
        val auth=FirebaseAuth.getInstance()

        button1.setOnClickListener {
            if(username.text.toString().isEmpty() && password.text.toString().isEmpty()){
                username.setError("Please enter username ")
                password.setError("Please enter password")
            }else
                auth.signInWithEmailAndPassword(username.text.toString(),password.text.toString())
                    .addOnCompleteListener { task->
                        if (task.isSuccessful){
                            firebaseUserID = auth.currentUser!!.uid
                            refUser=FirebaseDatabase.getInstance().reference.child("shirin").child(firebaseUserID)
                            Log.e(TAG,"Successfully signed in with email link")
                            val result=task.result
                            editor.putString("email",username.text.toString())
                            editor.putString("password",password.text.toString())
                            editor.apply()
                            editor.commit()
                            Toast.makeText(this,"Successful",Toast.LENGTH_LONG).show()
                            val intent=Intent(this, MainActivity2::class.java)
                            startActivity(intent)
                        }else{
                            Log.e(TAG,"Error signing in with email link", task.exception)
                            Toast.makeText(this,"Please Enter Valid Username And Password",Toast.LENGTH_LONG).show()

                        }
                    }

        }

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
