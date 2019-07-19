package com.example.sierraobryan.myapplication.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sierraobryan.myapplication.data.model.Comment

@Dao
interface CommentsDao {

    @Insert
    fun insert(commet: Comment)

    @Query("Select * from comment_table")
    fun getAllComments():List<Comment>

    @Insert
    fun insert(comments: List<Comment>)
}