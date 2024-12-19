package com.example.pixabaygallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixabaygallery.model.ImageData
import com.example.pixabaygallery.network.RetrofitInstance
import com.example.pixabaygallery.util.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _images = MutableStateFlow<List<ImageData>>(emptyList())
    val images: StateFlow<List<ImageData>> get() = _images

    fun fetchImages(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getImages(Constants.PIXABAY_API_KEY, query)
                _images.value = response.hits
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
