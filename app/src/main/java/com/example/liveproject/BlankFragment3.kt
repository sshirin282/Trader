package com.example.liveproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment3 : Fragment() {
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
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url:String="https://maxgenitsolutions.in/stock/apistockview?category=longterm"
        val recyclerView:RecyclerView=view.findViewById(R.id.recyclerlongtem)
        val i:Int=0
        var recyclerAdapter:readapter
        val list:ArrayList<DataModel> = ArrayList<DataModel>()
        var spinner: Spinner =view.findViewById(R.id.spinner)
        var searchView: SearchView =view.findViewById(R.id.search3)
        recyclerAdapter= readapter(activity,list)
        var name: Array<String> = arrayOf("ALL", "Search Stock", "Active", "Achieved", "SL Hit")
        val arrayAdapter = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, name)
        spinner.adapter = arrayAdapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (list.contains(query)) {
                    recyclerAdapter.filter.filter(query)
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                recyclerAdapter.filter.filter(newText)
                return false
            }
        })

        val request: StringRequest = StringRequest(Request.Method.GET,url, {
            response ->
            Log.e("response>>>>",response)
            val js: JSONObject = JSONObject(response)
            val jb: JSONArray =js.getJSONArray("list")
            for (i in 0 until jb.length()){
                val jsonObject: JSONObject =jb.getJSONObject(i)
                val ststock:String=jsonObject.getString("ststock")
                val stcmp:String=jsonObject.getString("stcmp")
                val stdate:String=jsonObject.getString("stdate")
                val sttarget:String=jsonObject.getString("sttarget")
                val stsl:String=jsonObject.getString("stsl")
                val ststatus:String=jsonObject.getString("ststatus")
                val stremark:String=jsonObject.getString("stremark")

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
            recyclerAdapter= readapter(context,list)
            val layoutManager= LinearLayoutManager(context)
            recyclerView.layoutManager=layoutManager
            recyclerView.adapter=recyclerAdapter

        }, {

        })
        val queue: RequestQueue = Volley.newRequestQueue(context)
        queue.add(request)
    }




}