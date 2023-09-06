package com.giphyapp.core.models.mappers

import com.giphyapp.core.contracts.mappers.BaseMapper
import com.giphyapp.core.models.api.GifApiResponse
import com.giphyapp.core.models.view.GifViewData

class GifsMapper : BaseMapper<GifApiResponse, GifViewData> {

    override fun toDomain(model: GifApiResponse): GifViewData {
        return GifViewData(resultList = model.data.map { it.images.original.url })
    }

    override fun toEntity(model: GifViewData): GifApiResponse {
        return GifApiResponse(emptyList())
    }
}
