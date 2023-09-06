package com.giphyapp.gif.screens.gifDetails

import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import com.giphyapp.core.contracts.handlers.EventHandler
import com.giphyapp.core.views.BaseViewModel
import javax.inject.Inject

class GifDetailsViewModel @Inject constructor(
    private val defaultDispatcher: ICoroutineDispatchers
) :
    BaseViewModel<GifDetailsViewState, GifDetailsAction>(),
    EventHandler<GifDetailsEvent> {

    init {
        viewState = GifDetailsViewState.State()
    }

    override fun obtainEvent(event: GifDetailsEvent) {
        when (event) {
            is GifDetailsEvent.Load -> reduceLoadGif(event)
            is GifDetailsEvent.ConfigurationChanged -> reduceConfigurationChanged(event)
        }
    }

    private fun reduceLoadGif(event: GifDetailsEvent.Load) {
        setProgress(true)
        if (viewState is GifDetailsViewState.State) {
            viewState = (viewState as GifDetailsViewState.State).copy(
                uri = event.uri,
                isLoading = false
            )
        }
    }

    private fun reduceConfigurationChanged(event: GifDetailsEvent.ConfigurationChanged) {
        if (viewState is GifDetailsViewState.State) {
            viewState = (viewState as GifDetailsViewState.State).copy(
                configurationState = event.configuration
            )
        }
    }

    private fun setProgress(isLoading: Boolean = true) {
        if (viewState is GifDetailsViewState.State) {
            viewState = (viewState as GifDetailsViewState.State).copy(
                isLoading = isLoading
            )
        }
    }
}
