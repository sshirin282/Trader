package com.example.liveproject

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface intradayInterface {

    @GET("apistockview")
    fun getData(@Query("category")  category:String):retrofit2.Call<List<DataModel>>

}