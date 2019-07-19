package com.example.sierraobryan.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment_table")
data class Comment(
    val body: String,
    val name: String,
    val date: String,
    val rating: Int,
    val postId: Int) {

    @PrimaryKey(autoGenerate = true)
    var primaryKey: Int = 0
}