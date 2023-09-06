package com.giphyapp.domain.di.modules

import com.giphyapp.core.contracts.repositories.IGifRepository
import com.giphyapp.core.contracts.usecases.IFetchGifsListUseCase
import com.giphyapp.domain.usecases.FetchGifsListUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideFetchGifsListUseCase(
        repository: IGifRepository
    ): IFetchGifsListUseCase {
        return FetchGifsListUseCase(repository)
    }
}
