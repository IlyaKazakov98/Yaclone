package com.readyfo.yaclone.di.modules

import com.readyfo.yaclone.data.datasource.local.FetchHistoryDataSource
import com.readyfo.yaclone.data.datasource.local.FetchLanguagesLocalDataSource
import com.readyfo.yaclone.data.datasource.local.SaveLanguagesInDataSource
import com.readyfo.yaclone.data.datasource.remote.FetchLanguagesRemoteDataSource
import com.readyfo.yaclone.datasource.local.datasourceimpl.FetchHistoryDataSourceImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.FetchLanguagesLocalDataSourceImpl
import com.readyfo.yaclone.datasource.local.datasourceimpl.SaveLanguagesInDataSourceImpl
import com.readyfo.yaclone.datasource.remote.datasourceimpl.FetchLanguagesRemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single <FetchHistoryDataSource> { FetchHistoryDataSourceImpl(get()) }
    single <FetchLanguagesLocalDataSource> { FetchLanguagesLocalDataSourceImpl(get()) }
    single <FetchLanguagesRemoteDataSource> { FetchLanguagesRemoteDataSourceImpl() }
    single <SaveLanguagesInDataSource> { SaveLanguagesInDataSourceImpl(get()) }
}