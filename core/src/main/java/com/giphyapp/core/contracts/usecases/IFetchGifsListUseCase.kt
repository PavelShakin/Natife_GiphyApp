package com.giphyapp.core.contracts.usecases

import com.giphyapp.core.models.view.GifViewData

interface IFetchGifsListUseCase {
    suspend fun invoke(): GifViewData
}
