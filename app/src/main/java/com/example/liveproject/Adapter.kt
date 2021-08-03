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
//        val textView:TextView=view.findViewById(R.id.textintraday)
//        val textView1:TextView=view.findViewById(R.id.textintrday1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val rowList=inflater.inflate(R.layout.list1,parent,false)
        return ViewHolder(rowList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.textView.text=list.get(position).ststock
//        holder.textView.text=list.get(position).stcmp
//        holder.textView.text=list.get(position).stdate
    }

    override fun getItemCount(): Int {
       return list.size
    }
}