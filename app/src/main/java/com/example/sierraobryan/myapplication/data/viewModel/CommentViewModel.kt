package com.example.sierraobryan.myapplication.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sierraobryan.myapplication.data.model.ApiResponse
import com.example.sierraobryan.myapplication.data.model.Comment
import com.example.sierraobryan.myapplication.data.repository.CommentRespository
import com.example.sierraobryan.myapplication.network.APIClient
import com.example.sierraobryan.myapplication.network.HireMeService
import retrofit2.Response

class CommentViewModel(application: Application) : AndroidViewModel(application) {

    private val commentRespository: CommentRespository
    private val service: HireMeService
    internal var loadedFromDataBase: Boolean = false
    internal val comments: LiveData<ApiResponse<List<Comment>>>

    init {

        commentRespository = CommentRespository(application)
        service = APIClient.create()
        if (commentRespository.getAll().isNotEmpty()) {
            comments = MutableLiveData<ApiResponse<List<Comment>>> ()
            comments.value = ApiResponse.create(Response.success(commentRespository.getAll())
            )
            loadedFromDataBase = true
        } else {
            comments = service.getComments()
        }
    }

    internal fun insert(comment: Comment) {
        commentRespository.insert(comment)
    }

    internal fun insert(comments: List<Comment>) {
        commentRespository.insertAll(comments)
    }

    val commentsList: MutableLiveData<MutableList<Comment>> = MutableLiveData()

    val currentId: MutableLiveData<Int> = MutableLiveData()

    internal fun getCommentsList(): LiveData<MutableList<Comment>> = commentsList

    internal fun getCurrentId(): LiveData<Int> = currentId
}