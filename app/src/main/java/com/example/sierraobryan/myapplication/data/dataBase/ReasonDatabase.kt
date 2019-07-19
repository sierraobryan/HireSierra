//package com.example.sierraobryan.myapplication.data.dataBase
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.example.sierraobryan.myapplication.data.dao.ReasonDao
//import com.example.sierraobryan.myapplication.data.model.Reason
////
////@Database(
////    entities = [Reason::class],
////    version = 1,
////    exportSchema = false
////    )
////abstract class ReasonDatabase: RoomDatabase() {
////    abstract fun reasonDao(): ReasonDao
////
////    companion object {
////        private var INSTANCE: ReasonDatabase? = null
////
////        fun getInstance(context: Context): ReasonDatabase? {
////            if (INSTANCE == null) {
////                synchronized(ReasonDatabase::class) {
////                    INSTANCE = Room.databaseBuilder(
////                        context.getApplicationContext(),
////                        ReasonDatabase::class.java, "name.db"
////                    )
////                        .fallbackToDestructiveMigration()
////                        .addCallback(object : RoomDatabase.Callback() {
////
////                            override fun onOpen(db: SupportSQLiteDatabase) {
////                                super.onOpen(db)
////                               // PopulateDbAsync(INSTANCE).execute()
////                            }
////                        })
////                        .build()
////                }
////            }
////            return INSTANCE
////        }
////    }
//
//}