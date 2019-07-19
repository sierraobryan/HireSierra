package com.example.sierraobryan.myapplication.data.viewModel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PDFViewModel : ViewModel() {

    var pdfBitmap: MutableLiveData<List<Bitmap>> = MutableLiveData()
    var isLoaded: MutableLiveData<Boolean> = MutableLiveData()

    internal fun getPDFBitMaps(): LiveData<List<Bitmap>> = pdfBitmap
    internal fun getIsLoaded(): MutableLiveData<Boolean> = isLoaded
}