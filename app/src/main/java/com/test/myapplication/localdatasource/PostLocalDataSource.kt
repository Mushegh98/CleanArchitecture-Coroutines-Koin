package com.test.myapplication.localdatasource


class PostLocalDataSource(private val postDataStore : PostDataStore) {

    fun setPosts(post : String){
        postDataStore.setPosts(post)
    }

    fun getPosts() : String?{
      return  postDataStore.getPosts()
    }

}