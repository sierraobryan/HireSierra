package com.example.sierraobryan.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "analytic_table")
data class AnalyticObject(
    val activityName: String,
    val fragmentName: String,
    val action: String,
    val date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

