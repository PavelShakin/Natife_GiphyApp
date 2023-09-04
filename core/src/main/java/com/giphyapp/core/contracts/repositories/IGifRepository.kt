package com.giphyapp.core.contracts.repositories

import com.giphyapp.core.models.api.GifApi

interface IGifRepository {

    suspend fun getGifsList(): List<GifApi>
}