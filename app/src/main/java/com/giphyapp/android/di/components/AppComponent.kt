package com.giphyapp.android.di.components

import android.app.Application
import androidx.annotation.NonNull
import com.giphyapp.android.configuration.BaseApplication
import com.giphyapp.android.di.annotation.ApplicationScope
import com.giphyapp.android.di.modules.ActivityBuildersModule
import com.giphyapp.android.di.modules.AppModule
import com.giphyapp.data.di.modules.RepositoriesModule
import com.giphyapp.domain.di.components.DomainComponent
import com.giphyapp.domain.di.modules.UseCasesModule
import com.giphyapp.network.di.modules.ServicesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        UseCasesModule::class,
        ServicesModule::class,
        RepositoriesModule::class
    ]
)
@ApplicationScope
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(@NonNull application: Application): Builder

        @BindsInstance
        fun domainComponent(component: DomainComponent): Builder
        fun build(): AppComponent
    }
}
