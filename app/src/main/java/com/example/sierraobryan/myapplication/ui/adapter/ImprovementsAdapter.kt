package com.example.sierraobryan.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.Comment
import kotlinx.android.synthetic.main.item_row_improvement.view.*

class ImprovementsAdapter (val items: List<Comment>, val context: Context) :
    RecyclerView.Adapter<ImprovementsAdapter.ImprovementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImprovementViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_row_improvement, parent, false)
        return ImprovementsAdapter.ImprovementViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ImprovementViewHolder, position: Int) {
        holder.bindingValues(items.get(position))
    }

    class ImprovementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindingValues(
                          comment: Comment
        ) {
            itemView.name.text = comment.name
            itemView.body.text = comment.body

        }


    }
}