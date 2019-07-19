package com.example.sierraobryan.myapplication.data.viewModel

import androidx.lifecycle.ViewModel
import com.example.sierraobryan.myapplication.network.APIClient

class ImprovementsViewModel : ViewModel() {
    val service = APIClient.create()
    val improvments = service.getImprovements()
}
