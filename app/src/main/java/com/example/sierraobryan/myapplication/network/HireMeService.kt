package com.example.sierraobryan.myapplication.network

import androidx.lifecycle.LiveData
import com.example.sierraobryan.myapplication.data.model.ApiResponse
import com.example.sierraobryan.myapplication.data.model.Comment
import com.example.sierraobryan.myapplication.data.model.Entitlements
import com.example.sierraobryan.myapplication.data.model.Reason
import retrofit2.http.GET

interface HireMeService {

    @GET("reasons")
    fun getReasons() : LiveData<ApiResponse<List<Reason>>>

    @GET("comments")
    fun getComments() : LiveData<ApiResponse<List<Comment>>>

    @GET("improvementComments")
    fun getImprovements() : LiveData<ApiResponse<List<Comment>>>

    @GET("entitlements")
    fun getEntitlements() : LiveData<ApiResponse<List<Entitlements>>>
}