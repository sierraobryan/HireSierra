package com.example.sierraobryan.myapplication.ui.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.model.Reason
import com.example.sierraobryan.myapplication.data.viewModel.ReasonViewModel
import com.example.sierraobryan.myapplication.ui.activity.BaseActivity
import com.example.sierraobryan.myapplication.ui.fragment.ExampleListFragment
import com.example.sierraobryan.myapplication.ui.fragment.ReasonListFragment
import kotlinx.android.synthetic.main.item_row_reason.view.*
import java.time.LocalDateTime

class ReasonsListAdapter(val items: List<Reason>, val fragment: ReasonListFragment, val viewModel: ReasonViewModel):
    RecyclerView.Adapter<ReasonsListAdapter.ReasonsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReasonsViewHolder {
        val view: View = LayoutInflater.from(fragment.activity).inflate(R.layout.item_row_reason, parent, false)
        return ReasonsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReasonsViewHolder, position: Int) {
        holder.bindingValues(fragment, viewModel, items.get(position))
    }


    override fun getItemCount(): Int {
        return items.size
    }


    class ReasonsViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bindingValues(fragment: ReasonListFragment,
                          viewModel: ReasonViewModel,
                          reason: Reason) {
            itemView.title.text = reason.title
            itemView.description.text = reason.description
            itemView.example_1.text = "- " + reason.examples[0].title
            itemView.example_2.text = "- " + reason.examples[1].title
            setUpImages(fragment.activity!!, itemView, reason.id)

            itemView.more.setOnClickListener {
                viewModel.currentId.value = reason.id
                (fragment.activity as BaseActivity).captureAnalytics(
                        fragment.activity!!,
                        fragment,
                        setUpAnalyticsMessage(reason.id)
                )
                val fm = (fragment.activity as AppCompatActivity).supportFragmentManager as FragmentManager
                    fm.beginTransaction()
                    .replace(R.id.container, ExampleListFragment.newInstance())
                        .addToBackStack(reason.title)
                    .commit()

            }

        }

        private fun setUpAnalyticsMessage(id:Int) : String {
            when (id) {
                1 -> {return "NAVIGATE_TO_EXPERIENCES"}
                2 -> {return "NAVIGATE_TO_LIBRARIES"}
                3 -> {return "NAVIGATE_TO_HILARIUS"}
                4 -> {return "NAVIGATE_TO_DIVERSITY"}
                5 -> {return "NAVIGATE_TO_LIKED"}
                6 -> {return "NAVIGATE_TO_OPINIONATED"}
            }
            return ""
        }

        private fun setUpImages(context: Activity, itemView: View , id: Int) {
            when (id) {
                1 -> {itemView.icon.setImageDrawable(
                    context.getDrawable(R.drawable.ic_developer_mode_black_24dp))}
                2 -> {itemView.icon.setImageDrawable(
                    context.getDrawable(R.drawable.ic_school_black_24dp))}
                3 -> {itemView.icon.setImageDrawable(
                    context.getDrawable(R.drawable.ic_sentiment_very_satisfied_black_24dp))}
                4 -> {itemView.icon.setImageDrawable(
                    context.getDrawable(R.drawable.ic_wc_black_24dp))}
                5 -> {itemView.icon.setImageDrawable(
                    context.getDrawable(R.drawable.ic_people_black_24dp))}
                6 -> {itemView.icon.setImageDrawable(
                    context.getDrawable(R.drawable.ic_record_voice_over_black_24dp))}
            }

        }

    }

}