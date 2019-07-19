package com.example.sierraobryan.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UselessAPIClient {
    companion object {
        fun create():UselessAPIService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://localhost/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
            return retrofit.create(UselessAPIService::class.java)
        }
    }
}