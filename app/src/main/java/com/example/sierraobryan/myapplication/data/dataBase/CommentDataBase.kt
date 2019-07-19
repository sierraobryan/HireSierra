package com.example.sierraobryan.myapplication.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sierraobryan.myapplication.data.dao.AnalyticsDao
import com.example.sierraobryan.myapplication.data.dao.CommentsDao
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.model.Comment

@Database(entities = arrayOf(Comment::class), version = 4, exportSchema = false)
abstract class CommentDataBase: RoomDatabase() {
    abstract fun commentDao() : CommentsDao

    companion object {
        private var INSTANCE: CommentDataBase? = null

        fun getInstance(context: Context): CommentDataBase? {
            if (INSTANCE == null) {
                synchronized(CommentDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        CommentDataBase::class.java, "comment.db"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

    }
}