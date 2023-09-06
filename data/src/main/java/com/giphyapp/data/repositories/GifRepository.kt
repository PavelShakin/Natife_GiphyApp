package com.giphyapp.data.repositories

import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import com.giphyapp.core.contracts.repositories.IGifRepository
import com.giphyapp.core.models.api.GifApiResponse
import com.giphyapp.network.services.GifService
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GifRepository @Inject constructor(
    private val apiService: GifService,
    private val coroutineDispatchers: ICoroutineDispatchers
) : IGifRepository {

    override suspend fun getGifsList(): GifApiResponse {
        val response: Response<GifApiResponse> =
            withContext(coroutineDispatchers.io) {
                apiService.getGifs()
            }
        val result = if (response.isSuccessful) {
            response.body()?.data.orEmpty()
        } else {
            emptyList()
        }
        return GifApiResponse(result)
    }
}
