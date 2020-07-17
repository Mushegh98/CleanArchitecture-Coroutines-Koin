package com.test.myapplication.datamapper

import com.test.myapplication.network.Post
import com.test.myapplication.network.Resource
import com.test.myapplication.network.SafeApiRequest
import kotlinx.coroutines.Dispatchers
import net.simplifiedcoding.data.network.PostsApi

class PostDataMapper(private val api : PostsApi) : SafeApiRequest() {

    suspend fun getPosts() : Resource<List<Post>>{
        return createSafeCall(Dispatchers.IO){api.getPosts()}
    }

}