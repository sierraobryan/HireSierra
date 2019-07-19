package com.example.sierraobryan.myapplication.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.model.Reason
import com.example.sierraobryan.myapplication.data.viewModel.AnalyticsViewModel
import com.example.sierraobryan.myapplication.data.viewModel.ReasonViewModel
import com.example.sierraobryan.myapplication.ui.activity.BaseActivity
import com.example.sierraobryan.myapplication.ui.adapter.AnalyticsAdapter
import com.example.sierraobryan.myapplication.ui.adapter.ReasonsListAdapter
import kotlinx.android.synthetic.main.fragment_analytics_list.*
import kotlinx.android.synthetic.main.fragment_reason_list.*

class AnalyticsFragment : Fragment() {

    companion object {
        fun newInstance() = AnalyticsFragment()
    }


    private lateinit var viewModel: AnalyticsViewModel
    private lateinit var adapter:AnalyticsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_analytics_list, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = (activity as BaseActivity).analyticsViewModel
        viewModel.allAnalyticObjects.observe(this, Observer { setUpAdapter(it) })
    }

    private fun setUpAdapter(analytics: List<AnalyticObject>) {
        adapter = AnalyticsAdapter(analytics, context as Context)
        rvAnalytics.adapter = adapter
        rvAnalytics.layoutManager = LinearLayoutManager(activity)
        adapter.notifyDataSetChanged()
    }
}