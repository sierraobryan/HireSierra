package com.example.sierraobryan.myapplication.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sierraobryan.myapplication.data.model.ApiResponse
import com.example.sierraobryan.myapplication.data.model.Quote
import com.example.sierraobryan.myapplication.network.APIClient
import com.example.sierraobryan.myapplication.network.UselessAPIClient

class UselessAPIResponseViewModel : ViewModel() {
    val service = UselessAPIClient.create()
    var trumpQuote = service.getQuote()
    var dogPic = service.getDogPic()
    var insult = service.getInsult()

}