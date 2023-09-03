package com.giphyapp.android.di.modules

import com.giphyapp.core.contracts.dispatchers.CoroutineDispatchers
import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideCoroutineDispatchers(): ICoroutineDispatchers {
        return CoroutineDispatchers()
    }
}
