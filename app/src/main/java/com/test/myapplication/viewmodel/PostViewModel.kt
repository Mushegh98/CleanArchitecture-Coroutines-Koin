package com.test.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.myapplication.network.NetworkBoundResource
import com.test.myapplication.network.Post
import com.test.myapplication.network.Resource
import com.test.myapplication.usecases.PostUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel(private val postUseCases: PostUseCases) : ViewModel() {

    fun getPosts() : MutableLiveData<Resource<List<Post>?>> {
        return object : NetworkBoundResource<List<Post>>(){
            override fun createCall() {
                viewModelScope.launch {
                    val data = postUseCases.getPosts()
                    withContext(Dispatchers.Main){setValue(data)}
                }
            }

        }.asMutableLiveData()
    }

    fun setPosts(post : String){
        postUseCases.setPosts(post)
    }

    fun getPost() : String?{
        return postUseCases.getPost()
    }

}