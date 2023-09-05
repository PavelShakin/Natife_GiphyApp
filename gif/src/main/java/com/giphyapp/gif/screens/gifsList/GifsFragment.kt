package com.giphyapp.gif.screens.gifsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.giphyapp.core.views.BaseFragment
import com.giphyapp.core.views.injectViewModel
import com.giphyapp.resources.components.GifsListComponent
import com.giphyapp.resources.themes.AppTheme

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
                                    Scaffold { paddingValues ->
                                        paddingValues.calculateBottomPadding()
                                        GifsListComponent(
                                            gifs = state.gifsList,
                                            onGifClick = {}
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }
}
