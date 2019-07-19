package com.example.sierraobryan.myapplication.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.viewModel.ReasonViewModel
import com.example.sierraobryan.myapplication.ui.fragment.ErrorFragment
import com.example.sierraobryan.myapplication.ui.fragment.ExampleListFragment
import com.example.sierraobryan.myapplication.ui.fragment.ReasonListFragment

class ReasonActivity : BaseActivity() {

    private lateinit var viewModel: ReasonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reasons)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ReasonListFragment.newInstance())
                .commitNow()
        }

        viewModel = ViewModelProviders.of(this).get(ReasonViewModel::class.java)


    }

    override fun onBackPressed() {
        var fragment: Fragment = supportFragmentManager.findFragmentById(R.id.container)!!
        if (fragment is ExampleListFragment) {
            captureAnalytics(this, fragment, "CLOSE_SPECIFIC_EXAMPLE")
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ReasonListFragment.newInstance())
                .commitNow()
        } else if (fragment is ReasonListFragment) {
            captureAnalytics(this, fragment, "CLOSE_REASON_ACTIVITY")
            finish()
        } else if (fragment is ErrorFragment) {
            finish()
        }
        super.onBackPressed()
    }


}