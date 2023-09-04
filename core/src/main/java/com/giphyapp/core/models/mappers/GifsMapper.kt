package com.giphyapp.core.models.mappers

import com.giphyapp.core.contracts.mappers.BaseMapper
import com.giphyapp.core.models.api.GifApi
import com.giphyapp.core.models.view.GifViewData
import javax.inject.Inject

class GifsMapper @Inject constructor() : BaseMapper<GifApi, GifViewData> {

    override fun toDomain(model: GifApi): GifViewData {
        return GifViewData(uri = model.uri)
    }

    override fun toEntity(model: GifViewData): GifApi {
        return GifApi(uri = model.uri)
    }
}
