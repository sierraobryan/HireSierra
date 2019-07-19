//package com.example.sierraobryan.myapplication.data.repository
//
//import android.app.Application
//import androidx.lifecycle.LiveData
//import com.example.sierraobryan.myapplication.data.dao.ReasonDao
//import com.example.sierraobryan.myapplication.data.dataBase.ReasonDatabase
//import com.example.sierraobryan.myapplication.data.model.ApiResponse
//import com.example.sierraobryan.myapplication.data.model.Reason
//import com.example.sierraobryan.myapplication.network.APIClient
//import com.example.sierraobryan.myapplication.network.HireMeService
//
//class ReasonRepository(application: Application) {
//
//    private val reasonDao: ReasonDao
//    private val reasonLiveData: LiveData<List<Reason>>
//    private val reasonService: HireMeService
//
//    init {
//        val reasonDatabase = ReasonDatabase.getInstance(application)
//        reasonService = APIClient.create()
//        reasonDao = reasonDatabase?.reasonDao()!!
//        reasonLiveData = reasonDao.getAllReasons()
//    }
//
//    fun getAllReasons(): LiveData<List<Reason>> {
//        return reasonLiveData
//    }
//
//
//}