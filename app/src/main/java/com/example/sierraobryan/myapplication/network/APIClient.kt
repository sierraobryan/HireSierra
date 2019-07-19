package com.example.sierraobryan.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {
        fun create(): HireMeService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .baseUrl("https://my-json-server.typicode.com/sierraobryan/final-project-android/")
                .build()
            return retrofit.create(HireMeService::class.java)
        }
    }
}