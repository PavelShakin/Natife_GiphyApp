package com.giphyapp.gif.screens.gifsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.os.bundleOf
import com.giphyapp.core.common.BundleKey.GIF_URI_KEY
import com.giphyapp.core.views.BaseFragment
import com.giphyapp.core.views.injectViewModel
import com.giphyapp.gif.R
import com.giphyapp.resources.components.GifsComponent
import com.giphyapp.resources.themes.AppTheme
import com.giphyapp.resources.widgets.HeaderWidgets

class GifsFragment : BaseFragment() {

    private val viewModel: GifsViewModel by lazy {
        injectViewModel(
            factory = providerFactory
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.obtainEvent(GifsEvent.Load)
        subscriptions()
        return ComposeView(requireContext())
            .apply {
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
                )
                viewModel.viewStates().observe(viewLifecycleOwner) { state ->
                    when (state) {
                        is GifsViewState.State -> {
                            setContent {
                                AppTheme {
                                    Scaffold(
                                        topBar = {
                                            HeaderWidgets.TopHeaderWithListGridSwitch(
                                                state = state.switchPosition,
                                                onChange = { position ->
                                                    viewModel.obtainEvent(
                                                        GifsEvent.OnSwitchPositionChanged(position)
                                                    )
                                                }
                                            )
                                        }
                                    ) { paddingValues ->
                                        paddingValues.calculateBottomPadding()
                                        GifsComponent(
                                            gifs = state.gifsList,
                                            onGifClick = {
                                                viewModel.obtainEvent(GifsEvent.OnGifClicked(it))
                                            },
                                            isLoading = state.isLoading,
                                            switchPosition = state.switchPosition
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }

    private fun subscriptions() {
        viewModel.viewActions().observe(viewLifecycleOwner) { action ->
            when (action) {
                is GifAction.NavigateToGifDetails -> {
                    val bundle = bundleOf(GIF_URI_KEY to action.uri)
                    navigateToAction(
                        R.id.navigate_to_GifDeatailsFragment,
                        bundle
                    )
                }
            }
        }
    }
}
