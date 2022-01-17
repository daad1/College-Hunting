package com.example.daadalotaibi_beltexam.Api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    private lateinit var retrofit: Retrofit

    fun getClient(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}