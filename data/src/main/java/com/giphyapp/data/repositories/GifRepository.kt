package com.giphyapp.data.repositories

import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import com.giphyapp.core.contracts.repositories.IGifRepository
import com.giphyapp.core.models.api.GifApi
import com.giphyapp.network.services.GifService
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GifRepository @Inject constructor(
    private val apiService: GifService,
    private val coroutineDispatchers: ICoroutineDispatchers
) : IGifRepository {

    override suspend fun getGifsList(): List<GifApi> {
        val response: Response<List<GifApi>> =
            withContext(coroutineDispatchers.io) {
                apiService.getGifs().execute()
            }
        return if (response.isSuccessful) {
            response.body().orEmpty()
        } else {
            emptyList()
        }
    }
}
