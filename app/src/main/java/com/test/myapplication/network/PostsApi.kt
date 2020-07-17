package net.simplifiedcoding.data.network

import com.test.myapplication.network.Post
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PostsApi {

    @GET("posts")
    suspend fun getPosts() : Response<List<Post>>


    companion object{
        operator fun invoke() : PostsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
                .create(PostsApi::class.java)
        }
    }
}
