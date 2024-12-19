package com.example.retrofitdemo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdemo.api.RetrofitClient
import com.example.retrofitdemo.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel : ViewModel() {

    val posts = mutableStateListOf<Post>()

    fun fetchPosts() {
        viewModelScope.launch {
            val response = getPostsFromApi()
            if (response.isSuccessful) {
                posts.clear()
                posts.addAll(response.body() ?: emptyList())
            }
        }
    }

    private suspend fun getPostsFromApi() = withContext(Dispatchers.IO) {
        RetrofitClient.apiService.getPosts()
    }
}
