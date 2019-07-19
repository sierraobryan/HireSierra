package com.example.sierraobryan.myapplication.data.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.sierraobryan.myapplication.data.dao.AnalyticsDao
import com.example.sierraobryan.myapplication.data.dataBase.AnalyticsDatabase
import com.example.sierraobryan.myapplication.data.model.AnalyticObject

class AnalyticsRepository(application: Application) {

    private val analyticsDao: AnalyticsDao
    private var analyticsData: LiveData<List<AnalyticObject>>

    init {
        val db = AnalyticsDatabase.getInstance(application)
        analyticsDao = db?.analyticsDao()!!
        analyticsData = analyticsDao.getAll()
    }

    fun getAllAnalytics(): LiveData<List<AnalyticObject>> {
        return analyticsData
    }

    fun insert(analyticObject: AnalyticObject) {
        insertAsyncTask(analyticsDao).execute(analyticObject)
    }

    fun deleteAll() {
        deleteAllAsyncTask(analyticsDao).execute()
    }

    private class deleteAllAsyncTask internal constructor(private val asyncDao: AnalyticsDao) :
        AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg p0: Void?): Void? {
            asyncDao.deleteAll()
            return null
        }

    }

    private class insertAsyncTask internal constructor(private val asyncDao: AnalyticsDao) :
            AsyncTask<AnalyticObject, Void, Void>() {

        override fun doInBackground(vararg params: AnalyticObject): Void? {
            asyncDao.insert(params[0])
            return null
        }
    }

}