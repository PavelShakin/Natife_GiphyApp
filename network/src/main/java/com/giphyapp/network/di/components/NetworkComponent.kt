package com.giphyapp.network.di.components

import android.app.Application
import com.giphyapp.network.di.annotations.NetworkScope
import com.giphyapp.network.di.modules.ServicesModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        ServicesModule::class
    ]
)
@NetworkScope
interface NetworkComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): NetworkComponent
    }
}
