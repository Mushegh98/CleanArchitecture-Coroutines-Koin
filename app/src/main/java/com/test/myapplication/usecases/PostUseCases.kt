package com.test.myapplication.usecases

import com.test.myapplication.network.Post
import com.test.myapplication.network.Resource
import com.test.myapplication.repository.PostRepository

class PostUseCases(private val postRepository: PostRepository) {

    suspend fun getPosts() : Resource<List<Post>> {
        return postRepository.getPosts()
    }

    fun setPosts(post : String){
        postRepository.setPosts(post)
    }

    fun getPost() : String?{
        return postRepository.getPost()
    }
}