package com.giphyapp.gif.screens.gifDetails

import android.content.res.Configuration
import com.giphyapp.core.common.GlobalConstants.emptyString

sealed class GifDetailsViewState {

    data class State(
        val uri: String = emptyString,
        val isLoading: Boolean = true,
        val configurationState: Configuration = Configuration()
    ) : GifDetailsViewState()
}

sealed class GifDetailsAction

sealed class GifDetailsEvent {

    data class Load(val uri: String) : GifDetailsEvent()
    data class ConfigurationChanged(val configuration: Configuration) : GifDetailsEvent()
}
