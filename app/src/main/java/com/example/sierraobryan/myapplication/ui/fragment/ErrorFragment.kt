package com.example.sierraobryan.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.viewModel.CommentViewModel
import com.example.sierraobryan.myapplication.ui.adapter.CommentListAdapter

class ErrorFragment : Fragment() {

    companion object {
        fun newInstance() = ErrorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_error, container, false)
        return view
    }
}
