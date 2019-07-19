package com.example.sierraobryan.myapplication.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.ui.fragment.AnalyticsFragment
import kotlinx.android.synthetic.main.activity_analytics.*
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.sierraobryan.myapplication.data.viewModel.ImprovementsViewModel
import com.example.sierraobryan.myapplication.ui.adapter.AnalyticsAndImprovementsPagerAdapter
import com.google.android.material.tabs.TabLayout


class AnalyticsActivity :BaseActivity() {

    private lateinit var viewModel: ImprovementsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analytics)

        setSupportActionBar(toolbar)
       title = getString(R.string.other_useful)

        val fragmentAdapter = AnalyticsAndImprovementsPagerAdapter(supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.viewpager_main)
        val tabs = findViewById<TabLayout>(R.id.tabs_main)
        viewPager.adapter = fragmentAdapter

        viewModel = ViewModelProviders.of(this).get(ImprovementsViewModel::class.java)

        tabs.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.clear_all -> {
                val builder = AlertDialog.Builder(this)
                builder.setMessage(getString(R.string.are_you_sure))
                builder.setCancelable(true)
                builder.setPositiveButton(
                        getString(R.string.yes),
                    {_, _ -> analyticsViewModel.deleteAll() })

                builder.setNegativeButton(
                    getString(R.string.cancel), { dialogInterface, _ -> dialogInterface.cancel() })

                val alertDialog = builder.create()
                alertDialog.show()
             return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}