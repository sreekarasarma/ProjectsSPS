package com.example.pixabaygallery.network

import com.example.pixabaygallery.model.PixabayResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
    @GET("/api/")
    suspend fun getImages(
        @Query("key") apiKey: String,
        @Query("q") query: String
    ): PixabayResponse
}

object RetrofitInstance {
    val api: PixabayApi by lazy {
        Retrofit.Builder()
            .baseUrl(com.example.pixabaygallery.util.Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PixabayApi::class.java)
    }
}
