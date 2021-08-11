package com.example.liveproject

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class readapter(val context: Context?, val list: ArrayList<DataModel>)
    : RecyclerView.Adapter<readapter.ViewHolder>(), Filterable {


    var countryFilterList = ArrayList<DataModel>()

    init {
        countryFilterList = list
    }

    private val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            as LayoutInflater

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView1: TextView = view.findViewById(R.id.first)
        val textView2: TextView = view.findViewById(R.id.first1)
        val textView3: TextView = view.findViewById(R.id.first11)
        val textView4: TextView = view.findViewById(R.id.second)
        val textView5: TextView = view.findViewById(R.id.third)
        val textView6: TextView = view.findViewById(R.id.fourth)
        val textView7: TextView = view.findViewById(R.id.five)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowList = inflater.inflate(R.layout.list1, parent, false)
        return ViewHolder(rowList)
    }


    override fun getItemCount(): Int {
        return list.size
    }


//    @Override
//    public Filter getFilter() {
//        return Searched_Filter
//    }
//    private Filter Searched_Filter = new Filter() {
//        @Override
//        protected FilterResults :performFiltering(CharSequence constraint) {
//            ArrayList<DataModel>:filteredList = new ArrayList<>()
//            if (constraint == null || constraint.length() == 0) {
//                filteredList.addAll(FullList);
//            } else {
//                String filterPattern = constraint.toString().toLowerCase().trim();
//                for (ItemDataModel item : FullList) {
//                    if (item.getTxtname().toLowerCase().contains(filterPattern)) {
//                        filteredList.add(item);
//                    }
//                }
//            }
//            FilterResults results = new FilterResults();
//            results.values = filteredList;
//            return results;
//        }

    override fun onBindViewHolder(holder: readapter.ViewHolder, position: Int) {
        holder.textView1.text = list.get(position).ststock
        holder.textView2.text = list.get(position).stcmp
        holder.textView3.text = list.get(position).stdate
        holder.textView4.text = list.get(position).sttarget
        holder.textView5.text = list.get(position).stsl
        holder.textView6.text = list.get(position).ststatus
        holder.textView7.text = list.get(position).stremark

        if (list.get(position).ststatus.equals("SL Hit")) {
            holder.textView6.setTextColor(Color.RED)
        } else if (list.get(position).ststatus.equals("Active")) {
            holder.textView6.setTextColor(Color.GREEN)
        } else if (list.get(position).ststatus.equals("Achieved")) {
            holder.textView6.setTextColor(Color.GREEN)
        }
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    countryFilterList = list
                } else {
                    val resultList = ArrayList<DataModel>()

                    for (d in list) {
                        if(countryFilterList.toString() in d.ststock.toString()){
//                        if (row.ststock.toLowerCase().contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(d)
                        }
                    }
                    countryFilterList = resultList
                    Log.e("country>>>","result")
                }
                val filterResults = FilterResults()
                filterResults.values = countryFilterList
                return filterResults
            }
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                countryFilterList = results?.values as ArrayList<DataModel>
                notifyDataSetChanged()
                Log.e("results>>>","ssss")
            }
        }

    }
}