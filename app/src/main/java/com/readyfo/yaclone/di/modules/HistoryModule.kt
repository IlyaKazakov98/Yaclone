package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.data.FetchHistoryRepositoryImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.FetchHistoryDataSourceImpl
import com.readyfo.yaclone.domain.usecases.implementations.FetchHistoryUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class HistoryModule {
    @Provides
    fun provideFetchHistoryUseCase(fetchHistoryRepository: FetchHistoryRepositoryImpl) =
        FetchHistoryUseCaseImpl(fetchHistoryRepository = fetchHistoryRepository)

    @Provides
    fun provideFetchHistoryRepository(fetchHistoryDataSourceImpl: FetchHistoryDataSourceImpl) =
        FetchHistoryRepositoryImpl(
            fetchHistoryDataSource = fetchHistoryDataSourceImpl
        )

    @Provides
    fun provideFetchHistoryDataSource() =
        FetchHistoryDataSourceImpl()
}