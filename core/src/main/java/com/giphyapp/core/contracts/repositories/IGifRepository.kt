package com.giphyapp.core.contracts.repositories

import com.giphyapp.core.models.api.GifApiResponse

interface IGifRepository {

    suspend fun getGifsList(): GifApiResponse
}
