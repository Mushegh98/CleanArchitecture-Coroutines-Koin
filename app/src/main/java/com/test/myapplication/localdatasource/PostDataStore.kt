package com.test.myapplication.localdatasource

import android.content.Context
import android.content.SharedPreferences

class PostDataStore(private val context: Context) {

    private var sharedPreferences : SharedPreferences

    companion object{
        val POST_SHARED_PREF : String  = "com.test.myapplication.localdatasource.PostSharedPref"
        val POST_DATA_KEY : String  = "com.test.myapplication.localdatasource.PostDataKeySharedPref"
        val POST_DEFAULT_VALUE : String  = ""
    }

    init {
        sharedPreferences = context.getSharedPreferences(POST_SHARED_PREF, Context.MODE_PRIVATE)
    }

    fun setPosts(post : String){
        sharedPreferences.edit().putString(POST_DATA_KEY, post).apply();
    }

    fun getPosts() : String?{
        return sharedPreferences.getString(POST_DATA_KEY, POST_DEFAULT_VALUE)
    }
}