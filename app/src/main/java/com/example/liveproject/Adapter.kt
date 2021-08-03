package com.example.liveproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context, val  list:ArrayList<DataModel> )
    : RecyclerView.Adapter<Adapter.ViewHolder>()  {

    private val inflater:LayoutInflater
    =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
    as LayoutInflater

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val textView1:TextView=view.findViewById(R.id.first)
        val textView2:TextView=view.findViewById(R.id.second)
        val textView3:TextView=view.findViewById(R.id.third)
//        val textView4:TextView=view.findViewById(R.id.fourth)
//        val textView:TextView=view.findViewById(R.id.textintraday)
//        val textView1:TextView=view.findViewById(R.id.textintrday1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val rowList=inflater.inflate(R.layout.list1,parent,false)
        return ViewHolder(rowList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView1.text=list.get(position).ststock
        holder.textView2.text=list.get(position).stcmp
        holder.textView3.text=list.get(position).stdate
    }

    override fun getItemCount(): Int {
       return list.size
    }
}