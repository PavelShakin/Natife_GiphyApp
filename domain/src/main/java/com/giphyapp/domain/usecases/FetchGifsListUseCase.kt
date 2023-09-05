package com.giphyapp.domain.usecases

import com.giphyapp.core.contracts.repositories.IGifRepository
import com.giphyapp.core.contracts.usecases.IFetchGifsListUseCase
import com.giphyapp.core.models.mappers.GifsMapper
import com.giphyapp.core.models.view.GifViewData
import com.giphyapp.domain.formatters.UriFormatter
import javax.inject.Inject

class FetchGifsListUseCase @Inject constructor(
    private val repository: IGifRepository
) : IFetchGifsListUseCase {

    private val mapper = GifsMapper()
    private val formatter = UriFormatter()

    override suspend fun invoke(): GifViewData {
        val list = mapper.toDomain(repository.getGifsList())
        val formattedList = list.resultList.map{ formatter.getCorrectLink(it) }
        return GifViewData(formattedList)
    }
}
