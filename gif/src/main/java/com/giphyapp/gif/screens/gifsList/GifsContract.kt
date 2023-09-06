package com.giphyapp.gif.screens.gifsList

import com.giphyapp.core.models.view.GifViewData
import com.giphyapp.resources.widgets.SwitchPosition

sealed class GifsViewState {
    data class State(
        val isLoading: Boolean = true,
        val gifsList: GifViewData = GifViewData(emptyList()),
        val switchPosition: SwitchPosition = SwitchPosition.Grid
    ) : GifsViewState()
}

sealed class GifAction {
    data class NavigateToGifDetails(val uri: String) : GifAction()
}
sealed class GifsEvent {
    data object Load : GifsEvent()
    data class OnSwitchPositionChanged(val switchPosition: SwitchPosition) : GifsEvent()
    data class OnGifClicked(val uri: String) : GifsEvent()
}
