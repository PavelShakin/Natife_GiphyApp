package com.giphyapp.domain.usecases

import com.giphyapp.core.contracts.repositories.IGifRepository
import com.giphyapp.core.contracts.usecases.IFetchGifsListUseCase
import com.giphyapp.core.models.mappers.GifsMapper
import com.giphyapp.core.models.view.GifViewData
import javax.inject.Inject

class FetchGifsListUseCase @Inject constructor(
    private val repository: IGifRepository
) : IFetchGifsListUseCase {

    private val mapper = GifsMapper()

    override suspend fun invoke(): List<GifViewData> {
        return repository.getGifsList().map(mapper::toDomain)
    }
}
