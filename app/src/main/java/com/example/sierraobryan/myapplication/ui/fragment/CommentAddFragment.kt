package com.example.sierraobryan.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.model.Comment
import com.example.sierraobryan.myapplication.data.viewModel.CommentViewModel
import com.example.sierraobryan.myapplication.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.fragment_comment_add.*
import kotlinx.android.synthetic.main.item_row_comment.view.*
import java.time.LocalDateTime

class CommentAddFragment : Fragment() {

    companion object {
        fun newInstance() = CommentAddFragment()
    }

    private lateinit var commentViewModel: CommentViewModel
    private var rating: Int = 0

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val view = inflater.inflate(R.layout.fragment_comment_add, container, false)
            return view
        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity!!.title = activity!!.getString(R.string.share_the_love)

        commentViewModel = ViewModelProviders.of(activity!!).get(CommentViewModel::class.java)
        saveButton.setOnClickListener {
            saveInformation()
        }
        heart1.setOnClickListener { setHeart1OnClick(1) }
        heart2.setOnClickListener { setHeart1OnClick(2) }
        heart3.setOnClickListener { setHeart1OnClick(3) }
        heart4.setOnClickListener { setHeart1OnClick(4) }
        heart5.setOnClickListener { setHeart1OnClick(5) }

    }

    private fun saveInformation() {
        val newComment = Comment(
            reviewEditText.text.toString(),
            nameEditText.text.toString(),
            dateEditText.text.toString(),
            getRating(),
            1
        )
        commentViewModel.commentsList.value!!.add(newComment)
        commentViewModel.insert(newComment)
        (activity as BaseActivity).captureAnalytics(
                activity!!,
                this,
                "SAVE_NEW_REVIEW")
        val fm = (context as AppCompatActivity).supportFragmentManager as FragmentManager
        fm.beginTransaction()
            .replace(R.id.container, CommentListFragment.newInstance())
            .addToBackStack(CommentAddFragment::class.java.simpleName)
            .commit()
    }

    private fun getRating() : Int = rating

    private fun setHeart1OnClick(int: Int) {

        when (int) {
            0 -> {
                rating = 0
                heart1.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart2.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart3.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart4.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart5.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
            }
            1 -> {
                rating = 1
                heart1.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart2.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart3.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart4.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart5.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))

            }
            2 -> {
                rating = 2
                heart1.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart2.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart3.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart4.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart5.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
            }
            3 -> {
                rating = 3
                heart1.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart2.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart3.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart4.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
                heart5.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))
            }
            4 -> {
                rating = 4
                heart1.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart2.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart3.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart4.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart5.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_border_black_24dp))

            }
            5 -> {
                rating = 5
                heart1.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart2.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart3.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart4.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))
                heart5.setImageDrawable(activity!!.getDrawable(R.drawable.ic_favorite_black_24dp))

            }
        }

    }
}