package com.example.sierraobryan.myapplication.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sierraobryan.myapplication.data.model.AnalyticObject

@Dao
interface AnalyticsDao {

    @Insert
    fun insert(analyticObject: AnalyticObject)

    @Query("Select * from ANALYTIC_TABLE")
    fun getAll(): LiveData<List<AnalyticObject>>

    @Query("Delete from ANALYTIC_TABLE")
    fun deleteAll()
}