package com.giphyapp.android.screens.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.giphyapp.core.common.GlobalConstants.emptyString
import com.giphyapp.core.navigation.NavRoutes
import com.giphyapp.core.views.BaseFragment
import com.giphyapp.core.views.injectViewModel
import com.giphyapp.resources.themes.AppTheme
import com.giphyapp.resources.themes.GiphyAppTheme

class SplashFragment : BaseFragment() {

    private val viewModel: SplashViewModel by lazy {
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
                setContent {
                    AppTheme {
                        Body()
                    }
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.obtainEvent(SplashEvent.Load)
        subscriptions()
    }

    private fun subscriptions() {
        viewModel.viewActions().observe(viewLifecycleOwner) {
            when (it) {
                SplashAction.OnNextScreen -> {
                    navigateToDeepLink(NavRoutes.getMapPagePath())
                }
            }
        }
    }

    @Composable
    private fun Body() {
        Box(
            modifier = Modifier
                .background(GiphyAppTheme.colors.primaryColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .size(150.dp),
                painter = painterResource(id = com.giphyapp.resources.R.drawable.ic_logo),
                contentDescription = emptyString
            )
        }
    }
}
