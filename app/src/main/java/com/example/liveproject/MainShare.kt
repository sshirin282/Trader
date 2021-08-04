package com.example.liveproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar

class MainShare : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_share)
        toolbar=findViewById(R.id.toolshare)
        toolbar.setTitle("Share App")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.homecontext,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.conthome ->{
                val intent=Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
        }
        return true
    }
}