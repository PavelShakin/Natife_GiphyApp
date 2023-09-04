package com.giphyapp.network.services

import com.giphyapp.core.models.api.GifApi
import com.giphyapp.network.config.GifAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GifService {
    @GET(value = GifAPI.TRENDING)
    suspend fun getGifs(
        @Query("limit") limit: Long = 30,
        @Query("offset") offset: Long = 0,
        @Query("rating") rating: String = "g",
        @Query("bundle") bundle: String = "messaging_non_clips"
    ): Call<List<GifApi>>
}