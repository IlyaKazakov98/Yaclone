package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.data.FetchHistoryRepositoryImpl
import com.readyfo.yaclone.data.FetchLanguagesRepositoryImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.FetchHistoryDataSourceImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.FetchLanguagesLocalDataSourceImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.SaveLanguagesInDataSourceImpl
import com.readyfo.yaclone.datasource.remote.datasourceimpl.FetchLanguagesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideFetchHistoryRepository(fetchHistoryDataSourceImpl: FetchHistoryDataSourceImpl) =
        FetchHistoryRepositoryImpl(
            fetchHistoryDataSource = fetchHistoryDataSourceImpl
        )

    @Provides
    fun provideFetchLanguagesRepository(
        fetchLanguagesLocalDataSource: FetchLanguagesLocalDataSourceImpl,
        fetchLanguagesRemoteDataSource: FetchLanguagesRemoteDataSourceImpl,
        saveLanguagesInDataSource: SaveLanguagesInDataSourceImpl
    ) =
        FetchLanguagesRepositoryImpl(
            fetchLanguagesLocalDataSource = fetchLanguagesLocalDataSource,
            fetchLanguagesRemoteDataSource = fetchLanguagesRemoteDataSource,
            saveLanguagesInDataSource = saveLanguagesInDataSource
        )
}