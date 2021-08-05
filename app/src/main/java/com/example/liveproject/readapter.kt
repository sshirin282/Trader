package com.example.liveproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class readapter(val context: Context?, val list:ArrayList<DataModel> )
    : RecyclerView.Adapter<readapter.ViewHolder>()  {



    private val inflater: LayoutInflater
            =context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            as LayoutInflater

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView1: TextView =view.findViewById(R.id.first)
        val textView2: TextView =view.findViewById(R.id.second)
        val textView3: TextView =view.findViewById(R.id.third)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowList=inflater.inflate(R.layout.list1,parent,false)
        return ViewHolder(rowList)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: readapter.ViewHolder, position: Int) {
        holder.textView1.text=list.get(position).ststock
        holder.textView2.text=list.get(position).stcmp
        holder.textView3.text=list.get(position).stdate
    }
}