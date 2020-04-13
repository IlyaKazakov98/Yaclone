package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.data.local.datasource.implementation.FetchHistoryDataSourceImpl
import com.readyfo.yaclone.data.repositories_impl.FetchHistoryRepositoryImpl
import com.readyfo.yaclone.domain.usecases.implementations.FetchHistoryUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideFetchHistoryUseCase(fetchHistoryRepository: FetchHistoryRepositoryImpl) =
        FetchHistoryUseCaseImpl(fetchHistoryRepository = fetchHistoryRepository)

    @Provides
    fun provideFetchHistoryRepository(fetchHistoryDataSourceImpl: FetchHistoryDataSourceImpl) =
        FetchHistoryRepositoryImpl(fetchHistoryDataSource = fetchHistoryDataSourceImpl)

    @Provides
    fun provideFetchHistoryDataSource() = FetchHistoryDataSourceImpl()
}