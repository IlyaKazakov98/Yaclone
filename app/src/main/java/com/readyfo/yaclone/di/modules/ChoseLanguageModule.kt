package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.data.FetchLanguagesRepositoryImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.FetchLanguagesLocalDataSourceImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.SaveLanguagesInDataSourceImpl
import com.readyfo.yaclone.datasource.remote.datasourceimpl.FetchLanguagesRemoteDataSourceImpl
import com.readyfo.yaclone.domain.usecases.implementations.FetchLanguagesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class ChoseLanguageModule {
    @Provides
    fun provideFetchHistoryUseCase(fetchLanguagesRepository: FetchLanguagesRepositoryImpl) =
        FetchLanguagesUseCaseImpl(fetchLanguagesRepository = fetchLanguagesRepository)

    @Provides
    fun provideFetchHistoryRepository(
        fetchLanguagesLocalDataSource: FetchLanguagesLocalDataSourceImpl,
        fetchLanguagesRemoteDataSource: FetchLanguagesRemoteDataSourceImpl,
        saveLanguagesInDataSource: SaveLanguagesInDataSourceImpl
    ) =
        FetchLanguagesRepositoryImpl(
            fetchLanguagesLocalDataSource = fetchLanguagesLocalDataSource,
            fetchLanguagesRemoteDataSource = fetchLanguagesRemoteDataSource,
            saveLanguagesInDataSource = saveLanguagesInDataSource
        )

    @Provides
    fun provideFetchLanguagesLocalDataSource() =
        FetchLanguagesLocalDataSourceImpl()

    @Provides
    fun provideFetchLanguagesRemoteDataSource() =
        FetchLanguagesRemoteDataSourceImpl()

    @Provides
    fun provideSaveLanguagesInDataSource() =
        SaveLanguagesInDataSourceImpl()
}