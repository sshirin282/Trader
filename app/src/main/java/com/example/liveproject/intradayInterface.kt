package com.example.liveproject

import android.telecom.Call
import retrofit2.http.GET


interface intradayInterface {

    @GET("apistockview")
    fun getData():retrofit2.Call<List<DataModel>>

}