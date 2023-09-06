package com.giphyapp.domain.di.components

import android.app.Application
import com.giphyapp.data.di.components.DataComponent
import com.giphyapp.domain.di.annotation.DomainScope
import com.giphyapp.domain.di.modules.UseCasesModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        UseCasesModule::class
    ]
)
@DomainScope
interface DomainComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun dataComponent(dataComponent: DataComponent): Builder
        fun build(): DomainComponent
    }
}
