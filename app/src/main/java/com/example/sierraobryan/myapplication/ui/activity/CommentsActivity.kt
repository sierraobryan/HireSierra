package com.example.sierraobryan.myapplication.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.viewModel.CommentViewModel
import com.example.sierraobryan.myapplication.ui.fragment.CommentAddFragment
import com.example.sierraobryan.myapplication.ui.fragment.CommentListFragment
import com.example.sierraobryan.myapplication.ui.fragment.ErrorFragment

class CommentsActivity : BaseActivity() {

    private lateinit var viewModel: CommentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reasons)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CommentListFragment.newInstance())
                .commitNow()
        }

        title = getString(R.string.what_people_are_saying_about_sierra)

        viewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)


    }

    override fun onBackPressed() {
        var fragment: Fragment = supportFragmentManager.findFragmentById(R.id.container)!!
        if (fragment is CommentAddFragment) {
            captureAnalytics(this,
                fragment,  "CANCEL_ADD_COMMENT")
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CommentListFragment.newInstance())
                .commitNow()
        } else if (fragment is CommentListFragment) {
            captureAnalytics(this,
                fragment,  "CLOSE_COMMENTS_ACTIVITY")
            finish()
        } else if (fragment is ErrorFragment) {
            finish()
        }
        super.onBackPressed()
    }


}

