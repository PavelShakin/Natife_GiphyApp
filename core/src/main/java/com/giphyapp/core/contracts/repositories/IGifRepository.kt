package com.giphyapp.core.contracts.repositories

import com.giphyapp.core.models.view.GifViewData

interface IGifRepository {

    suspend fun getGifsList(): List<GifViewData>
}
