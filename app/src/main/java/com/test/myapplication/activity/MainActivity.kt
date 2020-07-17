package com.test.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.test.myapplication.R
import com.test.myapplication.databinding.ActivityMainBinding
import com.test.myapplication.network.Post
import com.test.myapplication.network.Status
import com.test.myapplication.viewmodel.PostViewModel
import org.koin.android.ext.android.get
import org.koin.core.context.KoinContextHandler.get

class MainActivity : AppCompatActivity() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var string : String = ""
        postViewModel = get<PostViewModel>()
        postViewModel.getPosts().observe(this, Observer {posts->
            when(posts.status){
                Status.SUCCESS->{
                    for (post : Post in posts.data!!){
                        string+= post.id.toString() + " " + post.userId + " " + post.title + " " + post.body
                    }
//                    binding.textViewForPost.text = string
                    postViewModel.setPosts(string)
                    binding.textViewForPost.text = postViewModel.getPost()
                }
                Status.LOADING-> Toast.makeText(applicationContext,"Loading",Toast.LENGTH_SHORT).show()
                Status.ERROR -> Toast.makeText(applicationContext,"Error ${posts.message}",Toast.LENGTH_SHORT).show()
            }
        })
    }
}