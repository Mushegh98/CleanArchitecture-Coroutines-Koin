package com.test.myapplication.remotedatasource

import com.test.myapplication.datamapper.PostDataMapper
import com.test.myapplication.network.Post
import com.test.myapplication.network.Resource

class PostRemoteDataSource(private val postDataMapper: PostDataMapper) {

    suspend fun getPosts() : Resource<List<Post>> {
        return postDataMapper.getPosts()
    }

}