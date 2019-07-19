package com.example.sierraobryan.myapplication.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.repository.AnalyticsRepository


class AnalyticsViewModel(application: Application) : AndroidViewModel(application) {

    private var analyticsRepository: AnalyticsRepository
    internal var allAnalyticObjects: LiveData<List<AnalyticObject>>

    init {
        analyticsRepository = AnalyticsRepository(application)
        allAnalyticObjects = analyticsRepository.getAllAnalytics()
    }

    fun getAllAnalytics() : LiveData<List<AnalyticObject>> {
        return allAnalyticObjects
    }

    fun insert(analyticObject: AnalyticObject) {
        analyticsRepository.insert(analyticObject)
    }

    fun deleteAll() {
        analyticsRepository.deleteAll()
    }

}