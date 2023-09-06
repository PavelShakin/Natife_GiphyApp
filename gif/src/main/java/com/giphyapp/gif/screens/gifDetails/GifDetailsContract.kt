package com.giphyapp.gif.screens.gifDetails

import com.giphyapp.core.common.GlobalConstants.emptyString

sealed class GifDetailsViewState {

    data class State(
        val uri: String = emptyString,
        val isLoading: Boolean = true
    ) : GifDetailsViewState()
}

sealed class GifDetailsAction

sealed class GifDetailsEvent {

    data class Load(val uri: String) : GifDetailsEvent()
}
