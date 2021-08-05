package com.example.liveproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
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
        var recyclerAdapter: readapter
        var list: ArrayList<DataModel> = ArrayList<DataModel>()
        var i: Int = 0
        val BASE_URL: String = "https://maxgenitsolutions.in/stock/apistockview?category=intraday"
        var recyclerView: RecyclerView = view.findViewById(R.id.recyclerintraday)



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
                val dataModel=DataModel()
                dataModel.ststock=ststock
                dataModel.stcmp=stcmp
                dataModel.stdate=stdate
            }
            recyclerAdapter= readapter(context,list)
            val layoutManager=LinearLayoutManager(context)
            recyclerView.layoutManager=layoutManager
            recyclerView.adapter=recyclerAdapter
        },Response.ErrorListener {

        })

        val queque:RequestQueue=Volley.newRequestQueue(activity)
        queque.add(request)


//
//                val i:Int=0
//                val ja: JSONArray = JSONArray(response.body())
//                for (i in 0 until ja.length()){
//                    val jb: JSONObject =ja.getJSONObject(i)
//                    val userId:String=jb.getString("userId")
//                    val id:String=jb.getString("userId")
//                    val title:String=jb.getString("userId")
//                    val body:String=jb.getString("userId")
//
//                    val dataModel = DataModel()
//                }

////    companion object {
////        /**
////         * Use this factory method to create a new instance of
////         * this fragment using the provided parameters.
////         *
////         * @param param1 Parameter 1.
////         * @param param2 Parameter 2.
////         * @return A new instance of fragment BlankFragment.
////         */
////        // TODO: Rename and change types and number of parameters
////        @JvmStatic
////        fun newInstance(param1: String, param2: String) =
////            BlankFragment().apply {
////                arguments = Bundle().apply {
////                    putString(ARG_PARAM1, param1)
////                    putString(ARG_PARAM2, param2)
////                }
////            }
////    }
//
//
//            })
//        }
    }
}




//    }
//}
