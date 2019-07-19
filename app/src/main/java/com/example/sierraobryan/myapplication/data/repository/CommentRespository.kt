package com.example.sierraobryan.myapplication.data.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.sierraobryan.myapplication.data.dao.AnalyticsDao
import com.example.sierraobryan.myapplication.data.dao.CommentsDao
import com.example.sierraobryan.myapplication.data.dataBase.CommentDataBase
import com.example.sierraobryan.myapplication.data.model.AnalyticObject
import com.example.sierraobryan.myapplication.data.model.Comment

class CommentRespository(application: Application) {

    private val dao: CommentsDao
    private val data: List<Comment>

    init {
        val db = CommentDataBase.getInstance(application)
        dao = db?.commentDao()!!
        data = dao.getAllComments()
    }

    fun getAll(): List<Comment> {
        return data
    }

    fun insert(comment: Comment) {
        insertAsyncTask(dao).execute(comment)
    }

    fun insertAll(comments: List<Comment>) {
        insertAllAsyncTask(dao).execute(comments)
    }

    private class insertAsyncTask internal constructor(private val dao: CommentsDao) :
        AsyncTask<Comment, Void, Void>() {

        override fun doInBackground(vararg params: Comment): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class insertAllAsyncTask internal constructor(private val dao: CommentsDao) :
        AsyncTask<List<Comment>, Void, Void>() {

        override fun doInBackground(vararg params: List<Comment>): Void? {
            dao.insert(params[0])
            return null
        }
    }

}
