package com.giphyapp.android.di.modules

import androidx.lifecycle.ViewModel
import com.giphyapp.android.screens.splash.SplashViewModel
import com.giphyapp.core.views.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel
}