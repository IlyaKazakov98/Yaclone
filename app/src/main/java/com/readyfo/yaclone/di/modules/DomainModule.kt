package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.data.FetchHistoryRepositoryImpl
import com.readyfo.yaclone.data.FetchLanguagesRepositoryImpl
import com.readyfo.yaclone.domain.usecases.implementations.FetchHistoryUseCaseImpl
import com.readyfo.yaclone.domain.usecases.implementations.FetchLanguagesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideFetchHistoryUseCase(fetchHistoryRepository: FetchHistoryRepositoryImpl) =
        FetchHistoryUseCaseImpl(fetchHistoryRepository = fetchHistoryRepository)

    @Provides
    fun provideFetchLanguagesUseCase(fetchLanguagesRepository: FetchLanguagesRepositoryImpl) =
        FetchLanguagesUseCaseImpl(fetchLanguagesRepository = fetchLanguagesRepository)
}