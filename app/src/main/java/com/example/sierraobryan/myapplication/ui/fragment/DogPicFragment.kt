package com.example.sierraobryan.myapplication.ui.fragment

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.model.ApiSuccessResponse
import com.example.sierraobryan.myapplication.data.viewModel.UselessAPIResponseViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_dialog_image.*

class DogPicFragment : DialogFragment() {

    private lateinit var uselessViewModel: UselessAPIResponseViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val alertDialog = AlertDialog.Builder(activity as Context)
        val view : View = (activity as AppCompatActivity).layoutInflater.inflate(R.layout.fragment_dialog_image, null)
        val layout = view.findViewById<LinearLayout>(R.id.dialog_layout_image)
        val image = view.findViewById<View>(R.id.image_dialog)
        val text = view.findViewById<TextView>(R.id.text)
        alertDialog.setView(layout)
        alertDialog.setTitle(getString(R.string.dog_pic).toUpperCase())
        uselessViewModel = ViewModelProviders.of(this).get(UselessAPIResponseViewModel::class.java)

        uselessViewModel.dogPic.observe(this, Observer {
            if (it is ApiSuccessResponse) {
                Picasso.get().load(it.body.message).into(image as ImageView)
                text.visibility = View.GONE
                image.visibility = View.VISIBLE
            } else {
                text.visibility = View.VISIBLE
                image.visibility = View.GONE
                text.text = getString(R.string.doh)
            }
        })

        alertDialog.setPositiveButton(getString(R.string.okay).toUpperCase(),{ dialog, _ -> dialog.cancel() })

        return alertDialog.create()
    }
}