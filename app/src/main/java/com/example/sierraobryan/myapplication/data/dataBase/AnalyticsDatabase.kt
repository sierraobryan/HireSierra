package com.example.sierraobryan.myapplication.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.sierraobryan.myapplication.data.dao.AnalyticsDao
import com.example.sierraobryan.myapplication.data.model.AnalyticObject

@Database(entities = arrayOf(AnalyticObject::class), version = 1, exportSchema = false)
abstract class AnalyticsDatabase: RoomDatabase() {
    abstract fun analyticsDao() : AnalyticsDao

    companion object {
        private var INSTANCE: AnalyticsDatabase? = null

        fun getInstance(context: Context): AnalyticsDatabase? {
            if (INSTANCE == null) {
                synchronized(AnalyticsDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AnalyticsDatabase::class.java, "name.db"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(object : RoomDatabase.Callback() {
                        })
                        .build()
                }
            }
            return INSTANCE
        }

    }
}
