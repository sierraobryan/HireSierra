package com.example.sierraobryan.myapplication.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.ApiErrorResponse
import com.example.sierraobryan.myapplication.data.model.ApiSuccessResponse
import com.example.sierraobryan.myapplication.data.model.Comment
import com.example.sierraobryan.myapplication.data.model.Reason
import com.example.sierraobryan.myapplication.data.viewModel.ImprovementsViewModel
import com.example.sierraobryan.myapplication.data.viewModel.ReasonViewModel
import com.example.sierraobryan.myapplication.ui.activity.BaseActivity
import com.example.sierraobryan.myapplication.ui.adapter.ImprovementsAdapter
import com.example.sierraobryan.myapplication.ui.adapter.ReasonsListAdapter
import kotlinx.android.synthetic.main.fragment_improvments.*
import kotlinx.android.synthetic.main.fragment_reason_list.*

class ImprovementsFragment : Fragment() {

    private lateinit var viewModel: ImprovementsViewModel
    private lateinit var adapter: ImprovementsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_improvments, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(ImprovementsViewModel::class.java)
        viewModel.improvments.observe(this, Observer { response ->
            if (response is ApiSuccessResponse) {
                setUpAdapter(response.body)
            } else if (response is ApiErrorResponse) {
                val fm = (context as AppCompatActivity).supportFragmentManager as FragmentManager
                (activity as BaseActivity).captureAnalytics(
                    activity!!,
                    this,
                    "ERROR_FRAGMENT_SHOWS"
                )
                fm.beginTransaction()
                    .replace(R.id.container, ErrorFragment.newInstance())
                    .addToBackStack(ErrorFragment::class.java.simpleName)
                    .commit()
            }
        })
    }

    private fun setUpAdapter(reasons: List<Comment>) {
        adapter = ImprovementsAdapter(reasons, activity as Context)
        rvImprovements.adapter = adapter
        rvImprovements.layoutManager = LinearLayoutManager(activity)
        adapter.notifyDataSetChanged()
    }
}