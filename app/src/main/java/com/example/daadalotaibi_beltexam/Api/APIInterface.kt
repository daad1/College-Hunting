package com.example.daadalotaibi_beltexam.Api

import com.example.daadalotaibi_beltexam.Model.Universities
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

interface APIInterface {
    @Headers("Content-Type: application/json")
    @GET
    fun universityInfo(@Url url:String): Call<Universities?>?

}