package com.example.sierraobryan.myapplication.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.sierraobryan.myapplication.R
import com.example.sierraobryan.myapplication.data.viewModel.PDFViewModel
import android.os.Handler
import android.widget.Toast
import es.voghdev.pdfviewpager.library.PDFViewPager
import java.io.File
import es.voghdev.pdfviewpager.library.asset.CopyAsset
import es.voghdev.pdfviewpager.library.asset.CopyAssetThreadImpl


class ResumeActivity : BaseActivity(), CopyAsset.Listener {

    private lateinit var pdfViewModel: PDFViewModel
    private lateinit var pdfViewPager: PDFViewPager
    private val FILENAME = "sample.pdf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)

        title = getString(R.string.check_out_resume)

        pdfViewModel = ViewModelProviders.of(this).get(PDFViewModel::class.java)

        val copyAsset = CopyAssetThreadImpl(this, Handler())
        copyAsset.copy(FILENAME, File(cacheDir, FILENAME).absolutePath)


    }

    override fun success(assetName: String?, destinationPath: String?) {
        pdfViewPager = PDFViewPager(this, FILENAME)

        setContentView(pdfViewPager)
    }

    override fun failure(e: Exception?) {
        Toast.makeText(this, getString(R.string.doh), Toast.LENGTH_LONG).show()
    }




}