package com.giphyapp.android.configuration

import com.giphyapp.android.di.components.DaggerAppComponent
import com.giphyapp.data.di.components.DaggerDataComponent
import com.giphyapp.data.di.components.DataComponent
import com.giphyapp.domain.di.components.DaggerDomainComponent
import com.giphyapp.domain.di.components.DomainComponent
import com.giphyapp.network.di.components.DaggerNetworkComponent
import com.giphyapp.network.di.components.NetworkComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .domainComponent(provideDomainComponent())
            .build()
    }

    private fun provideDomainComponent(): DomainComponent {
        return DaggerDomainComponent
            .builder()
            .application(this)
            .dataComponent(provideDataComponent())
            .build()
    }

    private fun provideDataComponent(): DataComponent {
        return DaggerDataComponent
            .builder()
            .application(this)
            .networkComponent(provideNetworkComponent())
            .build()
    }

    private fun provideNetworkComponent(): NetworkComponent {
        return DaggerNetworkComponent
            .builder()
            .application(this)
            .build()
    }
}
