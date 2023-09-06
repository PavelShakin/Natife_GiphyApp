package com.giphyapp.android.di.modules

import androidx.lifecycle.ViewModel
import com.giphyapp.android.screens.splash.SplashViewModel
import com.giphyapp.core.views.ViewModelKey
import com.giphyapp.gif.screens.gifDetails.GifDetailsViewModel
import com.giphyapp.gif.screens.gifsList.GifsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GifsViewModel::class)
    fun bindGifsViewModel(viewModel: GifsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GifDetailsViewModel::class)
    fun bindGifDetailsViewModel(viewModel: GifDetailsViewModel): ViewModel
}
