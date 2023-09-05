package com.giphyapp.gif.screens.gifsList

import com.giphyapp.core.models.view.GifViewData

sealed class GifsViewState {
    data class State(
        val isLoading: Boolean = true,
        val gifsList: List<GifViewData> = emptyList()
    ) : GifsViewState()
}

sealed class GifAction
sealed class GifsEvent {
    data object Load : GifsEvent()
}
