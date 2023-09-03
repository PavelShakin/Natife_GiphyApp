package com.giphyapp.android.screens.splash

import com.giphyapp.core.views.BaseFragment
import com.giphyapp.core.views.injectViewModel

class SplashFragment : BaseFragment() {

    private val viewModel: SplashViewModel by lazy {
        injectViewModel(
            factory = providerFactory
        )
    }
}