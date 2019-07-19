package com.example.sierraobryan.myapplication.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sierraobryan.myapplication.data.model.Reason

@Dao
interface ReasonDao {
    @Query("Select * from Reason")
    fun getAllReasons(): LiveData<List<Reason>>

    @Insert
    fun inset(reason: Reason)


}