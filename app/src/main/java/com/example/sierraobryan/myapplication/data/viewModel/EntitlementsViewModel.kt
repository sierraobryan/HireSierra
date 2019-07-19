package com.example.sierraobryan.myapplication.data.viewModel

import androidx.lifecycle.ViewModel
import com.example.sierraobryan.myapplication.network.APIClient
import com.example.sierraobryan.myapplication.network.HireMeService

class EntitlementsViewModel: ViewModel() {
    val service = APIClient.create()
    val entitlements = service.getEntitlements()
}