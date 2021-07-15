package com.example.liveproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity4 : AppCompatActivity() {
    lateinit var toolbar1: androidx.appcompat.widget.Toolbar
    lateinit var custemAdapter: custemAdapter
    lateinit var listView: ListView
    val name= arrayOf<String>("Predict weekly thursday NIFTY(Cash) level during  contest is live.",
    "Contest page will start on friday morning and will end on  wednesday night.",
    "Winners can submit and re-submit unlimited times of  prediction during contest is live.",
    "Our team will contact the winners for prizes.","Everyone can see people's prediction until thursday NIFTY expiry and winners will be declared based on prediction. It is fullytransparent system.",
    "Top 3 weekly winners (+ - 10 range or close to...) will get technical analysis book.",
    "Two (2) times winners (+ - 10 range)in a month will get non-Chinese brand smart phone.",
    "Four (4) times winners (+ - 10 range) in a month will get non-Chinese brand smart LED TV.",
    "Minimum participant's required for winning is 100, below 100 participants winners will not be annouced.")
    val image= arrayOf<Int>(R.drawable.d,R.drawable.d,R.drawable.d,R.drawable.d,
        R.drawable.d,R.drawable.d,R.drawable.d,R.drawable.d,R.drawable.d,)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        toolbar1= findViewById(R.id.tool1)
        setSupportActionBar(toolbar1)
    listView=findViewById(R.id.listview)
    custemAdapter=custemAdapter(this,name,image)
    listView.adapter=custemAdapter
    }
}