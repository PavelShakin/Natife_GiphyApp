package com.giphyapp.android.screens.splash

sealed class SplashViewState {

    data class State(
        val isLoading: Boolean = true
    ) : SplashViewState()
}

sealed class SplashAction {

    data object OnNextScreen : SplashAction()
}

sealed class SplashEvent {

    data object Load : SplashEvent()
}