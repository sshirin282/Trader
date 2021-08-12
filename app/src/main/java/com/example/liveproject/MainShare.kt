package com.example.liveproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainShare : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var imageView1: ImageView
    lateinit var imageView2: ImageView
    lateinit var imageView3: ImageView
    lateinit var imageView4: ImageView
    lateinit var textView1:TextView
    lateinit var textView2:TextView
    lateinit var textView3:TextView
    lateinit var textView4:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_share)
        toolbar=findViewById(R.id.toolshare)
        imageView1=findViewById(R.id.shareimage1)
        imageView2=findViewById(R.id.shareimage2)
        imageView3=findViewById(R.id.shareimage3)
        imageView4=findViewById(R.id.shareimage4)
        textView1=findViewById(R.id.sharetext1)
        textView2=findViewById(R.id.sharetext2)
        textView3=findViewById(R.id.sharetext3)
        textView4=findViewById(R.id.sharetext4)

        toolbar.setTitle("Share App")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        })

        imageView1.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, "stock market")
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent,"send to"))
        }
        imageView2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.youtube.com/watch?v=aTna7UBmsAs")
            startActivity(intent)
        }
        imageView3.setOnClickListener {
            val shareIntent= Intent()
            shareIntent.action = Intent.ACTION_VIEW
            shareIntent.data = Uri.parse("https://play.google.com/store/apps/details?id=com.stocktrends.mobileapp")
            startActivity(Intent.createChooser(intent,"Open with"))
        }
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
