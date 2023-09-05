package com.giphyapp.gif.screens.gifsList

import androidx.lifecycle.viewModelScope
import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import com.giphyapp.core.contracts.handlers.EventHandler
import com.giphyapp.core.contracts.usecases.IFetchGifsListUseCase
import com.giphyapp.core.views.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GifsViewModel @Inject constructor(
    private val defaultDispatcher: ICoroutineDispatchers,
    private val gifsListUseCase: IFetchGifsListUseCase
) : BaseViewModel<GifsViewState, GifAction>(),
    EventHandler<GifsEvent> {

    init {
        viewState = GifsViewState.State()
    }
    override fun obtainEvent(event: GifsEvent) {
        when (event) {
            is GifsEvent.Load -> reduceFetchGifsList()
        }
    }

    private fun reduceFetchGifsList() {
        setProgress(true)
        viewModelScope.launch {
            if (viewState is GifsViewState.State) {
                val gifsList = withContext(defaultDispatcher.io) {
                    gifsListUseCase.invoke()
                }
                viewState = (viewState as GifsViewState.State).copy(
                    gifsList = gifsList
                )
            }
        }
    }

    private fun setProgress(isLoading: Boolean = false) {
        if (viewState is GifsViewState.State) {
            viewState = (viewState as GifsViewState.State).copy(
                isLoading = isLoading
            )
        }
    }
}
