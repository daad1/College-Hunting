package com.example.daadalotaibi_beltexam.Api

import com.example.daadalotaibi_beltexam.Model.ShowResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("search/shows")
    fun getShow(@Query("q") showTitle:String) : Call<ArrayList<ShowResponseItem>>
}