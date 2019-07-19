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
import com.example.sierraobryan.myapplication.data.model.Comment
import com.example.sierraobryan.myapplication.data.viewModel.CommentViewModel
import com.example.sierraobryan.myapplication.ui.activity.BaseActivity
import com.example.sierraobryan.myapplication.ui.adapter.CommentListAdapter
import kotlinx.android.synthetic.main.fragment_comment_list.*
import java.time.LocalDateTime

class CommentListFragment : Fragment() {

    companion object {
        fun newInstance() = CommentListFragment()
    }

    private lateinit var viewModel: CommentViewModel
    private lateinit var adapter: CommentListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_comment_list, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity!!.title = activity!!.getString(R.string.what_people_are_saying_about_sierra)
        viewModel = ViewModelProviders.of(activity!!).get(CommentViewModel::class.java)
        viewModel.comments.observe(this, Observer { response ->
            if (response is ApiSuccessResponse) {
                setUpAdapter(response.body)
                viewModel.commentsList.value = response.body as MutableList<Comment>
                if (!viewModel.loadedFromDataBase) {
                    viewModel.insert(response.body)
                }
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

        action_a.setOnClickListener {
            val fm = (context as AppCompatActivity).supportFragmentManager as FragmentManager
            (activity as BaseActivity).captureAnalytics(
                    activity!!,
                    this,
                    "GO_FROM_COMMENT_LIST_FRAGMENT_TO_NEW_COMMENT_FRAGMENT"
            )
            fm.beginTransaction()
                .replace(R.id.container, CommentAddFragment.newInstance())
                .addToBackStack(CommentAddFragment::class.java.simpleName)
                .commit()
        }
        //viewModel.getReasonList().observe(this, Observer { it -> setUpAdapter(it) })
    }

    private fun setUpAdapter(comments: List<Comment>) {
        adapter = CommentListAdapter(comments, activity as Context)
        rvComments.adapter = adapter
        rvComments.layoutManager = LinearLayoutManager(activity)
        adapter.notifyDataSetChanged()
}
}

