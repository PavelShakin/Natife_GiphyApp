package com.giphyapp.network.services

import com.giphyapp.core.models.api.GifApiResponse
import com.giphyapp.network.config.GifAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GifService {
    @GET(value = GifAPI.TRENDING)
    suspend fun getGifs(
        @Query("api_key") apiKey: String = GifAPI.API_TOKEN,
        @Query("limit") limit: Long = 30,
        @Query("offset") offset: Long = 0,
        @Query("rating") rating: String = "g",
        @Query("bundle") bundle: String = "messaging_non_clips"
    ): Response<GifApiResponse>
}
