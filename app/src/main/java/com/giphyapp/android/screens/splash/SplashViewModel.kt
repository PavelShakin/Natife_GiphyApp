package com.giphyapp.android.screens.splash

import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import com.giphyapp.core.contracts.handlers.EventHandler
import com.giphyapp.core.views.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val defaultDispatchers: ICoroutineDispatchers
): BaseViewModel<SplashViewState, SplashAction>(),
    EventHandler<SplashEvent> {

    override fun obtainEvent(event: SplashEvent) {
        TODO("Not yet implemented")
    }
}