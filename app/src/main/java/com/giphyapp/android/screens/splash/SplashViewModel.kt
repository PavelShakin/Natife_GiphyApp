package com.giphyapp.android.screens.splash

import androidx.lifecycle.viewModelScope
import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import com.giphyapp.core.contracts.handlers.EventHandler
import com.giphyapp.core.views.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val defaultDispatchers: ICoroutineDispatchers
) : BaseViewModel<SplashViewState, SplashAction>(),
    EventHandler<SplashEvent> {

    companion object {
        private const val DEFAULT_DELAY = 2000L
    }

    init {
        viewState = SplashViewState.State(true)
    }

    override fun obtainEvent(event: SplashEvent) {
        when (event) {
            is SplashEvent.Load -> reduceLoad()
        }
    }

    private fun reduceLoad() {
        viewModelScope.launch {
            withContext(defaultDispatchers.io) {
                delay(DEFAULT_DELAY)
                viewAction = SplashAction.OnNextScreen
            }
        }
    }
}
