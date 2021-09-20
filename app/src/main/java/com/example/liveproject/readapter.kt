package com.example.liveproject

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.collections.ArrayList

class readapter(val context: Context?, var list: ArrayList<DataModel>)
    : RecyclerView.Adapter<readapter.ViewHolder>(), Filterable {

    var countryList = ArrayList<DataModel>()

    init {
        countryList = list
    }


    private val inflater =
        context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as? LayoutInflater

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView1: TextView = view.findViewById(R.id.first)
        val textView2: TextView = view.findViewById(R.id.first1)
        val textView3: TextView = view.findViewById(R.id.first11)
        val textView4: TextView = view.findViewById(R.id.second)
        val textView5: TextView = view.findViewById(R.id.third)
        val textView6: TextView = view.findViewById(R.id.fourth)
        val textView7: TextView = view.findViewById(R.id.five)
        val imageView: ImageView = view.findViewById(R.id.adddd)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowList = inflater?.inflate(R.layout.list1, parent, false)
        return ViewHolder(rowList!!)
    }


    override fun getItemCount(): Int {
        return countryList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView1.text = countryList.get(position).ststock
        holder.textView2.text = countryList.get(position).stcmp
        holder.textView3.text = countryList.get(position).stdate
        holder.textView4.text = countryList.get(position).sttarget
        holder.textView5.text = countryList.get(position).stsl
        holder.textView6.text = countryList.get(position).ststatus
        holder.textView7.text = countryList.get(position).stremark

        var  database = FirebaseDatabase.getInstance()
        var  myRef= database.getReference("users")
        holder.imageView.setOnClickListener {
            store()
//            myRef.setValue("shirin")

          //  database= FirebaseDatabase.getInstance().getReference("users").database

//            database.child("Users").child(user_id)
//                .addValueEventListener(object : ValueEventListener() {
//                    fun onDataChange(dataSnapshot: DataSnapshot) {
//                        if (dataSnapshot.exists()) {
//                            val userName: String = dataSnapshot.child("name").getValue().toString()
//                            holder.setUserName(userName)
//                        }
//                    }
//
//                    fun onCancelled(databaseError: DatabaseError?) {}
//                })

//            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        storedata()
//                        Log.e(VolleyLog.TAG, "Successfully signed in with email link")
//                        Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
//                        val result = task.result

                 }

                    if (countryList.get(position).ststatus.equals("SL Hit")) {
                        holder.textView6.setTextColor(Color.RED)
                    } else if (countryList.get(position).ststatus.equals("Active")) {
                        holder.textView6.setTextColor(Color.GREEN)
                    } else if (countryList.get(position).ststatus.equals("Achieved")) {
                        holder.textView6.setTextColor(Color.GREEN)
                    }
                }

    private fun store() {
        val model= DataModel(countryList)
        model.ststock=countryList.toString()

        val ref=FirebaseDatabase.getInstance().getReference("shiakh")
        val refe= ref.push().key

        val shaikh= DataModel(countryList)
        refe?.let {
            ref.child(it).setValue(shaikh).addOnCompleteListener {
                Toast.makeText(context,"saved shirin", Toast.LENGTH_LONG).show()


            }
        }
    }


    @ExperimentalStdlibApi
            override fun getFilter(): Filter {
                return object : Filter() {
                    override fun performFiltering(constraint: CharSequence?): FilterResults {
                        val charSearch = constraint.toString()
                        if (charSearch.isEmpty()) {
                            countryList = list
                        } else {
                            val resultList = ArrayList<DataModel>()
                            for (row in list) {
                                if (row.ststock.lowercase(Locale.ROOT)
                                        .contains(charSearch.lowercase(Locale.ROOT))
                                ) {
                                    resultList.add(row)
                                } else if (row.ststatus.lowercase(Locale.ROOT)
                                        .contains(charSearch.lowercase(Locale.ROOT))
                                ) {
                                    resultList.add(row)
                                } else if (row.ststatus.lowercase(Locale.ROOT)
                                        .contains(charSearch.lowercase(Locale.ROOT))
                                ) {
                                    resultList.add(row)
                                }
                            }
                            countryList = resultList
                        }
                        val filterResults = FilterResults()
                        filterResults.values = countryList
                        return filterResults
                    }

                    override fun publishResults(
                        constraint: CharSequence?,
                        results: FilterResults?
                    ) {
                        countryList = results?.values as ArrayList<DataModel>
                        notifyDataSetChanged()
                    }

                }


            }
        }

//        fun storedata() {
//            val model = DataModel()
//            model.ststock=
//        }
//    }
//}






