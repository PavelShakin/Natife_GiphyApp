package com.giphyapp.data.di.components

import android.app.Application
import com.giphyapp.data.di.annotations.DataScope
import com.giphyapp.data.di.modules.RepositoriesModule
import com.giphyapp.network.di.NetworkComponent
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        RepositoriesModule::class
    ]
)
@DataScope
interface DataComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun networkComponent(component: NetworkComponent): Builder
        fun build(): DataComponent
    }
}
