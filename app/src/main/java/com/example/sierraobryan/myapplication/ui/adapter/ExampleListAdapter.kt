package com.example.sierraobryan.myapplication.ui.adapter

import com.example.sierraobryan.myapplication.data.model.Example
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sierraobryan.myapplication.R
import kotlinx.android.synthetic.main.item_row_example.view.*
import androidx.fragment.app.Fragment
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.ui.activity.BaseActivity
import com.example.sierraobryan.myapplication.ui.fragment.DogPicFragment
import com.example.sierraobryan.myapplication.ui.fragment.InsultFragment
import com.example.sierraobryan.myapplication.ui.fragment.TrumpQuoteFragment
import java.time.LocalDateTime


class ExampleListAdapter(val items: List<Example>, val fragment: Fragment):
    RecyclerView.Adapter<ExampleListAdapter.ExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view: View = LayoutInflater.from(fragment.context).inflate(R.layout.item_row_example, parent, false)
        return ExampleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.bindingValues(fragment, items.get(position))
    }


    override fun getItemCount(): Int {
        return items.size
    }


    class ExampleViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bindingValues(fragment: Fragment,
                          example: Example) {
            itemView.title.text = example.title
            if (example.description.length > 0) {
                itemView.description.visibility = View.VISIBLE
                itemView.description.text = example.description
            } else {
                itemView.description.visibility = View.GONE
            }
            if (example.comments.length > 0) {
                itemView.comment.visibility = View.VISIBLE
                itemView.comment.text = example.comments
            } else {
                itemView.comment.visibility = View.GONE
            }
            if (example.doesKnow == false) {
                itemView.icon.visibility = View.VISIBLE
                itemView.icon.setImageDrawable(fragment.context!!.getDrawable(R.drawable.ic_check_black_24dp))
            } else {
                itemView.icon.visibility = View.INVISIBLE
            }
            if (example.examples.length > 0) {
                itemView.examples.visibility = View.VISIBLE
                itemView.examples.text = example.examples
            } else {
                itemView.examples.visibility = View.GONE
            }

            if (example.url.length > 0) {
                itemView.more.visibility = View.VISIBLE
            } else {
                itemView.more.visibility = View.GONE
            }

            itemView.more.setOnClickListener{
                when(example.id) {
                    3 -> {
                        (fragment.activity as BaseActivity).captureAnalytics(
                                fragment.activity!!,
                                fragment,
                                "SHOW_TRUMP_DIALOG_FRAGMENT"
                        )
                        val dialog = TrumpQuoteFragment()
                        dialog.setTargetFragment(fragment, example.id)
                        dialog.show((fragment.context as AppCompatActivity).supportFragmentManager,
                            TrumpQuoteFragment::class.java.simpleName)
                    }
                    2 -> {
                        (fragment.activity as BaseActivity).captureAnalytics(
                                fragment.activity!!,
                                fragment,
                                "SHOW_INSULT_DIALOG_FRAGMENT")
                        val dialog = InsultFragment()
                        dialog.setTargetFragment(fragment, example.id)
                        dialog.show((fragment.context as AppCompatActivity).supportFragmentManager,
                            InsultFragment::class.java.simpleName)

                    }
                    4 -> {
                        (fragment.activity as BaseActivity).captureAnalytics(
                                fragment.activity!!,
                                fragment,
                                "SHOW_DOG_PIC_DIALOG_FRAGMENT")
                        val dialog = DogPicFragment()
                        dialog.setTargetFragment(fragment, example.id)
                        dialog.show((fragment.context as AppCompatActivity).supportFragmentManager,
                            DogPicFragment::class.java.simpleName)


                    }

                }
            }


        }

    }

}