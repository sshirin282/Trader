package com.example.liveproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class custemAdapter(val context: Context, val name:Array<String>, val image1:Array<Int>):BaseAdapter(){
    private val inflater: LayoutInflater =
    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
      return name.size
    }

    override fun getItem(position: Int): Any {
       return name[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val rowView=inflater.inflate(R.layout.list,parent,false)
        val textView:TextView
        val image:ImageView
        textView=rowView.findViewById(R.id.textv1)
        image=rowView.findViewById(R.id.imagev1)
        textView.text=name[position]
        image.setImageResource(image1[position])
        return rowView
    }
}