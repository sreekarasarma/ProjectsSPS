package com.example.pixabaygallery.model

data class PixabayResponse(
    val hits: List<ImageData>
)

data class ImageData(
    val id: Int,
    val tags: String,
    val previewURL: String,
    val largeImageURL: String
)
