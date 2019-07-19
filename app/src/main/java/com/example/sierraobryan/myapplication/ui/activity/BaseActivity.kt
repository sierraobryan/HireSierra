package com.example.sierraobryan.myapplication.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.viewModel.AnalyticsViewModel
import java.time.LocalDateTime

open class BaseActivity : AppCompatActivity() {

    lateinit var analyticsViewModel: AnalyticsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        analyticsViewModel = ViewModelProviders.of(this).get(AnalyticsViewModel::class.java)

    }

    fun captureAnalytics(activityName: Activity, fragmentName: Fragment?, actionName: String) {
        val fragmentNameString = if (fragmentName == null ) "" else fragmentName::class.java.simpleName
        analyticsViewModel.insert(
            AnalyticObject(
                activityName::class.java.simpleName, fragmentNameString, actionName,
                LocalDateTime.now().toString())
        )
    }

}