package com.giphyapp.android.di.modules

import com.giphyapp.android.screens.base.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            FragmentBuildersModule::class,
            ViewModelFactoryModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}
