package com.example.sierraobryan.myapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.model.ApiSuccessResponse
import com.example.sierraobryan.myapplication.data.viewModel.EntitlementsViewModel

import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime

class MainActivity : BaseActivity() {

    private lateinit var entitlementsViewModel: EntitlementsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        captureAnalytics(this, null, "OPEN_APP")

        entitlementsViewModel = ViewModelProviders.of(this).get(EntitlementsViewModel::class.java)

        entitlementsViewModel.entitlements.observe(this, Observer {
            if (it is ApiSuccessResponse) {
                for (i in it.body) {
                    if (i.name == "reasons") {
                        if (i.show) action_a.visibility = View.VISIBLE else action_a.visibility = View.GONE
                    } else if (i.name == "comments") {
                        if (i.show) action_b.visibility = View.VISIBLE else action_b.visibility = View.GONE
                    }
                }
            } else {
                action_a.visibility = View.GONE
                action_b.visibility = View.GONE
            }
        })

        action_a.setOnClickListener{onClickA()}
        action_b.setOnClickListener{onClickB()}
        action_c.setOnClickListener {onClickC() } 
        action_d.setOnClickListener { onClickD() }

    }

    private fun onClickA() {
        multiple_actions.collapse()
        val intent = Intent(this, ReasonActivity::class.java)
        captureAnalytics(this,
            null, "GO_FROM_MAIN_TO_ANALYTICS")
        startActivity(intent)
    }

    private fun onClickB() {
        multiple_actions.collapse()
        val intent = Intent(this, CommentsActivity::class.java)
        captureAnalytics(this,
            null,
            "GO_FROM_MAIN_TO_REVIEWS_LIST")
        startActivity(intent)
    }

    private fun onClickC() {
        multiple_actions.collapse()
        val intent = Intent(this, AnalyticsActivity::class.java)
        captureAnalytics(
            this,
            null,
            "GO_FROM_MAIN_TO_ANALYTICS")
        startActivity(intent)
    }

    private fun onClickD() {
        multiple_actions.collapse()
        val intent = Intent(this, ResumeActivity::class.java)
        captureAnalytics(
            this,
            null,
            "GO_FROM_MAIN_TO_RESUME")
        startActivity(intent)
    }


    override fun onDestroy() {
        captureAnalytics(this, null,  "CLOSE_APP")
        super.onDestroy()
    }
}
