package com.example.sierraobryan.myapplication.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.Example
import com.example.sierraobryan.myapplication.data.viewModel.ReasonViewModel
import com.example.sierraobryan.myapplication.data.viewModel.UselessAPIResponseViewModel
import com.example.sierraobryan.myapplication.ui.adapter.ExampleListAdapter
import kotlinx.android.synthetic.main.fragment_examples_list.*
import android.content.DialogInterface
import android.app.AlertDialog
import com.example.sierraobryan.myapplication.data.model.ApiSuccessResponse


class ExampleListFragment : Fragment() {

    companion object {
        fun newInstance() = ExampleListFragment()
    }

    private lateinit var viewModel: ReasonViewModel
    private lateinit var adapter: ExampleListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_examples_list, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(ReasonViewModel::class.java)
        viewModel.currentId.observe(this, Observer { response ->
            activity!!.title = viewModel.reasonsList.value!![response - 1].title
            setUpAdapter(viewModel.reasonsList.value!![response - 1].examples)
        })

    }

    private fun setUpAdapter(example: List<Example>) {
        adapter = ExampleListAdapter(example, this)
        rvExamples.adapter = adapter
        rvExamples.layoutManager = LinearLayoutManager(activity)
        adapter.notifyDataSetChanged()
    }
}
