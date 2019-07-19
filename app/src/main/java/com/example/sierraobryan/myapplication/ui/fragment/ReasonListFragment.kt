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
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.model.ApiErrorResponse
import com.example.sierraobryan.myapplication.data.model.ApiSuccessResponse
import com.example.sierraobryan.myapplication.data.model.Reason
import com.example.sierraobryan.myapplication.data.viewModel.ReasonViewModel
import com.example.sierraobryan.myapplication.ui.activity.BaseActivity
import com.example.sierraobryan.myapplication.ui.adapter.ReasonsListAdapter
import kotlinx.android.synthetic.main.fragment_reason_list.*
import java.time.LocalDateTime

class ReasonListFragment : Fragment() {

        companion object {
            fun newInstance() = ReasonListFragment()
        }

    private lateinit var viewModel: ReasonViewModel
    private lateinit var adapter: ReasonsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_reason_list, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity!!.title = activity!!.getString(R.string.reasons_to_hire)
        viewModel = ViewModelProviders.of(activity!!).get(ReasonViewModel::class.java)
        viewModel.reasons.observe(this, Observer { response ->
            if (response is ApiSuccessResponse) {
                viewModel.reasonsList.value = response.body
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

        viewModel.getReasonList().observe(this, Observer { it -> setUpAdapter(it) })
    }

    private fun setUpAdapter(reasons: List<Reason>) {
        adapter = ReasonsListAdapter(reasons, this, viewModel)
        rvReasons.adapter = adapter
        rvReasons.layoutManager = LinearLayoutManager(activity)
        adapter.notifyDataSetChanged()
    }
}