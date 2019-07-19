package com.example.sierraobryan.myapplication.ui.fragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
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

class InsultFragment : DialogFragment() {

    private lateinit var uselessViewModel: UselessAPIResponseViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val alertDialog = AlertDialog.Builder(activity as Context)
        val view : View = (activity as AppCompatActivity).layoutInflater.inflate(R.layout.fragment_dialog, null)
        val text = view.findViewById<TextView>(R.id.text)
        val layout = view.findViewById<LinearLayout>(R.id.dialog_layout)
        alertDialog.setView(layout)
        alertDialog.setTitle(getString(R.string.insult).toUpperCase())
        uselessViewModel = ViewModelProviders.of(this).get(UselessAPIResponseViewModel::class.java)

        uselessViewModel.insult.observe(this, Observer {
            if (it is ApiSuccessResponse) {
                text.text = (it).body.insult
            } else {
                text.text = getString(R.string.doh)
            }
        })

        alertDialog.setPositiveButton(getString(R.string.okay).toUpperCase(), { dialog, _ -> dialog.cancel() })

        return alertDialog.create()
    }

}

