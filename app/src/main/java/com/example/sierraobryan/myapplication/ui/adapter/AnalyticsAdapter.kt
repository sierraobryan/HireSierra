package com.example.sierraobryan.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.model.Comment
import kotlinx.android.synthetic.main.item_row_analytics.view.*

class AnalyticsAdapter (val items: List<AnalyticObject>, val context: Context) :
    RecyclerView.Adapter<AnalyticsAdapter.AnalyticsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalyticsAdapter.AnalyticsViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_row_analytics, parent, false)
        return AnalyticsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AnalyticsViewHolder, position: Int) {
        holder.bindingValues(items.get(position))
    }
    class AnalyticsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindingValues(analyticObject: AnalyticObject){
            itemView.date.text = analyticObject.date.toString()
            itemView.activityName.text = "Activity Name: " + analyticObject.activityName
            itemView.fragmentName.text = "Fragment Name: " + analyticObject.fragmentName
            itemView.action.text = "Action Key: " + analyticObject.action


    }
    }
}

