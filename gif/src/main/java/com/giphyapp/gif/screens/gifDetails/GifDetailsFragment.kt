package com.giphyapp.gif.screens.gifDetails

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.giphyapp.core.common.BundleKey
import com.giphyapp.core.views.BaseFragment
import com.giphyapp.core.views.injectViewModel
import com.giphyapp.resources.components.GifDetailsComponent
import com.giphyapp.resources.themes.AppTheme
import com.giphyapp.resources.widgets.HeaderWidgets.TopHeaderWithBackButton

class GifDetailsFragment : BaseFragment() {

    private val viewModel: GifDetailsViewModel by lazy {
        injectViewModel(
            factory = providerFactory
        )
    }

    private val uri: String
        get() = arguments?.getString(BundleKey.GIF_URI_KEY).orEmpty()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.obtainEvent(GifDetailsEvent.Load(uri))
        return ComposeView(requireContext())
            .apply {
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
                )
                viewModel.viewStates().observe(viewLifecycleOwner) { state ->
                    if (state is GifDetailsViewState.State) {
                        setContent {
                            AppTheme {
                                Scaffold(
                                    topBar = {
                                        TopHeaderWithBackButton(
                                            onBackClick = { goBack() }
                                        )
                                    }
                                ) { paddingValues ->
                                    paddingValues.calculateBottomPadding()
                                    GifDetailsComponent(
                                        uri = state.uri,
                                        configuration = state.configurationState
                                    )
                                }
                            }
                        }
                    }
                }
            }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        viewModel.obtainEvent(GifDetailsEvent.ConfigurationChanged(newConfig))
    }
}
