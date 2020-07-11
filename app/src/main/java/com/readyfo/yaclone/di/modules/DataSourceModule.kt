package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.datasource.local.dao.HistoryDAO
import com.readyfo.yaclone.datasource.local.dao.LanguagesDAO
import com.readyfo.yaclone.datasource.local.datasourceimpl.FetchHistoryDataSourceImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.FetchLanguagesLocalDataSourceImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.SaveLanguagesInDataSourceImpl
import com.readyfo.yaclone.datasource.remote.datasourceimpl.FetchLanguagesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {
    @Provides
    fun provideFetchHistoryDataSource(dao: HistoryDAO) =
        FetchHistoryDataSourceImpl(dao = dao)

    @Provides
    fun provideFetchLanguagesLocalDataSource(dao: LanguagesDAO) =
        FetchLanguagesLocalDataSourceImpl(dao = dao)

    @Provides
    fun provideFetchLanguagesRemoteDataSource() =
        FetchLanguagesRemoteDataSourceImpl()

    @Provides
    fun provideSaveLanguagesInDataSource(dao: LanguagesDAO) =
        SaveLanguagesInDataSourceImpl(dao = dao)
}