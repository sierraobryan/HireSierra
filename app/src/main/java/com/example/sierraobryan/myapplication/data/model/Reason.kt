package com.example.sierraobryan.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Reason (
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val examples: List<Example>
)