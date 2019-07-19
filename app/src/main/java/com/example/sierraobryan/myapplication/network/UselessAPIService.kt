package com.example.sierraobryan.myapplication.network

import androidx.lifecycle.LiveData
import com.example.sierraobryan.myapplication.data.model.*
import retrofit2.http.GET

interface UselessAPIService {

    @GET("https://insult.mattbas.org/api/insult.json")
    fun getInsult() : LiveData<ApiResponse<Insult>>

    @GET("https://api.tronalddump.io/random/quote")
    fun getQuote() : LiveData<ApiResponse<Quote>>

    @GET("https://dog.ceo/api/breeds/image/random")
    fun getDogPic() : LiveData<ApiResponse<DogPic>>

}