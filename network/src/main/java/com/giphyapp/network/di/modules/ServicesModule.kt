package com.giphyapp.network.di.modules

import com.giphyapp.network.config.GifAPI
import com.giphyapp.network.services.GifService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ServicesModule {

    @Provides
    fun provideGifService(): GifService {
        return Retrofit.Builder()
            .baseUrl(GifAPI.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GifService::class.java)
    }
}
