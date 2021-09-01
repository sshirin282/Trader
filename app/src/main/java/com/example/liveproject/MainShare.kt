package com.example.liveproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainShare : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var share: ImageView
    lateinit var youtube: ImageView
    lateinit var rateus: ImageView
    lateinit var gmail: ImageView
    lateinit var textView1:TextView
    lateinit var textView2:TextView
    lateinit var textView3:TextView
    lateinit var textView4:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_share)
        toolbar=findViewById(R.id.toolshare)
        share=findViewById(R.id.share)
        youtube=findViewById(R.id.youtube)
        rateus=findViewById(R.id.rateus)
        gmail=findViewById(R.id.gmail)
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

        share.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, "stock market")
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent,"send to"))
        }
        youtube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.youtube.com/watch?v=aTna7UBmsAs")
            startActivity(intent)
        }
        rateus.setOnClickListener {
            val shareIntent= Intent()
           shareIntent.data = Uri.parse("https://play.google.com/store/apps/details?id=com.stocktrends.mobileapp")
            startActivity(Intent.createChooser(shareIntent,"Open with"))
        }
        gmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "your_email"))
            startActivity(intent)
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
