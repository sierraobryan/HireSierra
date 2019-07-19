package com.example.sierraobryan.myapplication.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sierraobryan.myapplication.data.model.Reason
import com.example.sierraobryan.myapplication.network.APIClient

class ReasonViewModel : ViewModel() {
    val service = APIClient.create()
    val reasons = service.getReasons()

    val reasonsList: MutableLiveData<List<Reason>> = MutableLiveData()

    val currentId: MutableLiveData<Int> = MutableLiveData()

    internal fun getReasonList(): LiveData<List<Reason>> = reasonsList

    internal fun getCurrentId(): LiveData<Int> = currentId
}