package com.example.liveproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.volley.VolleyLog.TAG
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity8 : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var emailoptional: EditText
    lateinit var textView81: TextView
    lateinit var button81: Button
    lateinit var button82: Button
    lateinit var button83:Button
    lateinit var toolbar: Toolbar
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        toolbar=findViewById(R.id.ttt)
        toolbar.setTitle("Register")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        setSupportActionBar(toolbar)
        username=findViewById(R.id.username)
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        emailoptional=findViewById(R.id.emailoptional)
        textView81=findViewById(R.id.text8)
        button81=findViewById(R.id.bnt81)
        button83=findViewById(R.id.bnt83)
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
        var  database = FirebaseDatabase.getInstance()
        var  myRef= database.getReference("users")
        button83.setOnClickListener {
            database= FirebaseDatabase.getInstance().getReference("users").database
//            val user= User(username,password,emailoptional,email)
            database.child("Users").child(user_id)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            val userName = dataSnapshot.child("name").value.toString()
//                            holder.setUserName(userName)

                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                })
        }


        val auth=FirebaseAuth.getInstance()
        button81.setOnClickListener {
            if(username.text.toString().isEmpty() && password.text.toString().isEmpty() && email.text.toString().isEmpty()) {
                username.setError("Please enter username")
                password.setError("Please enter password")
                email.setError("Please enter email")
            }else{
                auth.createUserWithEmailAndPassword(email.text.toString(),password.text.toString())
                    .addOnCompleteListener { task->
                        if (task.isSuccessful){
                            storedata()
                            Log.e(TAG,"Successfully signed in with email link")
                            Toast.makeText(this,"Successful",Toast.LENGTH_LONG).show()
                            val result=task.result
                        }else{

                            Log.e(TAG,"Error signing in with email link",task.exception)
                            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                        }
                    }
            }

        }
    }

    private fun storedata() {
        val model= DataModel1()
        model.username=username.text.toString()
        model.email=email.text.toString()
        model.password=password.text.toString()
        model.emailoptional=emailoptional.text.toString()

        val sharedPreferences: SharedPreferences =this.getSharedPreferences("USER", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor=sharedPreferences.edit()

        val dp=FirebaseFirestore.getInstance()
        dp.collection("user").document(email.text.toString()).set(model).addOnSuccessListener {
            editor.putString("email",username.text.toString())
            editor.putString("password",password.text.toString())
            editor.apply()
            editor.commit()
            Toast.makeText(this,"Suceessful",Toast.LENGTH_LONG).show()
        }
            .addOnFailureListener {
                Log.e(TAG,"Error",it)
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
            }
    }
}