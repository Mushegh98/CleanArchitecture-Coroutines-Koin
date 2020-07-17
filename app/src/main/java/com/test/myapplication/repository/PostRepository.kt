package com.test.myapplication.repository

import com.test.myapplication.localdatasource.PostLocalDataSource
import com.test.myapplication.network.Post
import com.test.myapplication.network.Resource
import com.test.myapplication.remotedatasource.PostRemoteDataSource


class PostRepository(private val postRemoteDataSource: PostRemoteDataSource , private val postLocalDataSource: PostLocalDataSource) {

    suspend fun getPosts() : Resource<List<Post>> {
        return postRemoteDataSource.getPosts()
    }

    fun setPosts(post : String){
        postLocalDataSource.setPosts(post)
    }

    fun getPost() : String?{
        return postLocalDataSource.getPosts()
    }

}