package com.example.sierraobryan.myapplication.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sierraobryan.myapplication.ui.fragment.AnalyticsFragment
import com.example.sierraobryan.myapplication.ui.fragment.ImprovementsFragment

class AnalyticsAndImprovementsPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AnalyticsFragment()
            1 -> ImprovementsFragment()
            else -> AnalyticsFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Analytics"
            1 -> "Improvements"
            else -> "Analytics"
        }
    }

}