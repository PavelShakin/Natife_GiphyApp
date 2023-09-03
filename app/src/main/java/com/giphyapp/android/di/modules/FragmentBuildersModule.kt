package com.giphyapp.android.di.modules

import com.giphyapp.android.screens.splash.SplashFragment
import com.giphyapp.core.views.BaseFragment
import com.giphyapp.gif.screens.gifsList.GifsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuildersModule {

    //region Application
    @ContributesAndroidInjector
    fun contributeBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    fun contributeSplashFragment(): SplashFragment
    //endregion

    //region Gif
    @ContributesAndroidInjector
    fun contributeGifsListFragment(): GifsFragment
}
