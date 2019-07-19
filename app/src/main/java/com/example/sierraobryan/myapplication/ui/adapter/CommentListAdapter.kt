package com.example.sierraobryan.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.Comment
import kotlinx.android.synthetic.main.item_row_comment.view.*

class CommentListAdapter (val items: List<Comment>, val context: Context) :
        RecyclerView.Adapter<CommentListAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_row_comment, parent, false)
        return CommentListAdapter.CommentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bindingValues(context, items.get(position))
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindingValues(context: Context,
            comment: Comment) {
            itemView.name.text = comment.name
            itemView.date.text = comment.date
            itemView.comment.text = comment.body
            setHearts(context, comment.rating)

        }

        private fun setHearts(context: Context, rating: Int) {
            when (rating) {
                0 -> {
                    itemView.heart1.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart2.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart3.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart4.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart5.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                }
                1 -> {
                    itemView.heart1.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart2.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart3.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart4.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart5.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))

                }
                2 -> {
                    itemView.heart1.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart2.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart3.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart4.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart5.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                }
                3 -> {
                    itemView.heart1.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart2.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart3.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart4.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                    itemView.heart5.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                }
                4 -> {
                    itemView.heart1.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart2.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart3.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart4.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart5.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_border_black_24dp))

                }
                5 -> {
                    itemView.heart1.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart2.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart3.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart4.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))
                    itemView.heart5.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp))

                }
            }
        }

    }
}