package com.example.liveproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView

class recyclerAdapter(val context: Context, val list:ArrayList<DataModel> ):
   RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val inflater: LayoutInflater
            =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}