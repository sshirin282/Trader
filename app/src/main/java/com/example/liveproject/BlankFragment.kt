package com.example.liveproject

import  android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import java.util.Locale.filter
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter: readapter
        var list: ArrayList<DataModel> = ArrayList<DataModel>()
        var i: Int = 0
        val BASE_URL: String = "https://maxgenitsolutions.in/stock/apistockview?category=intraday"
        var recyclerView: RecyclerView = view.findViewById(R.id.recyclerintraday)
        var spinner: Spinner=view.findViewById(R.id.spinner)
        var searchView: SearchView =view.findViewById(R.id.search)
        adapter= readapter(activity,list)
        var name: Array<String> = arrayOf("ALL", "Search Stock", "Active", "Achieved", "SL Hit")

        val arrayAdapter = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, name)
        spinner.adapter = arrayAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (list.contains(query)) {
                    adapter.filter.filter(query)
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
        spinner.onItemSelectedListener= object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                if(position >0 && position < list.size){
//                    adapter.filter.filter(spinner.selectedItem.toString())

              //  }
                Toast.makeText(context,"Logout",Toast.LENGTH_LONG).show()
                adapter.filter.filter(spinner.selectedItem.toString())

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val request:StringRequest= StringRequest(Request.Method.GET,BASE_URL,Response.Listener {
            response->
          Log.e("response>>>>",response+"")
            val ja:JSONObject= JSONObject(response)
            val jb:JSONArray=ja.getJSONArray("list")
            for(i in 0 until jb.length()){
                val jsonobject:JSONObject=jb.getJSONObject(i)
                val ststock:String=jsonobject.getString("ststock")
                val stcmp:String=jsonobject.getString("stcmp")
                val stdate:String=jsonobject.getString("stdate")
                val sttarget:String=jsonobject.getString("sttarget")
                val stsl:String=jsonobject.getString("stsl")
                val ststatus:String=jsonobject.getString("ststatus")
                val stremark:String=jsonobject.getString("stremark")

                val dataModel=DataModel()
                dataModel.ststock=ststock
                dataModel.stcmp=stcmp
                dataModel.stdate=stdate
                dataModel.sttarget=sttarget
                dataModel.stsl=stsl
                dataModel.ststatus=ststatus
                dataModel.stremark=stremark
                list.add(dataModel)
            }

            adapter= readapter(context,list)
            val layoutManager=LinearLayoutManager(context)
            recyclerView.layoutManager=layoutManager
            recyclerView.adapter=adapter

        },Response.ErrorListener {
            Log.e("error",it.toString())
        })
        val queque:RequestQueue=Volley.newRequestQueue(activity)
        queque.add(request)
    }





}


