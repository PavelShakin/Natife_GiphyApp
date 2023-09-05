package com.giphyapp.data.di.modules

import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import com.giphyapp.core.contracts.repositories.IGifRepository
import com.giphyapp.data.repositories.GifRepository
import com.giphyapp.network.services.GifService
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideGifRepository(
        apiService: GifService,
        coroutineDispatchers: ICoroutineDispatchers
    ): IGifRepository {
        return GifRepository(
            apiService,
            coroutineDispatchers
        )
    }
}
